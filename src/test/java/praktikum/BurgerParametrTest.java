package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrTest {
    private static final double DELTA = 1e-15;
    Burger burger;
    Ingredient sauce;
    Ingredient filling;
    String name;
    float price;

    public BurgerParametrTest(String name, float price) {
        this.name=name;
        this.price=price;
    }

    @Parameterized.Parameters
    public static Object[][] Data() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255}
        };
    }

    @Test
    public void getPriceTest(){
        burger = new Burger();
        Bun bun = new Bun(name, price);
        sauce = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80);
        filling = new Ingredient(IngredientType.FILLING, "Хрустящие минеральные кольца", 300);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float actual = burger.getPrice();
        float expected = bun.getPrice() * 2 + sauce.price + filling.price;
        assertEquals(expected, actual, DELTA);
    }
}
