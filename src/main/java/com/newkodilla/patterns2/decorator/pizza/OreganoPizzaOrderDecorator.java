package com.newkodilla.patterns2.decorator.pizza;

public class OreganoPizzaOrderDecorator extends AbstractPizzaOrderDecorator
{
    public OreganoPizzaOrderDecorator(PizzaOrder pizzaOrder)
    {
        super(pizzaOrder);
    }

    @Override
    public double getPrice()
    {
        return super.getPrice() + 2;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + ", oregano";
    }
}
