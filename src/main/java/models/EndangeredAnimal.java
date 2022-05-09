package models;

public class EndangeredAnimal extends Animal {
    private   String health;
    private String age;


    public static final String HEALTHY = "healthy";
    public static final String ILL = "ill";
    public static  final String OKAY = "okay";
    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";
    public EndangeredAnimal(String name, String health, String age) {
        if(name.equals("")){
            throw new IllegalArgumentException("Please enter all input fields.");
        }

        this.name = name;
        this.age = age;
        this.health= health;


    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }
}
