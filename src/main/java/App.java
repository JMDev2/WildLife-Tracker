import DAO.EndangeredAnimalDao;
import DAO.NonEndangeredAnimalDao;
import DAO.SightingDao;
import models.Animal;
import models.EndangeredAnimal;
import models.NonEndangeredAnimal;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("heroName");
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

//        new animal

        get("/newanimal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            String heroName = request.queryParams("name");
            return new ModelAndView(model, "newanimal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/newanimalsdetails/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String animalName = request.queryParams("name");
            NonEndangeredAnimal nonEndangeredAnimal = new NonEndangeredAnimal(animalName);
            NonEndangeredAnimalDao nonEndangeredAnimalDao = new NonEndangeredAnimalDao();
            nonEndangeredAnimalDao.add(nonEndangeredAnimal);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());



//        endangeredanimal
        get("/newendangeredanimal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            String heroName = request.queryParams("name");
            return new ModelAndView(model, "newendangeredanimal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangeredAnimaldetails/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String animalName = request.queryParams("name");
            String animalhealth = request.queryParams("health");
            String animalAge = request.queryParams("age");
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName, animalhealth,animalAge);
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            endangeredAnimalDao.add(endangeredAnimal);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());


//        sighting
        get("/newsighting/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            String heroName = request.queryParams("name");
            return new ModelAndView(model, "newsighting.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightingdetails/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            String animalName = request.queryParams("animalName");
            Sighting sighting = new Sighting (location, rangerName, animalName);
            SightingDao sightingDao = new SightingDao();
            sightingDao.add(sighting);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

//        display path animals
        get("/allanimals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            String heroName = request.queryParams("name");
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            model.put("animals", endangeredAnimalDao.getEndangeredAnimal());
//            SightingDao sightingDao = new SightingDao();
//            model.put("sight", sightingDao.getAllSightings());
            return new ModelAndView(model, "allanimals.hbs");
        }, new HandlebarsTemplateEngine());

//        display sightings
        get("/sightingdetails/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            SightingDao sightingDao = new SightingDao();
            model.put("sight", sightingDao.getAllSightings());
            return new ModelAndView(model, "sightingdetails.hbs");
        }, new HandlebarsTemplateEngine());

        get("/index", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            SightingDao sightingDao = new SightingDao();
            model.put("sight", sightingDao.getAllSightings());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete an individual animal
        get("/animal/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int deletedAnimal = parseInt(request.params("id"));
            NonEndangeredAnimalDao nonEndangeredAnimalDao = new NonEndangeredAnimalDao();
            nonEndangeredAnimalDao.deleteNonEndangeredAnimal(deletedAnimal);
            response.redirect("/allanimals/new");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/sighting/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int deletedSighting = parseInt(request.params("id"));
            SightingDao sightingDao = new SightingDao();
            sightingDao.delete(deletedSighting);
            response.redirect("/sightingdetails/new");
            return null;
        }, new HandlebarsTemplateEngine());



    }
}
