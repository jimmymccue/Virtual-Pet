package virtual_pet;

public class OrganicCat extends OrganicPet {

    private int litterBoxSoilLevel = 0;
    final private String petType = "ORGANIC_CAT";

    public OrganicCat(String name, String id) {
        super(name, id);
    }

    public String getType() {
        return petType;
    }

    public int getLitterBoxSoilLevel() {
        return litterBoxSoilLevel;
    }

    public void setLitterBoxSoilLevel(int litterBoxSoilLevel) {
        this.litterBoxSoilLevel = litterBoxSoilLevel;
    }

    public void cleanLitter() {
        litterBoxSoilLevel = 0;
    }

    @Override
    public void tick() {
        this.setHungerLevel(this.getHungerLevel() + 10);
        this.setThirstLevel(this.getThirstLevel() + 10);
        this.setBoredomLevel(this.getBoredomLevel() + 10);
        this.setCageSoilLevel(this.getCageSoilLevel() + 10);
        this.setLitterBoxSoilLevel(this.getLitterBoxSoilLevel() + 10);
    }

    //Returns a string telling the user the current status of his\her pet.
    public String petStatus() {
        return "(" + this.id + ")" + this.name + "'s health: \n\t\t\t\t   hunger level:  " + hungerLevel +
                "\n\t\t\t\t   thirst level:  " + thirstLevel +
                "\n\t\t\t\t   boredom level:  " + boredomLevel +
                "\n\t\t\t\t   litter box level: " + litterBoxSoilLevel + "\n";
    }
}
