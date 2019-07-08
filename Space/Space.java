package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

/*
Space (4)
Чего не хватает классу Space?
Правильно - методов run() и draw().
run управляет всей логикой игры, если ты помнишь.
А draw отвечает за отрисовку очередного "кадра".

А еще нам пригодится метод sleep(int ms).
Создай их.


Требования:
1. В классе Space создай метод run().
2. В классе Space создай метод draw().
3. В классе Space создай метод sleep(int ms).
 */
public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private List<Ufo> ufos = new ArrayList<>();
    private List<Rocket> rockets = new ArrayList<>();
    private List<Bomb> bombs = new ArrayList<>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public static void main(String[] args) {
        
    }

    public void run(){}
    public void draw(){}
    public void sleep(int ms){}
}
