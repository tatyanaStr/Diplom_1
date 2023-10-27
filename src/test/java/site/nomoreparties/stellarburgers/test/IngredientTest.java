package site.nomoreparties.stellarburgers.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    IngredientType type;

    @Test
    public void getNameTest(){
        var name = "name";
        var price = 10.0f;
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("name", ingredient.getName());
    }

    @Test
    public void getPriceTest(){
        var name = "name";
        var price = 10.0f;
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(10.0f, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getTypeTest(){
        var name = "name";
        var price = 10.0f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

}
