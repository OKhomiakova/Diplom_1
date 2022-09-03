package ru.practicum.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient, secondIngredient;

    @Test
    public void setBunsSetsBunsToBurger() {
        // Arrange
        Burger burger = new Burger();
        // Act
        burger.setBuns(bun);
        // Assert
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientAddsIngredientToBurger() {
        // Arrange
        Burger burger = new Burger();
        // Act
        burger.addIngredient(firstIngredient);
        // Assert
        Assert.assertEquals(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemovesIngredientFromBurger(){
        // Arrange
        Burger burger = new Burger();
        // Act
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        // Assert
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientMovesIngredientFromBurger() {
        // Arrange
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        int expectedIndex = 1;
        // Act
        burger.moveIngredient(0,1);
        // Assert
        Assert.assertEquals(expectedIndex, burger.ingredients.lastIndexOf(firstIngredient));
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        // Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        float expectedPrice = 7455.00f;
        // Act
        Mockito.when(bun.getPrice()).thenReturn(988.00f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(4142.00f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(1337.00f);
        // Assert
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptReturnsCorrectString() {
        // Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String expectedReceipt = "(==== Флюоресцентная булка R2-D3 ====)\n= sauce Соус фирменный Space Sauce =\n= filling Говяжий метеорит (отбивная) =\n(==== Флюоресцентная булка R2-D3 ====)\n\nPrice: 5056.000000\n";
        // Act
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(988.00f);
        Mockito.when(firstIngredient.getName()).thenReturn("Соус фирменный Space Sauce");
        Mockito.when(firstIngredient.getPrice()).thenReturn(80.00f);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getName()).thenReturn("Говяжий метеорит (отбивная)");
        Mockito.when(secondIngredient.getPrice()).thenReturn(3000.00f);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        // Assert
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }


}
