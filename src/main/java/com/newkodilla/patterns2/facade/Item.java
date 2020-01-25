package com.newkodilla.patterns2.facade;

public class Item
{
    private final Long productID;
    private final double qty;

    public Item (Long productID, double qty)
    {
        this.productID = productID;
        this.qty = qty;
    }

    public Long getProductID()
    {
        return this.productID;
    }

    public double getQty()
    {
        return this.qty;
    }
}
