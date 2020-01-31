package com.newkodilla.patterns2.decorator.pizza;

public class OnionPizzaOrderDecorator extends AbstractPizzaOrderDecorator
{
    public OnionPizzaOrderDecorator(PizzaOrder pizzaOrder)
    {
        super(pizzaOrder);
    }

    @Override
    public double getPrice()
    {
        return super.getPrice() + 2.00;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + ", onion";
    }
}
