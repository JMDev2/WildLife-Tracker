package models;

public class EndangeredAnimal extends Animal {
    private  String health;
    private String age;


    private static final String HEALTHY = "healthy";
    private static final String ILL = "ill";
    private static  final String OKAY = "okay";
    private static final String NEWBORN = "newborn";
    private static final String YOUNG = "young";
    private static final String ADULT = "adult";
    public EndangeredAnimal(String name, String age, String health) {
        this.name = name;
        this.age = age;
        this.health= health;


    }


}
