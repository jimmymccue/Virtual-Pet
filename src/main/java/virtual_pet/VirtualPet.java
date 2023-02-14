package virtual_pet;

abstract public class VirtualPet implements VirtualPetInterface {

    final protected String id;
    final protected String name;
    final private String petType = "VirtualPet";

    public VirtualPet(String name, String id) {
        this.id = id;
        this.name = name;
    }

    final public String getId() {
        return id;
    }


    final public String getName() {
        return name;
    }

    public void walkPet() {
    }

    public void cleanLitter() {

    }

    public void cleanCage() {

    }
}
