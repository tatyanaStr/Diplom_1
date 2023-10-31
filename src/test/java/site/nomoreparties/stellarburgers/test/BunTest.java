package site.nomoreparties.stellarburgers.test;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void nameTest(){
        var name = "Name";
        var price = 10f;
        var bun = new Bun(name, price);
        Assert.assertEquals("Ошибка получения названия булочки", bun.getName(), name);
    }
}
