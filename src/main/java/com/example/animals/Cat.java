package com.example.animals;

public class Cat extends Animals implements Growls, Purring {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String growl() {

        return "РРРРРР";
    }

    @Override
    public String purring() {
        return "муррррррр";
    }
}
