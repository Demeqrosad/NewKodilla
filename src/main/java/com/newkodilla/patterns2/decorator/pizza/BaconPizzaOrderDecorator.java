package com.newkodilla.patterns2.decorator.pizza;

public class BaconPizzaOrderDecorator extends AbstractPizzaOrderDecorator
{
    public BaconPizzaOrderDecorator(PizzaOrder pizzaOrder)
    {
        super(pizzaOrder);
    }

    @Override
    public double getPrice()
    {
        return super.getPrice() + 3.50;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + ", bacon";
    }
}
