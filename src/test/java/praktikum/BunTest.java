package praktikum;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private static final double DELTA = 1e-15;
    String name;
    float price;
    public BunTest(String name, float price) {
        this.name=name;
        this.price=price;
    }

    @Parameterized.Parameters
    public static Object[][] bunsData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255}
        };
    }

    @Test//проверка верного присваивания имени
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        String expected = name;
        assertEquals(expected, actual);
    }

    @Test//проверка верного присваивания цены
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        float expected = price;
        assertEquals(expected, actual, DELTA);
    }

}
