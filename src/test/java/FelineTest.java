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

    @Test
    public void felineEatFoodTest() throws Exception {
        Feline feline = spy(new Feline());
        List<String> mockedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(mockedFoodList);
        List<String> foodList = feline.eatMeat();
        assertEquals(mockedFoodList, foodList);
    }

    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void felineGetKittensTest() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
    @Test
    public void felineKittensCountTest() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens(1);
        assertEquals(1, kittensCount);
    }
}