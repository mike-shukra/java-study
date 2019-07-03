package com.javarush.task.task22.task2213;

import java.awt.event.KeyEvent;
/*
Тетрис(12)
В тетрисе мы управляем движением фигурки с помощью клавиатуры.

Тут есть 4 действия:
движение влево (кнопка влево)
движение вправо (кнопка вправо)
поворот фигурки (цифра 5 на доп.клавиатуре справа)
падение вниз (пробел)

Мы будем обрабатывать ввод с клавиатуры в методе run() класса Tetris.

И тут у меня для тебя две новости: хорошая и плохая
Плохая новость состоит в том, что java не позволяет считать нажатые символы с клавиатуры,
пока пользователь не нажмет enter.
Не очень удобно, правда?

Хорошая новость состоит в том, что я написал специальный класс (KeyboardObserver), который позволяет обойти это ограничение.
Так что ты можешь воспользоваться им.

Есть еще и отличная новость.
Ты до сих пор отлично справлялся, поэтому я помогу тебе немного.
Я написал за тебя методы:
а) createRandomFigure в FigureFactory
б) run в Tetris

Изучи их внимательно и переходи дальше.


Требования:
1. Внимательно изучи метод run в классе Tetris.
2. Внимательно изучи метод createRandomFigure в классе FigureFactory.
3. Внимательно изучи класс KeyboardObserver.

******************************
******************************
******************************
******************************
******************************
******************************

Тетрис(13)
Теперь приступим к реализации созданных методов.
Напиши реализацию метода print в классе Field
а) Метод должен выводить на экран прямоугольник состоящий из символов '.' и 'X'.
б) Высота прямоугольника равна height, ширина - width
в) Если данная клетка пустая - вывести точку, если не пустая - английский X

Подсказка:
if (matrix[y][x]==0) ...


Требования:
1. Метод print должен выводить данные на экран.
2. Метод print должен выводить на экран количество строк равное height.
3. Количество символов в каждой строке выведенной на экран должно быть равно width.
4. В случае, если элемент массива равен 0 - на экран должна быть выведена точка, иначе - английский X.

 */
/**
 * Класс Tetris - содержит основной функционал игры.
 */
public class Tetris {
    private Field field;                //Поле с клетками
    private Figure figure;              //Фигурка

    private boolean isGameOver;         //Игра Окончена?

    public Tetris(int width, int height) {
        field = new Field(width, height);
        figure = null;
    }

    /**
     * Геттер переменной field.
     */
    public Field getField() {
        return field;
    }

    /**
     * Геттер переменной figure.
     */
    public Figure getFigure() {
        return figure;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() throws Exception {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //выставляем начальное значение переменной "игра окончена" в ЛОЖЬ
        isGameOver = false;
        //создаем первую фигурку посередине сверху: x - половина ширины, y - 0.
        figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0);

        //пока игра не окончена
        while (!isGameOver) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                //получить самое первое событие из очереди
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;
                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    figure.left();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    figure.right();
                    //Если  код клавиши равен 12 ("цифра 5 на доп. клавиатуре") - повернуть фигурку
                else if (event.getKeyCode() == 12)
                    figure.rotate();
                    //Если "пробел" - фигурка падает вниз на максимум
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    figure.downMaximum();
            }

            step();             //делаем очередной шаг
            field.print();      //печатаем состояние "поля"
            Thread.sleep(300);  //пауза 300 миллисекунд - 1/3 секунды
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over");
    }

    /**
     * Один шаг игры
     */
    public void step() {
        //опускам фигурку вниз

        //если разместить фигурку на текущем месте невозможно:
        //поднимаем обратно
        //приземляем
        //если фигурка приземлилась на самом верху - игра окончена
        //удаляем заполненные линии
        //создаем новую фигурку

    }

    /**
     * Сеттер для figure
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    /**
     * Сеттер для field
     */
    public void setField(Field field) {
        this.field = field;
    }

    public static Tetris game;

    public static void main(String[] args) throws Exception {
        game = new Tetris(10, 20);
        game.run();
    }
}
