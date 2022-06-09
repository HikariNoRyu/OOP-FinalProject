package com.company;

public class ZhongLi{

    int hp = 52000;
    int dmg = 1000;
    String Happen = "";
    public int VortexVanquisher(){
        Happen = "Morax swings at Azhdaha";
        dmg = dmg + 1000;
        return dmg;
    }
    public int TendoBansho(){
        Happen = "TENDO BANSHO!!!";
        dmg = dmg + 200000;
        return dmg;
    }
    public int SpearBarage(){
        Happen = "Spears rain down from the sky and strikes Azhdaha";
        dmg = dmg + 10000;
        return dmg;
    }
    public int Geo(){
        Happen = "Quake!";
        dmg = dmg + 5000;
        return dmg;
    }
}