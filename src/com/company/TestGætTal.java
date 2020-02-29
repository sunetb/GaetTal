package com.company;

import java.util.Random;

public class TestGætTal {


    static int max = 1000;
    static int min = 1;

    public static void main(String[] args) {



        //Testspil 1 (med interval)
        GætTal g = new GætTal(max);

        System.out.println("Det hemmelige tal er: " + g.snyd());

        while (!g.gættetRigtigt){
             int interval = max - min;
             int tal = min + (interval/2);
             g.gæt(tal);
             if(g.gættetRigtigt) break;
             else if (g.gættetVarForHøjt) {
                 max = tal;
                 System.out.println("Du gættede på "+ tal + ". Det var for højt!");
             }
             else {
                 min = tal;
                 System.out.println("Du gættede på  "+ tal + ". Det var for lavt!");
             }


        }
        System.out.println("Du gættede rigtigt! Du brugte "+ g.getAntalGæt() + " gæt og scorede "+g.getScore() + " point");

        g.logStatus();

        //Testspil 2 (tilfældigt)
        max = 100;
        g.setMax(max);
        System.out.println(g.snyd());

        while(!g.gættetRigtigt){
            int tal = new Random().nextInt(max)+1;
            g.gæt(tal);
            if (g.gættetRigtigt){
                System.out.println("Du gættede rigtigt! Du brugte "+ g.getAntalGæt() + " gæt og scorede "+g.getScore() + " point");
            }
            else if (g.getAntalGæt() == max) {
                System.out.println("Du gættede det ikke! Du brugte "+ g.getAntalGæt() + " gæt og scorede "+g.getScore() + " point");
                break;
            }
            else System.out.println("Du gættede på  "+ tal + ". Var det for højt? "+g.gættetVarForHøjt);


        }
        g.logStatus();


    }







}
