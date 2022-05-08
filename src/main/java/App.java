package models;

import models.Animal;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("heroName");
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newanimal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("heroName");
            return new ModelAndView(model, "newanimal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            try {
                Animal animal = new Animal(name);
                animal.add();
            } catch (IllegalArgumentException exception) {
                System.out.println("Please enter an animal name.");
            }
            response.redirect("/animals");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());
    }
}
