package com.newkodilla.patterns2.decorator.pizza;

public abstract class AbstractPizzaOrderDecorator implements PizzaOrder
{
    private final PizzaOrder pizzaOrder;

    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder)
    {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public double getPrice()
    {
        return this.pizzaOrder.getPrice();
    }

    @Override
    public String getDescription()
    {
        return this.pizzaOrder.getDescription();
    }
}
