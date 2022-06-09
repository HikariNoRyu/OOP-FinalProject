package com.company;


public class Moves {
    private String name;
    private int MovesDamage;

    public Moves(String name, int MovesDamage) {
        this.name = name;
        this.MovesDamage = MovesDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovesDamage() {
        return MovesDamage;
    }

    public void setMovesDamage(int MovesDamage) {
        this.MovesDamage = MovesDamage;
    }
}