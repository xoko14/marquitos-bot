package com.xoko14.markov_bot;

import java.util.Scanner;

public class App {
    private static MarkovChain mark = new MarkovChain("./traindata/azkaban.txt");
    private static Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {
        int words;
        System.out.println("done learning");

        while(true){
            System.out.print(">");
            words = Integer.parseInt(kbd.nextLine());
            if(words == -1) break;
            System.out.println(mark.generate(words));
        }
    }
}
