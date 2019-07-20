package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
/*
Ипподром(10)
Еще нужно написать метод print класса Hippodrome.
В нем тоже все просто: в цикле для каждой лошади вызываем ее метод print.
Ну, и еще выведи после цикла 10 пустых строк: System.out.println() - чтобы было красивее.


Требования:
1. В методе print класса Hippodrome должен быть вызван метод print по одному разу для каждой лошади(каждого элемента списка horses).
2. В методе print должны быть выведены на экран 10 пустых строк.
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
    
    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("horseOne", (double)3, (double)0));
        game.horses.add(new Horse("horseTwo", (double)3, (double)0));
        game.horses.add(new Horse("horseThree", (double)3, (double)0));
    }
}
