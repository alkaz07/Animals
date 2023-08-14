package com.example.animals;

public class Donkey extends Animals implements Yelling{
    public Donkey(String name) {
        super(name);
    }

    @Override
    public String yelling() {
return "иаииаиаиаиаи";

    }
}
