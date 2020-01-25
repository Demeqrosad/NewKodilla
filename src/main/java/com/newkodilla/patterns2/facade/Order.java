package com.newkodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order
{
    private ProductService productService;
    private final List<Item> items = new ArrayList<>();
    private final Long orderID;
    private final Long userID;
    private boolean isPaid = false;
    private boolean isVerified = false;
    private boolean isSubmitted = false;

    public Order(Long orderID, Long userID, ProductService productService)
    {
        this.orderID = orderID;
        this.userID = userID;
        this.productService = productService;
    }

    public BigDecimal calculateValue()
    {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items)
        {
            sum = sum.add(productService.getPrice(item.getProductID()))
                    .multiply(new BigDecimal(item.getQty()));
        }
        return sum;
    }

    public List<Item> getItems()
    {
        return this.items;
    }

    public Long getOrderID()
    {
        return this.orderID;
    }

    public Long getUserID()
    {
        return this.userID;
    }

    public boolean isPaid()
    {
        return this.isPaid;
    }

    public void setPaid(boolean paid)
    {
        this.isPaid = paid;
    }

    public boolean isVerified()
    {
        return this.isVerified;
    }

    public void setVerified(boolean verified)
    {
        this.isVerified = verified;
    }

    public boolean isSubmitted()
    {
        return this.isSubmitted;
    }

    public void setSubmitted(boolean submitted)
    {
        this.isSubmitted = submitted;
    }
}

