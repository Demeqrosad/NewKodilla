package com.newkodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public interface TaxiOrder
{
    public BigDecimal getCost();
    public String getDescription();
}
