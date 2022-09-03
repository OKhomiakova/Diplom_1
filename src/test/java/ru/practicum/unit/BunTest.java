package ru.practicum.unit;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("Флюоресцентная булка R2-D3", 988.00f);

    @Test
    public void getNameReturnsCorrectBunName() {
        //Arrange
        String expectedBunName = "Флюоресцентная булка R2-D3";
        //Act
        String actualBunName = bun.getName();
        //Assert
        Assert.assertEquals(expectedBunName, actualBunName);
    }

    @Test
    public void getPriceReturnsCorrectBunPrice() {
        //Arrange
        float expectedBunPrice = 988.00f;
        //Act
        float actualBunPrice = bun.getPrice();
        //Assert
        Assert.assertEquals(expectedBunPrice, actualBunPrice, 0);
    }
}
