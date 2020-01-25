package com.newkodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService
{
    private final List<Order> orders = new ArrayList<>();
    @Autowired
    private Authenticator authenticator;
    @Autowired
    private ProductService productService;

    public Long openOrder(Long userID)
    {
        if (authenticator.isAuthenticated(userID))
        {
            Long maxOrder = (long)orders.stream()
                    .mapToInt(o -> o.getOrderID().intValue())
                    .max().orElse(0);
            orders.add(new Order(maxOrder + 1, userID, productService));
            return maxOrder + 1;
        }
        else
        {
            return -1L;
        }
    }

    public void addItem(long orderID, Long productID, double qty)
    {
        orders.stream()
                .filter(o -> o.getOrderID().equals(orderID))
                .forEach(o -> o.getItems().add(new Item(productID, qty)));
    }

    public boolean removeItem(Long orderID, Long productID)
    {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderID().equals(orderID))
                .iterator();
        while (orderIterator.hasNext())
        {
            Order theOrder = orderIterator.next();
            int orderSize = theOrder.getItems().size();
            for (int n = 0; n < theOrder.getItems().size(); n++)
            {
                if (theOrder.getItems().get(n).getProductID().equals(productID))
                {
                    theOrder.getItems().remove(n);
                    return true;
                }
            }
        }
        return false;
    }

    public BigDecimal calculateValue(Long orderID)
    {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderID().equals(orderID))
                .iterator();
        while (orderIterator.hasNext())
        {
            Order theOrder = orderIterator.next();
            return theOrder.calculateValue();
        }
        return BigDecimal.ZERO;
    }

    public boolean doPayment(Long orderID)
    {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderID().equals(orderID))
                .iterator();
        while (orderIterator.hasNext())
        {
            Order theOrder = orderIterator.next();
            if (theOrder.isPaid())
            {
                return true;
            }
            else
            {
                Random generator = new Random();
                theOrder.setPaid(generator.nextBoolean());
                return theOrder.isPaid();
            }
        }
        return false;
    }

    public boolean verifyOrder(Long orderID)
    {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderID().equals(orderID))
                .iterator();
        while (orderIterator.hasNext())
        {
            Order theOrder = orderIterator.next();
            boolean result  = theOrder.isPaid();
            Random generator = new Random();
            if (!theOrder.isVerified())
            {
                theOrder.setVerified(result && generator.nextBoolean());
            }
            return theOrder.isVerified();
        }
        return false;
    }

    public boolean submitOrder(Long orderID)
    {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderID().equals(orderID))
                .iterator();
        while (orderIterator.hasNext())
        {
            Order theOrder = orderIterator.next();
            if (theOrder.isVerified())
            {
                theOrder.setSubmitted(true);
            }
            return theOrder.isSubmitted();
        }
        return false;
    }

    public void cancelOrder(Long orderID)
    {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderID().equals(orderID))
                .iterator();
        while (orderIterator.hasNext())
        {
            Order theOrder = orderIterator.next();
            orders.remove(theOrder);
        }
    }
}

