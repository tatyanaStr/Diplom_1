package site.nomoreparties.stellarburgers.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class GetBunPriceParametrizedTest {

    private final float price;

    public GetBunPriceParametrizedTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerPrice() {
        return new Object[][]{
                {30.0f},
                {0},
                {0.01f},
                {9999.99f},
                {10},
                {-0.01f}
        };
    }

    @Test
    public void priceTest(){
        var name = "Name";
        var bun = new Bun(name, price);
        Assert.assertEquals("Ошибка получения стоимости булочки", price, bun.getPrice(), 0.0f);
    }
}
