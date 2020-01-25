package com.newkodilla.patterns2.facade.api;

import com.newkodilla.patterns2.facade.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public final class OrderFacade
{
    @Autowired
    private ShopService shopService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);

    public void processOrder(final OrderDTO order, final Long userID) throws OrderProcessingException
    {
        boolean wasError = false;
        long orderID = shopService.openOrder(userID);
        LOGGER.info("Registering new order, ID: " + orderID);
        if (orderID < 0)
        {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORISED);
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORISED);
        }
        try
        {
            for (ItemDTO orderItem : order.getItems())
            {
                LOGGER.info("Adding item " + orderItem.getProductID() + ", " + orderItem.getQuantity() + " pcs");
                shopService.addItem(orderID, orderItem.getProductID(), orderItem.getQuantity());
            }
            BigDecimal value = shopService.calculateValue(orderID);
            LOGGER.info("Order value is: " + value + " USD");
            if (!shopService.doPayment(orderID))
            {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Payment for order was done");
            if (!shopService.verifyOrder(orderID))
            {
                LOGGER.error(OrderProcessingException.ERR_VERIFICATION_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }
            LOGGER.info("Order is ready to submit");
            if (!shopService.submitOrder(orderID))
            {
                LOGGER.error(OrderProcessingException.ERR_SUBMITTING_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            }
            LOGGER.info("Order " + orderID + " submitted");
        }
        finally
        {
            if (wasError)
            {
                LOGGER.info("Cancelling order " + orderID);
                shopService.cancelOrder(orderID);
            }
        }
    }
}
