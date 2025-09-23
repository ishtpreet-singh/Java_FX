package controller;

import model.Pet;

public class PetController {
    private final Pet pet;

    public PetController(Pet pet) {
        this.pet = pet;
    }

    public void movePetTowards(double targetX, double targetY) {
        double dx = targetX - pet.getX();
        double dy = targetY - pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > 1) { // stop when very close
            double step = 2; // pixels per frame
            pet.setX(pet.getX() + step * dx / distance);
            pet.setY(pet.getY() + step * dy / distance);
        }
    }

}