package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
/*
Ипподром(16)
Теперь уже точно все.

Добавь вызов метода printWinner в конец метода main.

Запускай и любуйся своей первой компьютерной игрой :)


Требования:
1. Метод printWinner должен быть вызван в методе main после метода run.
 */
public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses = new ArrayList<Horse>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public Horse getWinner(){
        Horse vinner = null;
        int maxDistanse = 0;
        for (Horse horse: horses) {
            if (horse.getDistance() > maxDistanse) vinner = horse;
        }
        return vinner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse horse: horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("horseOne", (double)3, (double)0));
        game.horses.add(new Horse("horseTwo", (double)3, (double)0));
        game.horses.add(new Horse("horseThree", (double)3, (double)0));
        game.run();
        game.printWinner();
    }
}
