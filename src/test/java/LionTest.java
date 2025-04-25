import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {
    private Lion lion;

    @Mock
    private Feline feline;

    @Test
    public void lionGetKittensTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }
    
    @Test
    public void lionGetFoodTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
        List<String> LionGetFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(LionGetFood);
        assertEquals(LionGetFood, lion.getFood());
    }
}
