package com.javarush.task.task36.task3608.model;
/*
Напишем приложение, которое будет показывать список пользователей и что-то делать с ними, например, обновлять их данные и удалять.

1. Создай пакет model, в котором создай класс ModelData.
ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте.
Создай поле с геттером и сеттером List<User> users - это будет список пользователей для отображения.

2. Используя любую модель должна быть возможность получить все необходимые данные для отображения. Поэтому в пакете model создай интерфейс Model,
который должен содержать метод ModelData getModelData().

3. В пакете model создай класс FakeModel, реализующий Model. Он нам понадобится на начальном этапе.
В нем создай поле ModelData modelData, которое инициализируй объектом.

4. В интерфейсе Model создай метод void loadUsers().
Реализуй его в FakeModel: инициализируй список пользователей modelData любыми данными. Они не влияют на тестирование.

У меня такие данные:
User{name='A', id=1, level=1}
User{name='B', id=2, level=1}

Думаю, ты помнишь, что все методы интерфейса являются public-ами, поэтому модификатор указывать не нужно.
Программисты часто мОкают данные на начальном этапе. Получение реальных данных реализуется на последних этапах.
Мокать - это подменять реальные объекты на хардкоженные, тестовые данные.


Требования:
1. Класс ModelData должен быть создан в пакете model.
2. В классе ModelData должно быть создано приватное поле List<User> users, геттер и сеттер для него.
3. Интерфейс Model должен быть создан в пакете model. В интерфейсе Model должен быть объявлен метод ModelData getModelData().
4. Класс FakeModel, реализующий интерфейс Model, должен быть создан в пакете model.
5. В классе FakeModel должно быть создано и инициализировано приватное поле ModelData modelData.
6. В интерфейсе Model должен быть объявлен метод void loadUsers().
7. Метод void loadUsers() в классе FakeModel должен инициализировать список пользователей в объекте modelData любыми данными.
 */

import com.javarush.task.task36.task3608.bean.User;
import java.util.List;

public class ModelData {
    private List<User> users;
    private User activeUser;

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    private boolean displayDeletedUserList;

    void loadUsers(){}

    public List<User> getUsers() {
        return users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
