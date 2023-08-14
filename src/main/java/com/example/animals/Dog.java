package com.example.animals;

public class Dog extends Animals implements Barks, Howls {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String barks() {
        return "гавгавгав";
    }

    @Override
    public String howls() {
        return "уууууууу";
    }
}
