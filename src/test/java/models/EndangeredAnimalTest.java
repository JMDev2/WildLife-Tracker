package models;

import DAO.EndangeredAnimalDao;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void save_insertsObjectIntoDatabase_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino", EndangeredAnimal.HEALTHY, EndangeredAnimal.YOUNG);
        EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
        endangeredAnimalDao.add(endangeredAnimal);
        assertTrue(endangeredAnimalDao.getEndangeredAnimal().get(0).equals(endangeredAnimal));
    }

}
