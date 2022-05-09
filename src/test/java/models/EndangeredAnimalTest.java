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
    @Test
    public void squad_instantiatesgetName_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino", EndangeredAnimal.HEALTHY, EndangeredAnimal.YOUNG);
        EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
        assertEquals("Rhino", endangeredAnimal.getName());
    }
    @Test
    public void squad_instantiatesgethealth_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino", EndangeredAnimal.HEALTHY, EndangeredAnimal.YOUNG);
        EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
        assertEquals("healthy", endangeredAnimal.getHealth());
    }
    @Test
    public void save_assignsIdToObject() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino", EndangeredAnimal.HEALTHY, EndangeredAnimal.YOUNG);
        EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
        endangeredAnimalDao.add(endangeredAnimal);
        EndangeredAnimal endangeredAnimal1 = endangeredAnimalDao.getEndangeredAnimal().get(0);
        assertEquals(endangeredAnimal.getId(), endangeredAnimal1.getId());
    }

}