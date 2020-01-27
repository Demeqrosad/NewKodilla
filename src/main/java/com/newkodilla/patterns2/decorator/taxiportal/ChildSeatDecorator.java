package com.newkodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class ChildSeatDecorator extends AbstractTaxiOrderDecorator
{
    public ChildSeatDecorator(TaxiOrder taxiOrder)
    {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost()
    {
        //hardcoded stub cost = 20
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " + child seat";
    }
}
