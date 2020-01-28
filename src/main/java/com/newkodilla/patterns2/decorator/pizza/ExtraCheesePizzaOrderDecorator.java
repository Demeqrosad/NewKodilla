package com.newkodilla.patterns2.decorator.pizza;

public class ExtraCheesePizzaOrderDecorator extends AbstractPizzaOrderDecorator
{
    public ExtraCheesePizzaOrderDecorator(PizzaOrder pizzaOrder)
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
        return super.getDescription() + ", extra cheese";
    }
}
