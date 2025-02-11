package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private static final double DELTA = 1e-15;
    IngredientType type;
    String name;
    float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientsData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", 90},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337},
                {IngredientType.FILLING, "Плоды Фалленианского дерева", 874}
        };
    }

    @Test//проверка верного присваивания ТИПА
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = String.valueOf(ingredient.getType());
        String expected = String.valueOf(type);
        assertEquals(expected, actual);
    }

    @Test//проверка верного присваивания ИМЕНИ
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        String expected = name;
        assertEquals(expected, actual);
    }

    @Test//проверка верного присваивания ЦЕНЫ
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        float expected = price;
        assertEquals(expected, actual, DELTA);
    }



}
