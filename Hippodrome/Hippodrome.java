package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
/*
Ипподром(9)
Теперь вернемся к методам move и print. Начнем с move.
В методе move класса Hippodrome в цикле у каждой лошади мы вызываем метод move.
Да ты прав, его еще нет у класса Horse.
Поэтому в класс Horse надо добавить свой метод move :)
И метод print, кстати тоже.
Если я не говорю ничего насчет параметров метода, значит метод без параметров.
Делай все методы public, если явно не указано обратное.

Требования:
1. В классе Horse должен быть создан метод move.
2. В классе Horse должен быть создан метод print.
3. В методе move класса Hippodrome должен быть вызван метод move по одному разу для каждой лошади(каждого элемента списка horses).
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
    public void print(){}
    
    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("horseOne", (double)3, (double)0));
        game.horses.add(new Horse("horseTwo", (double)3, (double)0));
        game.horses.add(new Horse("horseThree", (double)3, (double)0));
    }
}
