package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetShelterTest {

    @Test
    void getAllPets() {
        for (VirtualPetInterface testPet : new PetShelter().getAllPets()) {
            System.out.println(testPet);
        }
    }

    @Test
    void admitNewPet() {
        PetShelter shelter = new PetShelter();
        new PetShelter().admitNewPet(new OrganicDog("Harry", "1"));
    }

    @Test
    void retrievePet() {
        PetShelter testShelter = new PetShelter();
        OrganicPet fido = new OrganicDog("Fido", "1");
        testShelter.admitNewPet(fido);
        assertEquals(fido, testShelter.retrievePet("1"));
    }

    @Test
    void feedSinglePet() {
        PetShelter testShelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testShelter.admitNewPet(testPet);
        testPet.tick();
        testPet.tick();
        testPet.tick();
        testShelter.feedPet(testPet);
        assertEquals(6, testShelter.retrievePet("1").getHungerLevel());

    }

    @Test
    void feedAllPets() {
        PetShelter testShelter = new PetShelter();
        testShelter.admitNewPet(new OrganicDog("Fido", "1"));
        testShelter.admitNewPet(new OrganicDog("Rover", "2"));

        for (VirtualPetInterface pets : testShelter.getAllPets()) {
            pets.tick();
            pets.tick();
            pets.tick();
        }
        testShelter.feedAllPets();

        assertEquals(6, testShelter.retrievePet("1").getHungerLevel());
        assertEquals(6, testShelter.retrievePet("2").getHungerLevel());
    }

    @Test
    void waterSinglePet() {
        PetShelter testShelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testShelter.admitNewPet(testPet);
        testPet.tick();
        testPet.tick();
        testPet.tick();
        testShelter.waterPet(testPet);
        assertEquals(6, testShelter.retrievePet("1").getThirstLevel());

    }

    @Test
    void waterAllPets() {
        PetShelter testShelter = new PetShelter();
        testShelter.admitNewPet(new OrganicDog("Fido", "1"));
        testShelter.admitNewPet(new OrganicDog("Rover", "2"));

        for (VirtualPetInterface pets : testShelter.getAllPets()) {
            pets.tick();
            pets.tick();
            pets.tick();
        }
        testShelter.waterAllPets();

        assertEquals(6, testShelter.retrievePet("1").getThirstLevel());
        assertEquals(6, testShelter.retrievePet("2").getThirstLevel());
    }

    @Test
    void playWithSinglePet() {
        PetShelter testShelter = new PetShelter();
        OrganicPet testPet = new OrganicDog("Fido", "1");
        testShelter.admitNewPet(testPet);
        testPet.tick();
        testPet.tick();
        testPet.tick();
        testShelter.playWithPet(testPet);
        assertEquals(6, testShelter.retrievePet("1").getBoredomLevel());

    }

    @Test
    void playWithAllPets() {
        PetShelter testShelter = new PetShelter();
        testShelter.admitNewPet(new OrganicDog("Fido", "1"));
        testShelter.admitNewPet(new OrganicDog("Rover", "2"));

        for (VirtualPetInterface pets : testShelter.getAllPets()) {
            pets.tick();
            pets.tick();
            pets.tick();
        }
        testShelter.playWithAllPets();

        assertEquals(6, testShelter.retrievePet("1").getBoredomLevel());
        assertEquals(6, testShelter.retrievePet("2").getBoredomLevel());
    }

    @Test
    void adoptOutPet() {
        PetShelter testShelter = new PetShelter();
        testShelter.admitNewPet(new OrganicDog("Fido", "1"));
        testShelter.admitNewPet(new OrganicDog("Rover", "2"));
        assertNotNull(testShelter.retrievePet("1"));
        testShelter.adoptOutPet("1");
        assertNull(testShelter.retrievePet("1"));
    }
}