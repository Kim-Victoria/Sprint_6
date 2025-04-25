import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {
    private Lion lion;
    private Feline feline;
    private final boolean expectedMane;
    private final String sex;

    public ParameterizedLionTest(boolean expectedMane, String sex) {
        this.expectedMane = expectedMane;
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, "Самец"},
                {false, "Самка"},
        });
    }

    @Test
    public void lionHasManeTest() throws Exception {
        lion = new Lion(sex, feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionHasManeExceptionTest() throws Exception {
        lion = new Lion("Неизвестно", feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }
}
