package com.javarush.task.task36.task3608.view;
/*

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
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()) {
            List<User> users = modelData.getUsers();
            System.out.println("All deleted users:");
            for (User user : users) {
                System.out.print("\t");
                System.out.println(user);
            }
            System.out.println("===================================================");
        }
        else{
            List<User> users = modelData.getUsers();
            System.out.println("All users:");
            for (User user : users) {
                System.out.print("\t");
                System.out.println(user);
            }
            System.out.println("===================================================");
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
