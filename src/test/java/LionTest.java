import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final boolean expectedMane;
    private final String sex;

    public LionTest(boolean expectedMane, String sex) {
        this.expectedMane = expectedMane;
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {true, "Самец"},
            {false, "Самка"},
    });
}
    @Mock
    private Feline feline;
    private Lion lion;

    @Test
        public void LionHasManeTest() throws Exception {
        lion = new Lion(sex, feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void LionHasManeExceptionTest() throws Exception {
        lion = new Lion("Неизвестно", feline);
    }

    @Test
    public void LionGetKittensTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }
    
    @Test
    public void LionGetFoodTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
        List<String> LionGetFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(LionGetFood);
        assertEquals(LionGetFood, lion.getFood());
    }
}
