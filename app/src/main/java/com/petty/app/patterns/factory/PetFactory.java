package com.petty.app.patterns.factory;

public class PetFactory {

    public static Pet createPet(String type, String name) {
        switch (type.toLowerCase()) {
            case "cat":
                return new Cat(name);
            case "dog":
                return new Dog(name);
            default:
                throw new IllegalArgumentException("Geçersiz hayvan türü: " + type);
        }
    }
}