package com.example.animals;

public class Tiger extends Animals implements Growls {

    public Tiger(String name) {
        super(name);
    }


    public String growl() {

        return "rrrrrrrr";
    }
}

