package model.pets;

import model.Human;

public class Pet {
    protected boolean friendly;
    protected boolean needsAttention;
    protected String species;
    protected String color;
    protected double price;
    protected Human human;

    public Pet(String species, String color, boolean friendly, boolean needsAttention, double price){
        this.species = species;
        this.color = color;
        this.friendly = friendly;
        this.needsAttention = needsAttention;
        this.price = price;
        human = null;
    }

    public Pet(String species, String color, double price){
        this.species = species;
        this.color = color;
        this.friendly = true;
        this.needsAttention = false;
        this.price = price;
        human = null;
    }

    //getters
    public String getSpecies() {
        return species;
    }

    public Human getHuman() {
        return human;
    }

    public boolean isFriendly() { return friendly; }

    public boolean needsAttention() {
        return needsAttention;
    }

    public double getPrice() {
        return price;
    }

    //REQUIRES: human != null
    //MODIFIES: this, human
    //EFFECTS: adopts human, and vice versa
    public void adoptHuman(Human human) {
        System.out.println("Adopting a human!");
        this.human = human;
        if (!human.hasPet(this)){
            human.adoptPet(this);
            System.out.println("Success! Adopted " + human);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;

        Pet pet = (Pet) o;

        if (species != null ? !species.equals(pet.species) : pet.species != null) return false;
        return color != null ? color.equals(pet.color) : pet.color == null;
    }

    @Override
    public int hashCode() {
        int result = species != null ? species.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pet {" +
                "species='" + species + '\'' +
                ", friendly=" + friendly +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", human= " + human +
                '}';
    }
}
