package com.javarush.task.task25.task2515;

import java.util.Random;

/*
Space (14)
Теперь напиши класс Ufo.
Он чуть сложнее класса Bomb и проще SpaceShip.
Тебе понадобятся методы draw(), move(), fire().
Также не забудь о конструкторе. Типы параметров double, а радиус ufo будет равен 3.

Метод draw() сделай по аналогии с SpaceShip. Рисовать UFO будем символом 'U'.
И добавь матрицу, по аналогии с SpaceShip.

Метод move() надо сделать так:
а) корабль перемещается по случайной траектории;

Подсказка:
double dx = Math.random() * 2 - 1; //-1..1
double dy = Math.random() * 2 - 1; //-1..1

б) корабль не опускается в нижнюю половину экрана;
y <= height/2

в) С вероятностью 10% корабль должен стрелять - вызывать метод fire.

Метод fire():
Корабль сбрасывает одну бомбу по середине.
Сделать аналогично классу SpaceShip.


Требования:
1. В классе Ufo конструктор должен принимать координаты x и y, а радиус выставлять всегда равным 3.
2. В классе Ufo добавь поле с матрицей объекта по аналогии с классом SpaceShip.
3. В классе Ufo напиши метод draw(), который должен отрисовывать объект по аналогии с класcом SpaceShip.
4. В классе Ufo напиши метод move(), который изменяет координаты объекта согласно заданию.
5. В классе Ufo напиши метод fire(), который создает бомбу под объектом по середине и добавляет ее в список Space.bombs.
6. В классе Ufo в методе move() добавь вызов метода fire() c вероятностью 10%.
 */
public class Ufo extends BaseObject  {
    //картинка корабля для отрисовки
    private static int[][] matrix = {
            {1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 0, 1, 1},
    };

    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    public void move(){
        double dx = Math.random() * 2 - 1; //-1..1
        double dy = Math.random() * 2 - 1; //-1..1
        x = x + dx;
        y = y + dy;
//        б) корабль не опускается в нижнюю половину экрана;
//        y <= height/2
        checkBorders(radius, Space.game.getWidth() - radius + 1, 0, Space.game.getHeight()/2);

        if (new Random().nextInt(10) == 1) fire();
    }
    public void fire(){
        Space.game.getBombs().add(new Bomb(x, y + 3));
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }
}
