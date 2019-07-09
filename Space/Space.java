package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

/*
Space (6)
Но и это еще не все.
Классу BaseObject нужны еще методы.
Пока это будут пустые методы draw() и move().
Классы-наследники должны будут переопределить их у себя и реализовать необходимую функциональность.

Еще добавь метод die() - объект умирает (isAlive=false)

А еще нам нужно будет определять попала бомба в корабль или ракета в НЛО.
Это будем делать так:
Создадим специальный метод: public boolean isIntersect(BaseObject o)
Он будет определять - "пересеклись" объекты или нет. Если пересеклись - возвращать true, если нет - false.

Т.к. объекты мы условно считаем кругами, то предлагаю такую формулу взаимодействия:
eсли центр круга одного объекта попал в круг другого, то будем считать, что они столкнулись.
Или еще проще:
дистанция_между_объектами < max (радиус_первого_объекта, радиус_второго_объекта).


Требования:
1. В классе BaseObject создай пустой метод draw().
2. В классе BaseObject создай пустой метод move().
3. В классе BaseObject создай метод die(), который присваивает полю isAlive значение false.
4. В классе BaseObject создай метод isIntersect(BaseObject o), который возвращает boolean.
5. Реализуй метод isIntersect(BaseObject o). В случае если объекты столкнулись, нужно вернуть true, иначе - false
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
