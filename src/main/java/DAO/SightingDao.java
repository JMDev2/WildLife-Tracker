package DAO;

import models.DB;
import models.Sighting;
import org.sql2o.Connection;

import java.util.List;

import static models.DB.sql2o;

public class SightingDao implements SightingManagement {
    //CREATE
    @Override
    public void add(Sighting sighting) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO sightings(location, ranger,name,seen) VALUES (:location, :ranger, :name, now());";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("location", sighting.getLocation())
                    .addParameter("ranger", sighting.getRanger())
                    .addParameter("name", sighting.getName())
                    .executeUpdate()
                    .getKey();
            sighting.setId(id);
        }

    }

    //finding specific
    @Override
    public Sighting getSightingById(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
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
            String sql = "SELECT * FROM sightings";
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }


    //UPDATE
    @Override
    public void update(Sighting sighting) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE sightings SET location = :location, ranger = :ranger, :name = name WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("location", sighting.getLocation())
                    .addParameter("ranger", sighting.getRanger())
                    .executeUpdate();
        }

    }


    //DELETE
    @Override
    public void delete(int id) {
            try (Connection con = sql2o.open()) {
                String sql = "DELETE FROM sightings WHERE id =:id";
                con.createQuery(sql)
                        .addParameter("id", id)
                        .executeUpdate();
            }

        }
    }


