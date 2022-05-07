package models;

import DAO.EndangeredAnimalDao;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
//    @Test
//    public void find_returnsMonsterWithSameId_secondMonster() {
//        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino", EndangeredAnimal.HEALTHY, EndangeredAnimal.YOUNG);
//        EndangeredAnimalDao endangeredAnimalDao1 = new EndangeredAnimalDao();
//        endangeredAnimalDao1.add(endangeredAnimal);
//        EndangeredAnimal endangeredAnimal2 = new EndangeredAnimal("Rhino", EndangeredAnimal.HEALTHY, EndangeredAnimal.YOUNG);
//        endangeredAnimalDao1.add(endangeredAnimal2);
//        assertEquals(endangeredAnimalDao1.EndangeredAnimal(1), endangeredAnimal2);
//    }
}