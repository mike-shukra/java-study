package com.javarush.task.task25.task2515;
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
    public void draw(){}
    public void move(){}
    public void die(){
        this.isAlive = false;
    }
    public boolean isIntersect(BaseObject o){
//        дистанция_между_объектами < max (радиус_первого_объекта, радиус_второго_объекта)
        double distance = Math.sqrt(Math.pow((this.getX() - o.getX()), 2) + Math.pow((this.getY() - o.getY()), 2));
        return (distance <= (this.getRadius() + o.getRadius()));
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
