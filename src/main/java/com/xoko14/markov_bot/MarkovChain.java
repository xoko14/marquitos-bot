package com.xoko14.markov_bot;

import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
 
public class MarkovChain {
    private ArrayList<Word> words;
    private Random r = new Random();

    public MarkovChain(String file){
        words = new ArrayList<>();
        String contenido = "";

        try {
            contenido = new String(Files.readAllBytes(Path.of(file)));
            contenido = contenido.replaceAll("[\\n\\t]", "");
            //System.out.println(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.train(contenido);
    }

    public void train(String text){
        String[] phrases = text.split("[.!?]");
        
        for (String phrase : phrases) {
            if(phrase.equals("") || phrase.equals(" ")) continue;
            String[] wordsPhrase = phrase.split("\\ ");
            boolean start = true;
            for(int i=0;i<wordsPhrase.length;i++){
                if(wordsPhrase[i] == "") continue; 
                Word current = inWords(wordsPhrase[i]);
                if(current == null){
                    current = new Word(wordsPhrase[i]);
                    words.add(current);
                }
                if(start == true) current.setStart();
                start = false;
                if(i+1<wordsPhrase.length){
                    while(wordsPhrase[i+1].equals("")){
                        i++;
                    }
                    current.addNext(wordsPhrase[i+1]);
                }
                
            }
        }
    }

    public String generate(int length){
        String string = "";
        Word current;
        String next;
        do{
        current = getStartWord();
        next = current.getNext();
        } while(next.equals("."));
        for(int i=0;i<length;i++){
            string+=current.get();
            current = inWords(next);
            next = current.getNext();
            if(next.equals(".")){
                string+=" "+current.get();
                string+=".";
                break;
            }
            string+=" ";
        }
        return string;
    }

    private Word inWords(String s){
        for (Word word : words) {
            if(word.get().equals(s)) return word;
        }
        return null;
    }

    private Word getStartWord(){
        Word w;
        do{
            w = words.get(r.nextInt(words.size()));
        }while(w.getStart()==false);
        return w;
    }
}
