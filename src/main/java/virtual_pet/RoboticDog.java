package virtual_pet;

public class RoboticDog extends RoboticPet {

    final private String petType = "ROBOTIC_DOG";

    public RoboticDog(String name, String id) {
        super(name, id);
    }

    public String getType() {
        return petType;
    }
}
