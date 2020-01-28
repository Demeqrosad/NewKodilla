package com.newkodilla.patterns2.decorator.pizza;

public class MushroomsPizzaOrderDecorator extends AbstractPizzaOrderDecorator
{
    public MushroomsPizzaOrderDecorator(PizzaOrder pizzaOrder)
    {
        super(pizzaOrder);
    }

    @Override
    public double getPrice()
    {
        return super.getPrice() + 3;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + ", mushrooms";
    }
}
