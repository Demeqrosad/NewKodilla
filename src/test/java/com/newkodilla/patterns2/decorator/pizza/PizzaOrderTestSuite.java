package com.newkodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

public class PizzaOrderTestSuite
{
    @Test
    public void testMargaritaOrder()
    {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OreganoPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheesePizzaOrderDecorator(pizzaOrder);
        //When
        double pizzaPrice = pizzaOrder.getPrice();
        String pizzaIngredients = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals(20, pizzaPrice, 0.1);
        Assert.assertEquals("Pizza with tomato sauce and cheese" +
                ", oregano, extra cheese", pizzaIngredients);
        System.out.println("\nMargarita\n" + "Price: " +
                pizzaPrice + " PLN\n" + pizzaIngredients);
    }

    @Test
    public void testFunghiOrder()
    {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OreganoPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MushroomsPizzaOrderDecorator(pizzaOrder);
        //When
        double pizzaPrice = pizzaOrder.getPrice();
        String pizzaIngredients = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals(20, pizzaPrice, 0.1);
        Assert.assertEquals("Pizza with tomato sauce and cheese" +
                ", oregano, mushrooms", pizzaIngredients);
        System.out.println("\nFunghi\n" + "Price: " +
                pizzaPrice + " PLN\n" + pizzaIngredients);
    }

    @Test
    public void testWeneziaOrder()
    {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OreganoPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MushroomsPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new BaconPizzaOrderDecorator(pizzaOrder);
        //When
        double pizzaPrice = pizzaOrder.getPrice();
        String pizzaIngredients = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals(23.5, pizzaPrice, 0.1);
        Assert.assertEquals("Pizza with tomato sauce and cheese" +
                ", oregano, mushrooms, bacon", pizzaIngredients);
        System.out.println("\nWenezia\n" + "Price: " +
                pizzaPrice + " PLN\n" + pizzaIngredients);
    }

    @Test
    public void testVegaOrder()
    {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OreganoPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MushroomsPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new OnionPizzaOrderDecorator(pizzaOrder);
        //When
        double pizzaPrice = pizzaOrder.getPrice();
        String pizzaIngredients = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals(22, pizzaPrice, 0.1);
        Assert.assertEquals("Pizza with tomato sauce and cheese" +
                ", oregano, mushrooms, onion", pizzaIngredients);
        System.out.println("\nVega\n" + "Price: " +
                pizzaPrice + " PLN\n" + pizzaIngredients);
    }

    @Test
    public void testPepperoniOrder()
    {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OreganoPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MushroomsPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new SalamiPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new PepperoniPizzaOrderDecorator(pizzaOrder);
        //When
        double pizzaPrice = pizzaOrder.getPrice();
        String pizzaIngredients = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals(25.5, pizzaPrice, 0.1);
        Assert.assertEquals("Pizza with tomato sauce and cheese" +
                ", oregano, mushrooms, salami, pepperoni", pizzaIngredients);
        System.out.println("\nPepperoni\n" + "Price: " +
                pizzaPrice + " PLN\n" + pizzaIngredients);
    }
}
