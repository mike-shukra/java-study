package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Чат (2)
Первым делом, для удобства работы с консолью реализуем класс ConsoleHelper. В дальнейшем, вся работа с консолью должна происходить через этот класс.

Добавь в него:
1. Статическое поле типа BufferedReader, инициализированное с помощью System.in.
2. Статический метод writeMessage(String message), который должен выводить сообщение message в консоль.
3. Статический метод String readString(), который должен считывать строку с консоли.
Если во время чтения произошло исключение, вывести пользователю сообщение "
Произошла ошибка при попытке ввода текста. Попробуйте еще раз."
И повторить ввод. Метод не должен пробрасывать исключения IOException наружу.
Другие исключения не должны обрабатываться.
4. Статический метод int readInt(). Он должен возвращать введенное число и использовать метод readString().
Внутри метода обработать исключение NumberFormatException.
Если оно произошло вывести сообщение
"Произошла ошибка при попытке ввода числа. Попробуйте еще раз."
И повторить ввод числа.

В этой задаче и далее, если не указано дополнительно другого, то все поля класса должны быть приватными, а методы публичными.


Требования:
1. В классе ConsoleHelper должно быть создано и инициализировано приватное, не финальное, статическое поле типа BufferedReader.
2. В классе ConsoleHelper должен быть реализован статический метод writeMessage(String message), выводящий сообщение на консоль.
3. В классе ConsoleHelper должен быть реализован статический метод readString, возвращающий строку считанную с консоли.
4. В классе ConsoleHelper должен быть реализован статический метод readInt, возвращающий число считанное с консоли.
5. Метод readInt должен использовать метод readString для чтения с консоли.
6. Метод readString должен перехватывать IOException, выводить сообщение о некорректном вводе и повторять считывание с консоли.
7. Метод readInt должен перехватывать NumberFormatException, выводить сообщение о некорректном вводе и повторять считывание с консоли.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String s;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return readString();
        }
        return s;
    }
    public static int readInt(){
        int i;
        try {
            String s = readString();
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return readInt();
        }
        return i;
    }



}
