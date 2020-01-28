package com.newkodilla.patterns2.decorator.pizza;

public class PepperoniPizzaOrderDecorator extends AbstractPizzaOrderDecorator
{
    public PepperoniPizzaOrderDecorator(PizzaOrder pizzaOrder)
    {
        super(pizzaOrder);
    }

    @Override
    public double getPrice()
    {
        return super.getPrice() + 2.50;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + ", pepperoni";
    }
}
