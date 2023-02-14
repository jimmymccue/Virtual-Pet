package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoboticPetTest {

    @Test
    public void oilRobotAtHighRust() {
        PetShelter shelter = new PetShelter();
        RoboticPet roboPet = new RoboticDog("Robo", "1");
        roboPet.setRustLevel(100);
        roboPet.oilRobot();
        assertEquals(50, roboPet.getRustLevel());
    }

    @Test
    public void chargeRobotTo100Percent() {
        PetShelter shelter = new PetShelter();
        RoboticPet roboPet = new RoboticDog("Robo", "1");
        roboPet.setBatteryPercent(20);
        roboPet.chargeRobot();
        assertEquals(100, roboPet.getBatteryPercent());
    }

    @Test
    public void walkRobotLowersBattery() {
        PetShelter shelter = new PetShelter();
        RoboticPet roboPet = new RoboticDog("Robo", "1");
        roboPet.walkPet();
        assertEquals(75, roboPet.getBatteryPercent());
    }

    @Test
    public void walkRobotLowersRust() {
        PetShelter shelter = new PetShelter();
        RoboticPet roboPet = new RoboticDog("Robo", "1");
        roboPet.setRustLevel(100);
        roboPet.walkPet();
        assertEquals(90, roboPet.getRustLevel());
    }

    @Test
    public void ticOnRobotDrainsBattery() {
        PetShelter shelter = new PetShelter();
        RoboticPet testRobot = new RoboticDog("Robo", "1");
        testRobot.tick();
        testRobot.tick();
        testRobot.tick();
        assertEquals(85, testRobot.getBatteryPercent());
    }

    @Test
    public void ticOnRobotIncreasesRust() {
        PetShelter shelter = new PetShelter();
        RoboticPet testRobot = new RoboticDog("Robo", "1");
        testRobot.tick();
        testRobot.tick();
        testRobot.tick();
        assertEquals(6, testRobot.getRustLevel());
    }
}