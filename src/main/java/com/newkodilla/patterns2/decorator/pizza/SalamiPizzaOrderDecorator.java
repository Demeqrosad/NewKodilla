package com.newkodilla.patterns2.decorator.pizza;

public class SalamiPizzaOrderDecorator extends AbstractPizzaOrderDecorator
{
    public SalamiPizzaOrderDecorator(PizzaOrder pizzaOrder)
    {
        super(pizzaOrder);
    }

    @Override
    public double getPrice()
    {
        return super.getPrice() + 3.00;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + ", salami";
    }
}
