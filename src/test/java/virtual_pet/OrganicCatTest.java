package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrganicCatTest {

    @Test
    public void cleanLitterBox() {
        PetShelter shelter = new PetShelter();
        OrganicCat testCat = new OrganicCat("Tom", "1");
        testCat.setLitterBoxSoilLevel(100);
        testCat.cleanLitter();
        assertEquals(0, testCat.getLitterBoxSoilLevel());
    }

    @Test
    public void ticOnACatSoilsLitter() {
        PetShelter shelter = new PetShelter();
        OrganicCat testCat = new OrganicCat("Tom", "1");
        testCat.tick();
        testCat.tick();
        testCat.tick();
        assertEquals(30, testCat.getLitterBoxSoilLevel());
    }

}