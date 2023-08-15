package com.example.animals;

public class Cat extends Animals implements Growls, Purring {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String growl() {
        //подправили вывод с учетом сложного SimpleStringProperty
        return name.get()+": "+"РРРРРР";
    }

    @Override
    public String purring() {
        return name.get()+": "+"муррррррр";
    }
}
