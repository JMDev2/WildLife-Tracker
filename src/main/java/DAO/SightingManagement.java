package DAO;

import models.EndangeredAnimal;
import models.Sighting;

import java.util.List;

public interface SightingManagement {
    //CREATE
    void add(Sighting sighting);

    //READ
    Sighting getSightingById(int id);
    List<Sighting>getAllSightings();

    //UPDATE
    void update(Sighting sighting);

    //DELETE
    void delete(int id);
}
