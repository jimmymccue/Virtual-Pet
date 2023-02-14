package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrganicDogTest {

    @Test
    public void walkDogLowersBoredomAtHighLevel() {
        PetShelter shelter = new PetShelter();
        OrganicDog testPet = new OrganicDog("Leo", "1");
        testPet.setBoredomLevel(100);
        testPet.walkPet();
        assertEquals(75, testPet.getBoredomLevel());
    }

    @Test
    public void walkDogLowersBoredomAtLowLevel() {
        PetShelter shelter = new PetShelter();
        OrganicDog testPet = new OrganicDog("Leo", "1");
        testPet.setBoredomLevel(20);
        testPet.walkPet();
        assertEquals(0, testPet.getBoredomLevel());
    }

    @Test
    public void walkDogTakesAwayBathroomNeeds() {
        PetShelter shelter = new PetShelter();
        OrganicDog testPet = new OrganicDog("Leo", "1");
        testPet.setBathroomNeeds(100);
        testPet.walkPet();
        assertEquals(0, testPet.getBathroomNeeds());
    }

    @Test
    public void ticOnADogIncreasesBathroomNeeds() {
        PetShelter shelter = new PetShelter();
        OrganicDog testDog = new OrganicDog("Tom", "1");
        testDog.tick();
        testDog.tick();
        testDog.tick();
        assertEquals(30, testDog.getBathroomNeeds());
    }

}