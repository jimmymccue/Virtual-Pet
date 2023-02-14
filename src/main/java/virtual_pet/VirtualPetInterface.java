package virtual_pet;

public interface VirtualPetInterface {
    public String getId();

    public String getName();

    public String getType();

    public void play();

    public void walkPet();

    public void tick();

    public String petStatus();

    public void feed();

    public void water();

    public int getHungerLevel();

    public int getThirstLevel();

    public int getBoredomLevel();

    public void cleanLitter();

    public void cleanCage();

    public void oilRobot();

    public void chargeRobot();
}
