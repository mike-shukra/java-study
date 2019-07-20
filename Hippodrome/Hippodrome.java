package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
/*
Ипподром(8)
В методе run сделай цикл от 1 до 100. Это и будет наш забег.
В теле цикла вызываем сначала move, затем print.
Чтобы весь цикл не отработал за долю секунды - добавь в него еще Thread.sleep(200);


Требования:
1. В методе run класса Hippodrome должен быть 100 раз вызван метод move.
2. В методе run класса Hippodrome должен быть 100 раз вызван метод print.
3. В методе run класса Hippodrome должен быть 100 раз вызван метод Thread.sleep(200).
4. Метод print должен быть вызван после метода move.
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
    public void move(){}
    public void print(){}
    
    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("horseOne", (double)3, (double)0));
        game.horses.add(new Horse("horseTwo", (double)3, (double)0));
        game.horses.add(new Horse("horseThree", (double)3, (double)0));
    }
}
