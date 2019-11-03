package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/*
4. Создай пакет view. В нем создай интерфейс View.

5. В интерфейс View добавь два метода: void refresh(ModelData modelData) и void setController(Controller controller)


Требования:
1. Класс Controller должен быть создан в пакете controller.
2. В классе Controller должно быть создано приватное поле Model model и сеттер для этого поля.
3. В классе Controller должен быть создан публичный метод void onShowAllUsers(), в котором у модели должен вызываться метод loadUsers().
4. Интерфейс View должен быть создан в пакете view.
5. В интерфейсе View должны быть объявлены два метода: void refresh(ModelData modelData) и void setController(Controller controller).
 */
public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
