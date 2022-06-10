package com.company;



public class ZhongLi{

    int hp = 52000;
    int dmg = 1000;
    int critdmgmult = 2;
    int critPercentage = 30;
    int crit = new java.util.Random().nextInt(100);

    int VortexDmg = 0;
    int TendoBanshoDmg = 0;
    int GeoResoDmg = 0;
    int Spears = 0;


    String Pos = "";


    String Happen = "";

    public int VortexVanquisher(){
        VortexDmg = 10000 + dmg;
        Pos = "Vortex";
        dmg = VortexDmg;
        Happen = "Morax swings at Azhdaha";
        if (crit < critPercentage){
            return dmg = dmg*critdmgmult;
        }
        else {
            return dmg;

        }
    }
    public int TendoBansho(){

        Pos = "Tendo Bansho";
        Happen = "TENDO BANSHO!!!";
        TendoBanshoDmg = dmg + 100000;
        dmg = TendoBanshoDmg;
        if (crit < critPercentage){
            return dmg = dmg*critdmgmult;
        }
        else {
            return dmg;
        }
    }
    public int SpearBarage(){
        Pos = "Barrage";
        Happen = "Spears rain down from the sky and strikes Azhdaha";
        Spears = 15000;
        dmg = Spears;
        if (crit < critPercentage){
            return dmg = dmg*critdmgmult;
        }
        else {
            return dmg;
        }
    }
    public int Geo(){
        Pos = "Geo";
        Happen = "Quake!";
        GeoResoDmg = 40000;
        dmg = GeoResoDmg;
        if (crit < critPercentage){
            return dmg = dmg*critdmgmult;
        }
        else {
            return dmg;
        }
    }
}
