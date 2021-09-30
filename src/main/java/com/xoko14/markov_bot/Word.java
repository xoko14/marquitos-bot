package com.xoko14.markov_bot;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Word {
    private String text;
    public String get(){return text;}
    private ArrayList<String> nextWords;
    private Random r = new Random();
    private boolean isStart = false;
    public void setStart(){this.isStart = true;}
    public boolean getStart(){return this.isStart;}
    public static Word END = new Word(".");

    public Word(String text){
        this.text = text;
        nextWords = new ArrayList<>();
    }

    public void addNext(String word){
        nextWords.add(word);
    }

    public String getNext(){
        if(nextWords.size() == 0) return ".";
        return nextWords.get(r.nextInt(nextWords.size()));
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Word)) {
            return false;
        }
        Word word = (Word) o;
        return Objects.equals(text, word.text);
    }

    public boolean equals(String s){
        return this.text.equals(s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
    
}
