package com.example.animals;

import java.util.ArrayList;
import java.util.List;

public class Model {
    ArrayList<Animals> animals = new ArrayList<>();
    public void loadAnimals(List<String> lines)
    {
        for (String str:lines   ) {
            Animals a = generateAnimal(str.split(" ")[0], str.split(" ")[1]);
            animals.add(a);
        }
    }

    public Animals generateAnimal(String type, String name)
    {
        if(type.equals("Tiger"))
            return new Tiger(name);
        if(type.equals("Cat"))
            return new Cat(name);
        if(type.equals("Donkey"))
            return new Donkey(name);
        if(type.equals("Dog"))
            return new Dog(name);
        if(type.equals("Karas"))
            return new Karas(name);
        return null;
    }
}
