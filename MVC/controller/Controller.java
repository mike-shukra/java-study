package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/*
MVC (2)
1. Создай пакет controller, в котором создай класс Controller.
Этот класс будет получать запрос от клиента, оповещать Модель об этом, а Модель, в свою очередь, будет обновлять ModelData.

2. Добавь в контроллер поле Model model вместе с сеттером.

3. В контроллере создай публичный метод void onShowAllUsers(), который должен обратиться к модели и инициировать загрузку пользователей.

******************************************
******************************************
******************************************
******************************************

6. Запусти main. Упс, ничего не вывело : (
Это получилось потому, что данные пришли с сервера, обновились в ModelData, но Вью ничего о них не знает.
Вью сама не умеет себя обновлять. Это делает Контроллер.
Пойди в контроллер и добавь обновление данных во Вью.
Напомню, данные хранятся в Модели.

7. Запусти main. У меня теперь такой вывод:
All users:
    User{name='A', id=1, level=1}
    User{name='B', id=2, level=1}
===================================================
Ура, идем дальше.

 */
public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;


    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }
    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }
    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }
    public void onUserDelete(long id){
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }
    public void onUserChange(String name, long id, int level){
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());

    }


    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

//    public UsersView getUsersView() {
//        return usersView;
//    }
}
