package site.nomoreparties.stellarburgers.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Test
    public void nameTest(){
        var name = "Name";
        var price = 10f;
        var bun = new Bun(name, price);
        Assert.assertEquals("Ошибка получения названия булочки", bun.getName(), name);
    }

    @Test
    public void priceTest(){
        var name = "Name";
        var price = 10f;
        var bun = new Bun(name, price);
        Assert.assertEquals("Ошибка получения стоимости булочки", bun.getPrice(), price, 0.0f);
    }
}
