package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

/*
Space (5)
Теперь перейдем к классу BaseObject.
Я хочу сделать несколько предложений.

Во-первых. Для простоты, считать все объекты у нас в космосе круглыми.
Нет, отрисовывать их мы будем фигурными, как и раньше.
А вот при расчетах их взаимодействия исходить из того, что они круглые.
Так - гораздо проще.

Во-вторых. Пусть координаты объектов и радиус будут вещественными числами.
Это придаст плавность движениям и точность всем вычислениям.
А при отрисовке мы будем их округлять.

Надо:
а) Добавь в класс BaseObject переменные x (double), y (double), radius (double), геттеры и сеттеры для них.
б) Добавить логическую переменную isAlive (жив объект или уже нет).
в) Добавить геттер (isAlive()-метод для isAlive-переменной).
г) Добавить конструктор BaseObject(double x, double y, double radius).
д) Проследить, чтобы в конструкторе isAlive устанавливался в true (мертворожденные нам ни к чему).
е) Надо пройтись по всем классам-наследникам и поправить у них конструкторы.
Если вы пользуетесь Intellij IDEA - Alt+Insert вам в помощь.


Требования:
1. В классе BaseObject создай поле x (double). Добавь для него getter и setter.
2. В классе BaseObject создай поле y (double). Добавь для него getter и setter.
3. В классе BaseObject создай поле radius (double). Добавь для него getter и setter.
4. В классе BaseObject создай поле isAlive (boolean). Добавь для него getter.
5. В классе BaseObject создай конструктор BaseObject(double x, double y, double radius). Поле isAlive должно устанавливаться в true.
6. Создай аналогичные конструкторы во всех классах, которые наследуются от BaseObject.
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
