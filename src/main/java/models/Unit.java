package models;

import lombok.Data;

@Data
public class Unit {
    String name;
    int cost;

    public Unit(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
