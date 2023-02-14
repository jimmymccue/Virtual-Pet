package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetShelter {

    final Map<String, VirtualPetInterface> pet = new HashMap<>();
//    final Map<String, RoboticPet> pet = new HashMap<>();
//    final Map<String, VirtualPetInterface> pet = new HashMap<>();


    Collection<VirtualPetInterface> getAllPets() {
        return pet.values();
    }
//    Collection<RoboticPet> getAllRoboticPets() {
//        return pet.values();
//    }

//    Collection<VirtualPetInterface> getAllVirtualPetInterfaces() {
//        return pet.values();
//    }

    public void admitNewPet(VirtualPetInterface pet) {
        this.pet.put(pet.getId(), pet);
    }

    public VirtualPetInterface retrievePet(String id) {
        return this.pet.get(id);
    }

    public void adoptOutPet(String id) {
        pet.remove(id);
    }

    public VirtualPetInterface retrievepet(String id) {
        return pet.get(id);
    }

    public void feedPet(VirtualPetInterface pet) {
        pet.feed();
    }

    public void feedAllPets() {
        for (VirtualPetInterface hungryPets : getAllPets()) {
            feedPet(hungryPets);
        }
    }

    public void waterPet(VirtualPetInterface pet) {
        pet.water();
    }

    public void waterAllPets() {
        for (VirtualPetInterface thirstyPets : getAllPets()) {
            waterPet(thirstyPets);
        }
    }

    public void playWithPet(VirtualPetInterface pet) {
        pet.play();
    }

    public void playWithAllPets() {
        for (VirtualPetInterface BoredPets : getAllPets()) {
            playWithPet(BoredPets);
        }
    }

    public String getAllPetStatus() {
        String returnString = "";
        for (VirtualPetInterface petStatus : pet.values()) {
            returnString += petStatus.petStatus();
        }
        return returnString;
    }

    public void walkPet(VirtualPetInterface pet) {
        pet.walkPet();
    }

    public void walkAllPets() {
        for (VirtualPetInterface pet : getAllPets()) {
            walkPet(pet);
        }
    }

    public void cleanAllCages() {
        for (VirtualPetInterface pet : getAllPets()) {
            pet.cleanCage();
        }
    }


    public void cleanAllLitterBoxes() {
        for (VirtualPetInterface pet : getAllPets()) {
            pet.cleanLitter();
        }
    }
}