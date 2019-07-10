package com.javarush.task.task25.task2515;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Главный класс игры - Космос (Space)
 */

/*
Space (15)
Надо еще закончить класс Space.

Напиши метод getAllItems:
Метод должен возвращать один общий список всех объектов типа BaseObject.

Напиши метод moveAllItems:
Метод должен двигать все объекты по одному разу.
Надо:
а) получить список всех объектов типа BaseObject;
б) вызвать у каждого из них метод move().


Требования:
1. В классе Space реализуй метод getAllItems(). Он должен возвращать список всех объектов типа BaseObject, которые сохранены в полях Space.
2. В классе Space реализуй метод moveAllItems(). Он должен вызывать move() у всех объектов типа BaseObject, которые сохранены в полях Space.

Space (16)
И еще немного:

Напиши метод createUfo():
Если список НЛО пуст - создай один корабль в центре сверху.

Напиши метод checkBombs():
Надо проверить - не пересеклись между собой какая-нибудь бомба и корабль.
Если пересеклись - корабль и бомба умирают - die().
Если бомба упала за границу экрана y > height бомба тоже умирает.

Напиши метод checkRockets():
Надо проверить - не пересеклись между собой какая-нибудь ракета и НЛО.
Если пересеклись - ракета и нло умирают - die().
Если ракета улетела за границу экрана y < 0, ракета тоже умирает.

Напиши метод removeDead():
В этом методе удали из списков ufos, rockets, bombs все мертвые объекты (isAlive() == false).


Требования:
1. В классе Space реализуй метод createUfo() согласно описанию в задании.
2. В классе Space реализуй метод checkBombs() согласно описанию в задании.
3. В классе Space реализуй метод checkRockets() согласно описанию в задании.
4. В классе Space реализуй метод removeDead() согласно описанию в задании.

 */
public class Space {
    //Ширина и высота игрового поля
    private int width;
    private int height;

    //Космический корабль
    private SpaceShip ship;
    //Список НЛО
    private List<Ufo> ufos = new ArrayList<Ufo>();
    //Список бомб
    private List<Bomb> bombs = new ArrayList<Bomb>();
    //Список ракет
    private List<Rocket> rockets = new ArrayList<Rocket>();

    private List<BaseObject> baseObjects = new ArrayList<BaseObject>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }



    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем холст для отрисовки.
        Canvas canvas = new Canvas(width, height);

        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //Игра работает, пока корабль жив
        while (ship.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если "стрелка влево" - сдвинуть фигурку влево
                System.out.print(event.getKeyCode());
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    ship.moveLeft();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    ship.moveRight();
                    //Если "пробел" - стреляем
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ship.fire();
            }

            //двигаем все объекты игры
            moveAllItems();

            //проверяем столкновения
            checkBombs();
            checkRockets();
            //удаляем умершие объекты из списков
            removeDead();

            //Создаем НЛО (1 раз в 10 ходов)
            createUfo();

            //Отрисовываем все объекты на холст, а холст выводим на экран
            canvas.clear();
            draw(canvas);
            canvas.print();

            //Пауза 300 миллисекунд
            Space.sleep(300);
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Двигаем все объекты игры
     */
    public void moveAllItems() {
        //нужно получить список всех игрвых объектов и у каждого вызвать метод move().
        for (BaseObject obj: getAllItems()) {
            obj.move();
        }
    }

    /**
     * Метод возвращает общий список, который содержит все объекты игры
     */
    public List<BaseObject> getAllItems() {
        //нужно создать новый список и положить в него все игровые объекты.

        baseObjects.addAll(ufos);
        baseObjects.addAll(bombs);
        baseObjects.addAll(rockets);
        baseObjects.add(ship);
        return baseObjects;
    }

    /**
     * Создаем новый НЛО. 1 раз на 10 вызовов.
     */
    public void createUfo() {
        //тут нужно создать новый НЛО.
        //1 раз за 10 вызовов метода.
        double x = Math.random() * width;
        double y = Math.random() * height / 2;
        if (ufos.size() == 0) ufos.add(new Ufo(x, y));
    }

    /**
     * Проверяем бомбы.
     * а) столкновение с кораблем (бомба и корабль умирают)
     * б) падение ниже края игрового поля (бомба умирает)
     */
    public void checkBombs() {
        //тут нужно проверить все возможные столкновения для каждой бомбы.
//        Надо проверить - не пересеклись между собой какая-нибудь бомба и корабль.
//        Если пересеклись - корабль и бомба умирают - die().
//        Если бомба упала за границу экрана y > height бомба тоже умирает.
        for (Bomb bomb : bombs) {
            if (bomb.isIntersect(ship)) {
                bomb.die();
                ship.die();
            }

            if (bomb.getY() > height) bomb.die();
        }
    }

    /**
     * Проверяем рокеты.
     * а) столкновение с НЛО (ракета и НЛО умирают)
     * б) вылет выше края игрового поля (ракета умирает)
     */
    public void checkRockets() {
        //тут нужно проверить все возможные столкновения для каждой ракеты.
        for (Rocket rocket : rockets) {
            for (Ufo ufo : ufos) {
                if (ufo.isIntersect(rocket)) {
                    ufo.die();
                    rocket.die();
                }
            }

            if (rocket.getY() < 0) rocket.die();
        }
    }

    /**
     * Удаляем умершие объекты (бомбы, ракеты, НЛО) из списков
     */
    public void removeDead() {
        //тут нужно удалить все умершие объекты из списков.
        //Кроме космического корабля - по нему определяем идет еще игра или нет.
        bombs.removeIf(x -> !x.isAlive());
        ufos.removeIf(x -> !x.isAlive());
        rockets.removeIf(x -> !x.isAlive());

        baseObjects.removeIf(x -> !x.isAlive());
    }

    /**
     * Отрисовка всех объектов игры:
     * а) заполняем весь холст точками.
     * б) отрисовываем все объекты на холст.
     */
    public void draw(Canvas canvas) {
        //тут нужно отрисовать все объекты игры
    }


    public SpaceShip getShip() {
        return ship;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public List<Ufo> getUfos() {
        return (ArrayList<Ufo>) ufos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Bomb> getBombs() {
        return (ArrayList<Bomb>) bombs;
    }

    public List<Rocket> getRockets() {
        return (ArrayList<Rocket>) rockets;
    }

    public static Space game;

    public static void main(String[] args) throws Exception {
        game = new Space(20, 20);
        game.setShip(new SpaceShip(10, 18));
        game.run();
    }

    /**
     * Метод делает паузу длинной delay миллисекунд.
     */
    public static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}
