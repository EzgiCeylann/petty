package com.petty.app.patterns.factory;

public class Cat extends Pet {

    public Cat(String name) {
        super(name, "cat");
    }

    @Override
    public String getDefaultBehavior() {
        return "Uyuyor";
    }
}