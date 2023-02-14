package virtual_pet;

public class OrganicDog extends OrganicPet {

    private int bathroomNeeds = 0;
    private String petType = "";

    public OrganicDog(String name, String id) {
        super(name, id);
        this.petType = "ORGANIC_DOG";
    }

    public String getType() {
        return petType;
    }

    public int getBathroomNeeds() {
        return bathroomNeeds;
    }

    public void setBathroomNeeds(int bathroomNeeds) {
        this.bathroomNeeds = bathroomNeeds;
    }

    public void walkPet() {
        if (boredomLevel > 24) {
            boredomLevel = boredomLevel - 25;
        } else {
            boredomLevel = 0;
        }
        bathroomNeeds = 0;
    }

    public void tick() {
        this.setHungerLevel(this.getHungerLevel() + 10);
        this.setThirstLevel(this.getThirstLevel() + 10);
        this.setBoredomLevel(this.getBoredomLevel() + 10);
        this.setCageSoilLevel(this.getCageSoilLevel() + 10);
        this.setBathroomNeeds(this.getBathroomNeeds() + 10);
    }

    //Returns a string telling the user the current status of his\her pet.
    public String petStatus() {
        return "(" + this.id + ")" + this.name + "'s health: \n\t\t\t\t   hunger level:  " + hungerLevel +
                "\n\t\t\t\t   thirst level:  " + thirstLevel +
                "\n\t\t\t\t   boredom level: " + boredomLevel +
                "\n\t\t\t\t   Cage soil level:  " + getCageSoilLevel() +
                "\n\t\t\t\t   Bathroom needs level: " + getBathroomNeeds() + "\n";
    }
}
