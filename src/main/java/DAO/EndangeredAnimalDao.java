package DAO;

import models.DB;
import models.EndangeredAnimal;
import org.sql2o.Connection;


import java.util.List;


import static models.DB.sql2o;

public class EndangeredAnimalDao implements EndangeredAnimalManagement{
        //CREATE
    @Override
    public void add(EndangeredAnimal endangeredAnimal) {
        try(Connection con = sql2o.open()){
            String sql = "INSERT INTO animals(name, health, age) VALUES (:name, :health, :age )";
            endangeredAnimal.id = (int) con.createQuery(sql, true)
                    .addParameter("name", endangeredAnimal.name)
                    .addParameter("health", endangeredAnimal.getHealth())
                    .addParameter("age", endangeredAnimal.getAge())
                    .executeUpdate()
                    .getKey();
        }
    }
        //UPDATE
    @Override
    public void update(EndangeredAnimal endangeredAnimal) {
        try(Connection con = sql2o.open()){
            String sql = "UPDATE animals SET name = :name WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id", endangeredAnimal.id)
                    .addParameter("name", endangeredAnimal.name)
                    .executeUpdate();
        }
    }

    @Override
    public EndangeredAnimal EndangeredAnimal(int id) {
        return null;
    }
            //READ

    @Override
    public List<EndangeredAnimal> getEndangeredAnimal() {
        try(Connection con = sql2o.open()){
                String sql = "SELECT * FROM animals";
                 return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }

        //DELETE
    @Override
    public void deleteEndangeredAnimal(int id) {
        try (Connection con = sql2o.open()){
            String sql = "DELETE FROM animals WHERE id =:id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }


    }

}