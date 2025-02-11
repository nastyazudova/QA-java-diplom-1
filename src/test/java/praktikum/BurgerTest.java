package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final double DELTA = 1e-15;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Bun actual = burger.bun;
        assertEquals(bun, actual);
    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        List<Ingredient> expected = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;
        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> expected = List.of();
        List<Ingredient> actual = burger.ingredients;
        assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        List<Ingredient> expected = List.of(filling, sauce);
        List<Ingredient> actual = burger.ingredients;
        assertEquals(expected, actual);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(1225F);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус традиционный галактический");
        Mockito.when(ingredient.getPrice()).thenReturn(15F);
        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String expected = receipt.toString();
        String actual = burger.getReceipt();

        assertEquals("Incorrect burger receipt", expected, actual);
    }


    @Test
    public void getPriceTest(){
        Burger burger = new Burger();

        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf("1225"));
        burger.setBuns(bun);

        Mockito.when(sauce.getPrice()).thenReturn(Float.valueOf("15"));
        burger.addIngredient(sauce);

        Mockito.when(filling.getPrice()).thenReturn(Float.valueOf("300"));
        burger.addIngredient(filling);

        float actual = burger.getPrice();
        System.out.println("actual: " + actual);
        float expected = bun.getPrice() * 2 + sauce.getPrice() + filling.getPrice();
        System.out.println("expected: " + expected);
        assertEquals(expected, actual, DELTA);
    }


}
