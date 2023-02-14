package virtual_pet;

abstract public class RoboticPet extends VirtualPet {

    private int rustLevel = 0;
    private int batteryPercent = 100;
    private String petType = "";

    public RoboticPet(String name, String id) {
        super(name, id);
    }




    public int getRustLevel() {
        return rustLevel;
    }

    public void setRustLevel(int rustLevel) {
        this.rustLevel = rustLevel;
    }

    public int getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(int batteryPercent) {
        this.batteryPercent = batteryPercent;
    }

    public void oilRobot() {
        rustLevel = rustLevel / 2;
    }

    public void chargeRobot() {
        this.batteryPercent = 100;
    }

    public void play() {

    }

    @Override
    public void walkPet() {
        batteryPercent = batteryPercent - 25;
        if (rustLevel >= 10) {
            rustLevel = rustLevel - 10;
        } else {
            rustLevel = 0;
        }
    }

    public void tick() {
        this.setRustLevel(this.getRustLevel() + 2);
        this.setBatteryPercent(this.getBatteryPercent() - 5);
    }

    @Override
    public void feed() {

    }

    @Override
    public void water() {

    }

    @Override
    public int getHungerLevel() {
        return 0;
    }

    @Override
    public int getThirstLevel() {
        return 0;
    }

    @Override
    public int getBoredomLevel() {
        return 0;
    }

    //Returns a string telling the user the current status of his\her pet.
    public String petStatus() {
        return "(" + this.id + ")" + this.name + "'s health: \n\t\t\t\t   rust level:  " +
                getRustLevel() + "\n\t\t\t\t   battery level:  " + getBatteryPercent() + "\n";
    }
}



