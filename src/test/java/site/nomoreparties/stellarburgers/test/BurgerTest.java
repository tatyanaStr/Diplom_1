package site.nomoreparties.stellarburgers.test;

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
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void setBunsTest(){
        var burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        var burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.get(0), ingredient);
    }

    @Test
    public void removeIngredientTest(){
        var burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Ингредиент не удален", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        var burger = new Burger();
        var ingredient1 = new Ingredient(IngredientType.FILLING, "Name", 1f);
        var ingredient2 = new Ingredient(IngredientType.FILLING, "Name", 1f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(burger.ingredients.get(0), ingredient2);
    }

    @Test
    public void getReceipt(){
        var burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Название");
        Mockito.when(ingredient.getPrice()).thenReturn(10.0f);
        Assert.assertEquals("Ошибка получение бургера",
                "(==== Булочка ====)\r\n" +
                        "= sauce Название =\r\n" +
                        "(==== Булочка ====)\r\n\r\n" +
                        "Price: 10,000000\r\n", burger.getReceipt());
    }
}
