package com.company;



public class ZhongLi extends GeoDragon{

    int hp = 52000;
    int dmg = new java.util.Random().nextInt(10000);;
    int critdmgmult = 2;
    int critPercentage = 50;
    int crit = new java.util.Random().nextInt(100);
    int gachaeffect = new java.util.Random().nextInt(8000);
    int VortexDmg = 0;
    int TendoBanshoDmg = 0;
    int GeoResoDmg = 0;
    int Spears = 0;

    int heal;

    String Pos = "";


    String Happen = "";

    public int VortexVanquisher(){
        VortexDmg = 7000 + dmg + gachaeffect;
        Pos = "Vortex";
        dmg = VortexDmg;
        Happen = "Morax swings at Azhdaha";
        if (crit > critPercentage){
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
        if (crit > critPercentage){
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
        GeoResoDmg = 9000;
        dmg = GeoResoDmg;
        CopiumShield();
        if (crit < critPercentage){
            return dmg = dmg*critdmgmult;
        }
        else {
            return dmg;
        }
    }
    public int CopiumShield(){
        heal = 1000 + GeoDragonDmg;
        hp = hp+heal;
        return hp;
    }
}
