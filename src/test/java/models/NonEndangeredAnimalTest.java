package models;

import DAO.EndangeredAnimalDao;
import DAO.NonEndangeredAnimalDao;
import models.EndangeredAnimal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NonEndangeredAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void save_insertsObjectIntoDatabase_true() {
        NonEndangeredAnimal nonendangeredAnimal = new NonEndangeredAnimal("rhino");
        NonEndangeredAnimalDao nonendangeredAnimalDao = new NonEndangeredAnimalDao();
        nonendangeredAnimalDao.add(nonendangeredAnimal);
        assertTrue(nonendangeredAnimalDao.getNonEndangeredAnimal().get(0).equals(nonendangeredAnimal));
    }
}