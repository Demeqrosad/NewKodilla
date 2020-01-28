package com.newkodilla.patterns2.decorator.pizza;

public class BasicPizzaOrder implements PizzaOrder
{

    @Override
    public double getPrice()
    {
        return 15.00;
    }

    @Override
    public String getDescription()
    {
        return "Pizza with tomato sauce and cheese";
    }
}
