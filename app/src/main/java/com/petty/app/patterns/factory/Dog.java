package com.petty.app.patterns.factory;

public class Dog extends Pet {

    public Dog(String name) {
        super(name, "dog");
    }

    @Override
    public String getDefaultBehavior() {
        return "Oynuyor";
    }
}