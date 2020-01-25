package com.newkodilla.patterns2.facade.api;

public final class ItemDTO
{
    private final Long productID;
    private final double quantity;

    public ItemDTO(final Long productID, final double quantity)
    {
        this.productID =productID;
        this.quantity = quantity;
    }

    public Long getProductID()
    {
        return this.productID;
    }

    public double getQuantity()
    {
        return this.quantity;
    }
}
