package com.example.animals;

import javafx.beans.property.SimpleStringProperty;

public class Animals {
    SimpleStringProperty name = new SimpleStringProperty(); //вместо String взяли наблюдаемое свойство

    public Animals(String name) {
        this.name.set( name);
    }



}
