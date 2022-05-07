package DAO;

import models.EndangeredAnimal;

import java.util.List;

public interface EndangeredAnimalManagement {
    //add animal
    void add(EndangeredAnimal endangeredAnimal);

    //Update
    void update(EndangeredAnimal endangeredAnimal);

    //Read
    EndangeredAnimal EndangeredAnimal(int id);
    List<EndangeredAnimal> getEndangeredAnimal();

    //Delete
    void deleteEndangeredAnimal(int id);
}
