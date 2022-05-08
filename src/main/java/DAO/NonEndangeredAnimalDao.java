package DAO;

import models.DB;
import models.EndangeredAnimal;
import models.NonEndangeredAnimal;
import org.sql2o.Connection;

import java.util.List;

import static models.DB.sql2o;

public class NonEndangeredAnimalDao implements NonEndangeredAnimalManagement {
        //CREATE
    @Override
    public void add(NonEndangeredAnimal nonEndangeredAnimal) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO animals(name) VALUES (:name )";
            nonEndangeredAnimal.id = (int) con.createQuery(sql, true)
                    .addParameter("name", nonEndangeredAnimal.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    //UPDATE
    @Override
    public void update(NonEndangeredAnimal nonEndangeredAnimal) {
        try(Connection con = sql2o.open()){
            String sql = "UPDATE animals SET name = :name WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", nonEndangeredAnimal.name)
                    .executeUpdate();
        }
    }

    //findsAll

    @Override
    public NonEndangeredAnimal getNonEndangeredAnimalById(int id) {
            try (Connection con = DB.sql2o.open()) {
                String sql = "SELECT * FROM animals where id=:id";
                NonEndangeredAnimal nonendangeredAnimal = con.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetchFirst(NonEndangeredAnimal.class);
                return nonendangeredAnimal;

            }
        }

    //READ
    @Override
    public List<NonEndangeredAnimal> getNonEndangeredAnimal() {
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM animals";
            return con.createQuery(sql).executeAndFetch(NonEndangeredAnimal.class);
        }
    }
    //DELETE
    @Override
    public void deleteNonEndangeredAnimal(int id) {
        try (Connection con = sql2o.open()){
            String sql = "DELETE FROM animals WHERE id =:id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }
}
