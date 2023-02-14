package virtual_pet;

abstract public class OrganicPet extends VirtualPet {

    protected int hungerLevel = 1;
    protected int thirstLevel = 1;
    protected int boredomLevel = 1;
    private int cageSoilLevel = 0;

    public OrganicPet(String name, String id) {
        super(name, id);
    }


    public int getCageSoilLevel() {
        return cageSoilLevel;
    }

    public void setCageSoilLevel(int cageSoilLevel) {
        this.cageSoilLevel = cageSoilLevel;
    }

//    public String getId() {
//        return id;
//    }

//    public String getName() {
//        return name;
//    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public void setThirstLevel(int thirstLevel) {
        this.thirstLevel = thirstLevel;
    }

    public int getBoredomLevel() {
        return boredomLevel;
    }

    @Override
    public void cleanLitter() {

    }

    public void setBoredomLevel(int boredomLevel) {
        this.boredomLevel = boredomLevel;
    }

    public void cleanCage() {
        cageSoilLevel = 0;
    }

    @Override
    public void oilRobot() {

    }

    @Override
    public void chargeRobot() {

    }

    public void feed() {
        if (hungerLevel > 24) {
            hungerLevel = hungerLevel - 25;
        } else {
            hungerLevel = 0;
        }
    }

    public void water() {
        if (thirstLevel > 24) {
            thirstLevel = thirstLevel - 25;
        } else {
            thirstLevel = 0;
        }
    }

    public void play() {
        if (boredomLevel > 24) {
            boredomLevel = boredomLevel - 25;
        } else {
            boredomLevel = 0;
        }
    }

    public void tick() {
        this.setHungerLevel(this.getHungerLevel() + 10);
        this.setThirstLevel(this.getThirstLevel() + 10);
        this.setBoredomLevel(this.getBoredomLevel() + 10);
        this.setCageSoilLevel(this.getCageSoilLevel() + 10);
    }

    //Returns a string telling the user the current status of his\her pet.
    public String petStatus() {
        return "(" + this.id + ")" + this.name + "'s health: \n\t\t\t\t   hunger level:  " + hungerLevel +
                "\n\t\t\t\t   thirst level:  " + thirstLevel +
                "\n\t\t\t\t   boredom level: " + boredomLevel + "\n";
    }


    //stretch task
    //Give the pet the ability to take care of some of its own needs.
    //Pets are not robots - they usually have some sort of
    // self-determination! When tick() is called, you might want to
    // have your pet take a look at its needs and address one,
    // prioritizing whichever need is highest. You could also make
    // your pet uncooperative - when the user tries to feed the pet,
    // for example, you might make the pet refuse to eat if it is bored.
    // Remember how we created an instance of the Random class to create
    // a random number generator? You might want to incorporate that.


    //Create a visual representation of your pet.
    //Rather than using numbers to convey your pet’s status, you could
    // have some sort of visual representation of the pet. I.e., instead
    // of printing hunger: 50, you could use smileys or ASCII art to show
    // hunger when hunger >= 50.
}
