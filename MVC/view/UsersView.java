package com.javarush.task.task36.task3608.view;
/*
MVC (3)
Чтобы понимать, в правильном ли направлении ты движешься, тебе надо видеть данные. Поэтому:

1. В пакете view создай класс UsersView, реализующий View. Он будет отображать список пользователей в консоль.

2. В UsersView создай поле-контроллер, также создай ему сеттер.

3. Реализуй логику метода refresh:
3.1. Выведи в консоль фразу "All users:".
3.2. Выведи в консоль всех пользователей, которые есть в modelData.
Перед каждым пользователем сделай отступ в виде табуляции.
3.3. В конце выведи визуальный разделитель данных
===================================================

4. Уже интересно посмотреть, что же получилось.
Добавь в UsersView публичный метод void fireEventShowAllUsers(), который будет эмулировать событие клиента.
Обратись к контроллеру и вызови его нужный метод для отображения всех пользователей.

7. Запусти main. У меня теперь такой вывод:
All users:
    User{name='A', id=1, level=1}
    User{name='B', id=2, level=1}
===================================================
Ура, идем дальше.

 */

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    @Override
    public void refresh(ModelData modelData) {
        List<User> users = modelData.getUsers();
        System.out.println("All users:");
        for (User user : users) {
            System.out.print("\t");
            System.out.println(user);
        }
//        System.out.print("===================================================");
        System.out.print("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
