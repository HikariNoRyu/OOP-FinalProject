//package com.company;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Temp {
//    int myHealth = 50000;
//    int myDamage = 900;
//    Scanner sc = new Scanner(System.in);
//
//    Character GeoDragon = new Character("Azhdaha", 400000, 100);
//    ArrayList<Character> characterList = new ArrayList<>();
//        characterList.addAll(Arrays.asList(
//                GeoDragon));
//                Moves VortexVanquisher = new Moves("Vortex Vanquisher", myDamage + 100);
//                Moves PlanetBeFall = new Moves("Tendo Bansho", myDamage + 1000);
//                Moves ChannelGeo = new Moves("Pillar", myDamage + 600);
//                Moves Shield = new Moves("Shield", -5000);
//                Moves Charge = new Moves("Spear rush", myDamage + 400);
//                ArrayList<Moves> MovesList = new ArrayList<>();
//        MovesList.addAll(Arrays.asList(
//        VortexVanquisher,
//        PlanetBeFall,
//        ChannelGeo,
//        Shield,
//        Charge));
//        size = characterList.size();
//        int whichCharacter = 0;
//        for (int i = 0; i < characterList.size(); i++) {
//        System.out.println((i + 1) + ". character: " + characterList.get(whichCharacter).getName());
//        }
//        String myName = "Zhong li";
//        Character Morax = new Character(myName, myHealth, myDamage);
//        System.out.println("Your name: " + myName);
//        System.out.println("Your HP: " + myHealth);
//        System.out.println("Your attack power: " + myDamage);
//        System.out.println();
//        System.out.println();
//        System.out.println("You were attacked by Azhdaha:");
//        System.out.println("Name: " + characterList.get(whichCharacter).getName());
//        System.out.println("HP: " + characterList.get(whichCharacter).getHealth());
//        System.out.println("Attack power: " + characterList.get(whichCharacter).getDamage());
//        System.out.println();
//        System.out.println("You attack with...");
//        System.out.println();
//        System.out.println("1. Vortex Vanquisher");
//        System.out.println("2. Tendo Bansho");
//        System.out.println("3. Channel Geo");
//        System.out.println("4. Spear Barage");
//        System.out.println("5. Shield");
//        int choice = sc.nextInt();
//        while (!characterList.get(whichCharacter).isDead() && !Morax.isDead()) {
//        switch (choice) {
//        case 1 -> myDamage = VortexVanquisher.getMovesDamage();
//        case 2 -> myDamage = PlanetBeFall.getMovesDamage();
//        case 3 -> myDamage = ChannelGeo.getMovesDamage();
//        case 4 -> myDamage = Charge.getMovesDamage();
//        }
//
//
//        while (!characterList.get(whichCharacter).isDead() && !Morax.isDead()) {
//        characterList.get(whichCharacter).attack(myDamage, myHealth);
//        Morax.attack(characterList.get(whichCharacter).getDamage(), Morax.getHealth());
//        //characterList.get(whichCharacter).attack(characterList.get(whichCharacter).getDamage(), player.getHealth());
//        }
//
//        // characterList.get(whichCharacter).attack(characterList.get(whichCharacter).getDamage(),
//        // player.getHealth());
//        }
//
//
//        }
//
//public static int random() {
//        int szam = (int) (Math.random() * size);
//        return szam;
//        }
//        }
//        }