package cpen221practice;

import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive




class DnDCharacter {

    private int[] randomNum = new int[4];




    private final int strength;

    private final int dexterity;

    private final int constitution;

    private final int intelligence;

    private final int wisdom;

    private final int charisma;




    public DnDCharacter(){
        strength = ability();
        dexterity = ability();
        constitution = ability();
        intelligence = ability();
        wisdom = ability();
        charisma = ability();
    }

     int ability() {
        for(int i = 0; i<4; i++) {
             randomNum[i] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        }
        int min =randomNum[0];
        int minIndex =0;

        for (int i =0; i<4; i ++){
            if (randomNum[i] < min){
                min = randomNum[i];
                minIndex = i;
            }
        }

        int sum = 0;

        for (int i =0; i<4; i++){
            if (i != minIndex){
                sum += randomNum[i];
            }
        }


        return sum;
    }

    int modifier(int input) {
        double modD =  Math.floor((input - 10.0)/2.0);
        return (int) modD;

    }

     int getStrength() {

        return strength;
    }

    int getDexterity() {


        return dexterity;
    }

    int getConstitution() {

        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {

        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }

}
