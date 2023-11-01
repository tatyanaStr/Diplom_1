package site.nomoreparties.stellarburgers.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class GetBunNameParametrizedTest {

    private final String name;

    public GetBunNameParametrizedTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerPrice() {
        return new Object[][]{
                {""},
                {null},
                {"Name"},
                {"Название"},
                {"<h1>123</h2>"},
                {"1234567891011121314151617181910"},
                {"@&*"}
        };
    }

    @Test
    public void nameTest(){
        var price = 10f;
        var bun = new Bun(name, price);
        Assert.assertEquals("Ошибка получения названия булочки", name, bun.getName());
    }
}
