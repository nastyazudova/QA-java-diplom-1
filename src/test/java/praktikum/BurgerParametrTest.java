package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private static final double DELTA = 1e-15;
    Burger burger;

    String bunName;
    float bunPrice;
    String sauceName;
    float saucePrice;
    String fillingName;
    float fillingPrice;

    public BurgerParametrTest(String bunName, float bunPrice, String sauceName, float saucePrice, String fillingName, float fillingPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.sauceName = sauceName;
        this.saucePrice = saucePrice;
        this.fillingName = fillingName;
        this.fillingPrice = fillingPrice;
    }

    @Mock
    private Bun bun;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    @Parameterized.Parameters
    public static Object[][] ingredientsData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988, "Соус фирменный Space Sauce", 80, "Хрустящие минеральные кольца", 300},
                {"Краторная булка N-200i", 1255, "Соус Spicy-X", 15, "Мини-салат Экзо-Плантаго", 4400}
        };
    }

    @Test
    public void getPriceTest(){
        burger = new Burger();

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(bun);

        Mockito.when(sauce.getPrice()).thenReturn(saucePrice);
        burger.addIngredient(sauce);

        Mockito.when(filling.getPrice()).thenReturn(fillingPrice);
        burger.addIngredient(filling);

        float actual = burger.getPrice();
        System.out.println("actual: " + actual);
        float expected = bun.getPrice() * 2 + sauce.getPrice() + filling.getPrice();
        System.out.println("expected: " + expected);
        assertEquals(expected, actual, DELTA);
    }
}
