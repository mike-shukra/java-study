package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
/*
Ипподром(6)
Теперь перейдем к классу Hippodrome и методу main.
Нам нужно создать объект типа Hippodrome и добавить ему несколько лошадей.

Для начала, в классе Hippodrome:
Создай статическое поле game типа Hippodrome.

В методе main требуется:
а) Создать объект типа Hippodrome и сохранить его в поле game.
б) Создать три объекта "лошадь". Имена придумай сам. Начальные скорость у всех лошадей - 3, дистанция - 0.
в) Добавить созданных лошадей в список лошадей ипподрома (horses). Получить список лошадей ипподрома можно с помощью метода getHorses.


Требования:
1. В классе Hippodrome должно быть создано поле game типа Hippodrome.
2. Поле game должно быть статическим.
3. Поле game НЕ должно быть приватным.
4. В методе main должно инициализироваться поле game.
5. В методе main в список лошадей ипподрома должны быть добавлены три лошади.
6. Скорости всех лошадей должны быть равны 3, а дистанции - 0.
 */
public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses = new ArrayList<Horse>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("horseOne", (double)3, (double)0));
        game.horses.add(new Horse("horseTwo", (double)3, (double)0));
        game.horses.add(new Horse("horseThree", (double)3, (double)0));
    }
}
