package models;

import java.security.Timestamp;
import java.util.Objects;

public class Sighting {
    private int id;
    private String name;
    private String location;
    private String ranger;
    private Timestamp seen;

//    public Sighting( String name, String location, String ranger) {
//        this.id = id;
//        this.name = name;
//        this.location = location;
//        this.ranger = ranger;
//        this.seen = seen;

           public Sighting( String name, String location, String ranger) {


               this.name = name;
               this.location = location;
               this.ranger = ranger;
               this.seen = seen;

        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id &&
                Objects.equals(name, sighting.name) &&
                Objects.equals(location, sighting.location) &&
                Objects.equals(ranger, sighting.ranger);
//                Objects.equals(timeStamp, sighting.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, ranger);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRanger() {
        return ranger;
    }

    public void setRanger(String ranger) {
        this.ranger = ranger;
    }

    public Timestamp getSeen() {
        return seen;
    }


    //    public Timestamp getTimeStamp() {
//        return timeStamp;
//    }

//    public void setTimeStamp(Timestamp timeStamp) {
//        this.timeStamp = timeStamp;
//    }
}
