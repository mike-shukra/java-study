package com.javarush.task.task25.task2515;
/*
Space (13)
Теперь перейдем к методам draw, move.
В методе move() надо:
а) увеличить x на dx;
б) проверить, не вылез ли корабль за границы космоса [0, Space.game.getWidth()]. Используй метод checkBorders.
Учти, что ширина корабля равна двум его радиусам.

Метод draw я напишу сам - просто объяви пустой метод.

Еще нам понадобится метод fire(), ведь корабль умеет стрелять.
Этот метод вызывается, когда надо произвести выстрел.

В этом методе надо:
а) создать две ракеты;
б) установить им координаты левого края корабля и правого края корабля (пушки находятся на расстоянии 2 от центра корабля);
в) добавить эти ракеты в список ракет объекта game.

Его можно получить так:
Space.game.getRockets()


Требования:
1. В классе SpaceShip напиши метод move(), который увеличивает поле x на значение dx и проверяет, не вылез ли корабль за границы космоса.
2. В классе SpaceShip добавь пустой метод draw(Canvas canvas).
3. В классе SpaceShip напиши метод fire(), который создает две ракеты с координатами левого и правого края корабля и добавляет их в поле rockets у объекта game.
 */
public class SpaceShip extends BaseObject  {
    private double dx = 0;
    public void moveLeft(){
        dx = -1;
    }
    public void moveRight(){
        dx = 1;
    }
    public void fire(){
        Space.game.getRockets().add(new Rocket(x-2, y));
        Space.game.getRockets().add(new Rocket(x+2, y));

    }
    public void move(){
        checkBorders(0, Space.game.getWidth(), 0, Space.game.getHeight());
        x = x + dx;
        if (x < 0) x--;
        if (x > Space.game.getWidth()) x++;
    }

    public SpaceShip(double x, double y)
    {
        super(x, y, 3);
    }

    public void draw(Canvas canvas){}
}
