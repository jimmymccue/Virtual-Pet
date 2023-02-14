package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganicPetTest {

    @Test
    void cleanCage() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testPet.setCageSoilLevel(100);
        testPet.cleanCage();
        assertEquals(0, testPet.getCageSoilLevel());
    }

    @Test
    void feedPetAtHighHunger() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testPet.setHungerLevel(100);
        testPet.feed();
        assertEquals(75, testPet.getHungerLevel());
    }

    @Test
    void feedPetAtHungerLessThan25() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testPet.setHungerLevel(20);
        testPet.feed();
        assertEquals(0, testPet.getHungerLevel());
    }

    @Test
    void waterPetAtHighThirst() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testPet.setThirstLevel(100);
        testPet.water();
        assertEquals(75, testPet.getThirstLevel());
    }

    @Test
    void waterPetAtThirstLessThan25() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testPet.setThirstLevel(20);
        testPet.water();
        assertEquals(0, testPet.getThirstLevel());
    }

    @Test
    void playWithPetAtHighBoredom() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testPet.setBoredomLevel(100);
        testPet.play();
        assertEquals(75, testPet.getBoredomLevel());
    }

    @Test
    void playWithPetAtBoredomLessThan25() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testPet.setBoredomLevel(20);
        testPet.play();
        assertEquals(0, testPet.getBoredomLevel());
    }

    @Test
    void tick() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testPet.tick();
        assertEquals(11, testPet.getHungerLevel());
        assertEquals(11, testPet.getThirstLevel());
        assertEquals(11, testPet.getBoredomLevel());
    }

    @Test
    public void ticOnOrganicPetIncreasesCageSoil() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Tom", "1");
        testPet.tick();
        testPet.tick();
        testPet.tick();
        assertEquals(30, testPet.getCageSoilLevel());
    }

    @Test
    void petStatus() {
        PetShelter shelter = new PetShelter();
        OrganicDog testPet = new OrganicDog("Fido", "1");
        assertEquals("(" + testPet.getId() + ")" + testPet.getName() + "'s health: \n\t\t\t\t   hunger level:  "
                + testPet.getHungerLevel() +
                "\n\t\t\t\t   thirst level:  " + testPet.getThirstLevel() + "\n\t\t\t\t   boredom level: "
                + testPet.getBoredomLevel() +
                "\n\t\t\t\t   Cage soil level:  " + testPet.getCageSoilLevel() +
                "\n\t\t\t\t   Bathroom needs level: " + testPet.getBathroomNeeds() + "\n", testPet.petStatus());
    }

    @Test
    void getId() {
        PetShelter shelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        assertEquals("1", testPet.getId());
    }
}

