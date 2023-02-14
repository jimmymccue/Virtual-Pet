package virtual_pet;

public class RoboticCat extends RoboticPet {

    final private String petType = "ROBOTIC_CAT";

    public RoboticCat(String name, String id) {
        super(name, id);
        this.getType();
    }

    public String getType() {
        return petType;
    }
}
