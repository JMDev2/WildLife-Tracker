package DAO;

import models.NonEndangeredAnimal;

import java.util.List;

public interface NonEndangeredAnimalManagement {
    //CREATE
    void add(NonEndangeredAnimal nonEndangeredAnimal);

    //UPDATE
    void update(NonEndangeredAnimal nonEndangeredAnimal);

    //READ
    NonEndangeredAnimal getNonEndangeredAnimalById(int id);
    List<NonEndangeredAnimal> getNonEndangeredAnimal();

    //DELETE
    void deleteNonEndangeredAnimal(int id);
}
