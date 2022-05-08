package DAO;

import models.DB;
import models.EndangeredAnimal;
import models.Sighting;
import org.sql2o.Connection;

import java.util.List;

import static models.DB.sql2o;

public class SightingDao implements SightingManagement {
    //CREATE
    @Override
    public void add(Sighting sighting) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO sighting(location, ranger) VALUES (:location, :ranger)";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("location", sighting.getLocation())
                    .addParameter("ranger", sighting.getRangerName())
                    .executeUpdate()
                    .getKey();
            sighting.setId(id);
        }

    }

    //finding specific
    @Override
    public Sighting getSightingById(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sighting where id=:id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;

        }
    }

    //Listing
    @Override
    public List<Sighting> getAllSightings() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM sighting";
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }


    //UPDATE
    @Override
    public void update(Sighting sighting) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE sighting SET location = :location, ranger = :ranger WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("location", sighting.getLocation())
                    .addParameter("ranger", sighting.getRangerName())
                    .executeUpdate();
        }

    }


    //DELETE
    @Override
    public void delete(int id) {
            try (Connection con = sql2o.open()) {
                String sql = "DELETE FROM sighting WHERE id =:id";
                con.createQuery(sql)
                        .addParameter("id", id)
                        .executeUpdate();
            }

        }
    }


