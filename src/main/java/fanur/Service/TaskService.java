package fanur.Service;

import fanur.Data.Priority;
import fanur.Data.Task;
import java.util.HashMap;

public class TaskService {

    public Task createTask(Priority priority, String handler, String description, String author) {
        return new Task(priority, handler, description, author);
    }

    public void editTask(Task task, HashMap<String ,?> map  ){

        if (map.isEmpty()){
            throw new IllegalStateException("Редактируемые поля пусты!");
        }


        if (map.containsKey("Приоритет")) {
            task.setPriority((Priority) map.get("Приоритет"));

        }

        if (map.containsKey("Обработчик")) {
            task.setHandler((String) map.get("Обработчик"));

        }

        if (map.containsKey("Описание")) {
            task.setDescription((String) map.get("Описание"));

        }

        if (map.containsKey("Выполнено")) {
            task.setDone((Boolean) map.get("Выполнено"));

        }

        else {
            throw new IllegalStateException("Поле не найдено!");
        }
    }

}