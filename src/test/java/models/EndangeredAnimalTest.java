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
//    public void getMonsters_retrievesAllMonstersFromDatabase_monstersList() {
//        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino", EndangeredAnimal.HEALTHY, EndangeredAnimal.YOUNG);
//        EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
//        endangeredAnimalDao.add(endangeredAnimal);
//        endangeredAnimal.add();
//        Monster firstMonster = new Monster("Bubbles", testPerson.getId());
//        firstMonster.save();
//        Monster secondMonster = new Monster("Spud", testPerson.getId());
//        secondMonster.save();
//        Monster[] monsters = new Monster[] { firstMonster, secondMonster };
//        assertTrue(testPerson.getMonsters().containsAll(Arrays.asList(monsters)));

}
