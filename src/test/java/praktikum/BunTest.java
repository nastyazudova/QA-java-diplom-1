package praktikum;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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
    public static Object[][] Data() {
        return new Object[][]{
                {"op", 33},
                {"pp", 55}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        String expected = name;
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        float expected = price;
        assertEquals(expected, actual, DELTA);
    }

}
