package com.javarush.task.task25.task2515;
/*
Space (7)
Теперь займемся классом Canvas.
Он у нас будет содержать матрицу, куда мы будем рисовать.
У матрицы есть ширина и высота.
А еще будем в ней хранить не числа (int), а символы (char).

Надо:
а) Добавить в класс две переменные width и height;
б) Добавить в класс переменную matrix (char[][]);
в) Добавь геттеры для них;
г) В конструкторе проинициализируй матрицу.


Требования:
1. В классе Canvas создай поле width. Добавь для него getter.
2. В классе Canvas создай поле height. Добавь для него getter.
3. В классе Canvas создай поле matrix (char[][]). Добавь для него getter.
4. В классе Canvas создай конструктор Canvas(int width, int height). Инициализируй поля width и height.
5. Инициализируй в конструкторе поле matrix (char[height][width]).
 */
public class Canvas {
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }

    private int width;
    private int height;
    private char[][] matrix;
}
