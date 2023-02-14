package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {

        VirtualPetApplication newGame = new VirtualPetApplication();

        newGame.gameLoop();

        System.out.println("Good Bye!");
    }

    public void gameLoop() {

        String nextId = "1";

        Scanner input = new Scanner(System.in);
        PetShelter shelter = new PetShelter();
        shelter.admitNewPet(new OrganicDog("Fido", createId(shelter, nextId)));
        shelter.admitNewPet(new OrganicCat("Tom", createId(shelter, nextId)));
        shelter.admitNewPet(new RoboticDog("Rover", createId(shelter, nextId)));
        shelter.admitNewPet(new RoboticCat("Sadie", createId(shelter, nextId)));



        System.out.println("\nWelcome to The Virtual Pet Shelter! \nWe have " + shelter.getAllPets().size() +
                " pets currently at our shelter!");
        String visitorCommand = "0";
        while (!visitorCommand.equalsIgnoreCase("quit")) {

            for (VirtualPetInterface tickPet : shelter.getAllPets()) {
                tickPet.tick();
            }

            System.out.println("\nWhat would you like to do?");
            System.out.println("See our live pets up for adoption  type: ADOPT ");
            System.out.println("Put your live pet up for adoption  type: REHOME ");
            System.out.println("See our robotic pets for sale      type: BUY");
            System.out.println("Sell a robotic pet to us           type: SELL");
            System.out.println("Interact with a pet                type: INTERACT ");
            System.out.println("Leave the shelter                  type: QUIT ");
            visitorCommand = input.next();

            if (visitorCommand.equalsIgnoreCase("adopt")) {
                int countPets = 0;

                for (VirtualPetInterface pet : shelter.getAllPets()) {
                    if (pet.getType() == "ORGANIC_DOG" || pet.getType() == "ORGANIC_CAT") {
                        System.out.println(pet.petStatus());
                        countPets++;
                    }
                }
                if (countPets > 1) {
                    System.out.println("** " + countPets + " pets for adoption **\n");
                    System.out.println("Enter the pet's Id that you would like to adopt: ");
                    System.out.print("If you did not find the pet for you enter \"0\": ");
                    String petId = input.next();
                    shelter.adoptOutPet(petId);
                }
                if (countPets == 1) {
                    System.out.println("** " + countPets + " pet for adoption **\n");
                    System.out.println("Enter the pet's Id that you would like to adopt: ");
                    System.out.print("If you did not find the pet for you enter \"0\": ");
                    String petId = input.next();
                    shelter.adoptOutPet(petId);
                }
                if (countPets < 1) {
                    System.out.println("I am sorry we have no more pets for adoption\n Please pick another prompt!");
                }
            }

            if (visitorCommand.equalsIgnoreCase("rehome")) {
                System.out.println("What is your pets name? ");
                String petName = input.next();
                String petType = "";
                while (!(petType.equalsIgnoreCase("dog")) &&
                        !(petType.equalsIgnoreCase("cat"))) {
                    System.out.println("What is your pet type?");
                    System.out.println("Please enter: DOG or CAT");
                    petType = input.next();
                }

                if (petType.equalsIgnoreCase("dog")) {
                    shelter.admitNewPet(new OrganicDog(petName, createId(shelter, nextId)));
                }
                if (petType.equalsIgnoreCase("cat")) {
                    shelter.admitNewPet(new OrganicCat(petName, createId(shelter, nextId)));
                }
            }

            if (visitorCommand.equalsIgnoreCase("buy")) {
                int countPets = 0;

                for (VirtualPetInterface pet : shelter.getAllPets()) {
                    if (pet.getType().substring(0, 7).equals("ROBOTIC")) {
                        System.out.println(pet.petStatus());
                        countPets++;
                    }
                }
                if (countPets > 1) {
                    System.out.println("** " + countPets + " pets for sale **\n");
                } else if (countPets == 1) {
                    System.out.println("** " + countPets + " pet for sale **\n");
                } else if (countPets < 1) {
                    System.out.println("I am sorry we have no more pets for sale\n Please pick another prompt!");
                }
                int state = 1;
                while (state == 1) {
                    System.out.println("Enter the pet's Id that you would like to buy  ");
                    String petId = input.next();
                    for (VirtualPetInterface pet : shelter.getAllPets()) {
                        if (petId.equalsIgnoreCase(pet.getId()) &&
                                (pet.getType() == "ROBOTIC_DOG" || pet.getType() == "ROBOTIC_CAT")) {
                            shelter.adoptOutPet(petId);
                            System.out.println("Thank you for your purchase!");
                            state = 0;
                            break;
                        }
                    }
                }
            }

            if (visitorCommand.equalsIgnoreCase("sell")) {
                System.out.println("What is your robotic pet's name? ");
                String petName = input.next();
                String petType = "";
                while (!(petType.equalsIgnoreCase("dog")) &&
                        !(petType.equalsIgnoreCase("cat"))) {
                    System.out.println("What is your pet type?");
                    System.out.println("Please enter: DOG or CAT");
                    petType = input.next();
                }

                if (petType.equalsIgnoreCase("dog")) {
                    shelter.admitNewPet(new RoboticDog(petName, createId(shelter, nextId)));
                }
                if (petType.equalsIgnoreCase("cat")) {
                    shelter.admitNewPet(new RoboticCat(petName, createId(shelter, nextId)));
                }
            }

            if (visitorCommand.equalsIgnoreCase("interact")) {
                System.out.println("Here is a list of our current pets:\n");

                System.out.println(shelter.getAllPetStatus());
                System.out.println("How would you like to interact?");
                System.out.println("Choose from the following:");
                System.out.println("Play with a pet:         1 \t\tPlay with all pets:            2 \t\tFeed a pet:              3");
                System.out.println("Feed all pets:           4 \t\tWater a pet:                   5 \t\tWater all pets:          6");
                System.out.println("Walk a pet:              7 \t\tWalk all pets:                 8 \t\tClean a cage:            9");
                System.out.println("Clean all cages:         10\t\tClean a litter box:            11\t\tClean all litter boxes:  12");
                System.out.println("Oil a robotic pet:       13\t\tOil all robotic pets:          14\t\tCharge a robotic pet     15");
                System.out.println("Charge all robotic pets: 16");

                String userChoice = input.next();


                switch (userChoice) {
                    case "1":
                        System.out.print("Enter the id for the pet you'd like to play with:");
                        String petId = input.next();
                        shelter.retrievePet(petId).play();
                        break;
                    case "2":
                        shelter.playWithAllPets();
                        break;
                    case "3":
                        System.out.print("Enter the id for the pet you'd like to feed:");
                        petId = input.next();
                        shelter.retrievePet(petId).feed();
                        break;
                    case "4":
                        shelter.feedAllPets();
                        break;
                    case "5":
                        System.out.print("Enter the id for the pet you'd like to water:");
                        petId = input.next();
                        shelter.retrievePet(petId).water();
                        break;
                    case "6":
                        shelter.waterAllPets();
                        break;
                    case "7":
                        System.out.print("Enter the id for the pet you'd like to walk:");
                        petId = input.next();
                        shelter.retrievePet(petId).walkPet();
                        break;
                    case "8":
                        shelter.walkAllPets();
                        break;
                    case "9":
                        System.out.print("Enter the id for the pet's cage you'd like to clean:");
                        petId = input.next();
                        shelter.retrievePet(petId).cleanCage();
                        break;
                    case "10":
                        shelter.cleanAllCages();
                        break;
                    case "11":
                        System.out.print("Enter the id for the cat's litter box you'd like to clean:");
                        petId = input.next();
                        shelter.retrievePet(petId).cleanLitter();
                        break;
                    case "12":
                        shelter.cleanAllLitterBoxes();
                        break;
                    case "13":
                        System.out.print("Enter the id for the robotic pet you'd like to oil:");
                        petId = input.next();
                        shelter.retrievePet(petId).oilRobot();
                        break;
                    case "14":
                        for (VirtualPetInterface pet : shelter.getAllPets()) {
                            pet.oilRobot();
                        }
                        break;
                    case "15":
                        System.out.print("Enter the id for the robotic pet you'd like to charge:");
                        petId = input.next();
                        shelter.retrievePet(petId).chargeRobot();
                        break;
                    case "16":
                        for (VirtualPetInterface pet : shelter.getAllPets()) {
                            pet.chargeRobot();
                        }
                        break;
                    default:
                        break;
                }
                System.out.println(shelter.getAllPetStatus());

            }
        }

    }
    public String createId(PetShelter shelter, String id) {
        for (VirtualPetInterface pet : shelter.getAllPets()) {
            if (pet.getId().equals(id)) {
                int temp = Integer.parseInt(id);
                temp++;
                id = Integer.toString(temp);
            }
        }
        return id;
    }
}
