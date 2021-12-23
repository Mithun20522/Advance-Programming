package com.example.hellofx;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class Player {
    private String name;
    private int ith;
    private int jth;
    private int position = 1;
    private ImageView c;

    public Player(String name, ImageView c){
        setIth(0);
        setJth(0);
        setName(name);
        setImageView(c);
    }

    public void setImageView(ImageView c){
        this.c = c;
    }

    public ImageView getImageView(){
        return this.c;
    }

    public Player(){}

    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public boolean isComplete(Player p){
        if(p.getIth()==9 && p.getJth()==0){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIth() {
        return ith;
    }

    public void setIth(int ith) {
        this.ith = ith;
    }

    public int getJth() {
        return jth;
    }

    public void setJth(int jth) {
        this.jth = jth;
    }

}
