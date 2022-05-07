import models.EndangeredAnimal;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonEndangeredAnimalTest {

    @Test
    public void all_returnsAllInstancesOfArr_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Animal");
        assertEquals("Animal", endangeredAnimal.getName());
    }
}
