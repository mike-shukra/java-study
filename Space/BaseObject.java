package com.javarush.task.task25.task2515;
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
abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    private boolean isAlive;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
