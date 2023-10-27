package site.nomoreparties.stellarburgers.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class GetBurgerPriceParametrizedTest {
    private final int COUNT;
    private final float BUN_PRICE;
    private final float INGREDIENT_PRICE;
    private final float TOTAL_PRICE;

    public GetBurgerPriceParametrizedTest(int count, float bunPrice, float ingredientPrice, float totalPrice) {
        this.COUNT = count;
        this.BUN_PRICE = bunPrice;
        this.INGREDIENT_PRICE = ingredientPrice;
        this.TOTAL_PRICE = totalPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerPrice() {
        return new Object[][]{
                {1, 10.0f, 10.0f, 30.0f},
                {2, 10.0f, 20.0f, 60.0f},
                {10, 10.0f, 100.0f, 1020.0f}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void getPriceTest(){
        var burger = new Burger();
        burger.setBuns(bun);

        for (int i = 0; i<COUNT; i++) {
            burger.addIngredient(ingredient);
        }
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        Assert.assertEquals("Ошибка в получении стоимости бургера", TOTAL_PRICE, burger.getPrice(), 0.0f);
    }
}
