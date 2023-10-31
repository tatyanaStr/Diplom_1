package site.nomoreparties.stellarburgers.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class GetPriceParametrizedTest {

    private final float price;
    private final boolean result;

    public GetPriceParametrizedTest(float price, boolean result) {
        this.price = price;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerPrice() {
        return new Object[][]{
                {30.0f, true},
                {0, true},
                {0.01f, true},
                {9999.99f, true},
                {10, true},
                {-0,01f, false}
        };
    }

    @Test
    public void priceTest(){
        var name = "Name";
        var bun = new Bun(name, price);
        Assert.assertEquals("Ошибка получения стоимости булочки", bun.getPrice() == price, result);
    }
}
