import com.example.Animal;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    private Animal animal;

    @Test
    public void FelineEatFoodTest() throws Exception {
        Feline feline = spy(new Feline());
        List<String> mockedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(mockedFoodList);
        List<String> foodList = feline.eatMeat();
        assertEquals(mockedFoodList, foodList);
    }

    @Test
    public void FelineGetFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void FelineGetKittensTest() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
    @Test
    public void FelineKittensCountTest() {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        int kittensCount = feline.getKittens(1);
        assertEquals(1, kittensCount);
    }
}