package com.javarush.task.task25.task2515;
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
public class Canvas {

    public void clear(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (char)0x20;
            }
        }
    }
    public void print(){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    public void setPoint(double x, double y, char c){
        if (x < 0 || y < 0 || y >= matrix.length || x >= matrix[0].length) return;
        int xxx = (int) Math.round(x);
        int yyy = (int) Math.round(y);
        this.matrix[yyy][xxx] = c;

    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) setPoint(x+j, y+i, c);
            }
        }
    }

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
