package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

/*
Space (9)
Еще Canvas понадобится два метода, напиши их.
а) метод clear();
Этот метод будет очищать матрицу, чтобы на ней снова можно было рисовать.
Например заменить все символы матрицы на пробелы.

б) метод print();
Этот метод отрисовывает матрицу на экран.
Тут уже ты должен сам разобраться: вывести набор символов не так уж и сложно.
Не забудь добавить пару пустых строк в конце, чтобы матрицы выведенные в разное время не слипались.


Требования:
1. В классе Canvas создай метод clear().
2. Метод clear() должен очищать матрицу.
3. В классе Canvas создай метод print().
4. Метод print() должен отрисовыть матрицу в консоль.
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
        Canvas canvas = new Canvas(5, 5);
        canvas.clear();
        canvas.print();


    }

    public void run(){}
    public void draw(){}
    public void sleep(int ms){}
}
