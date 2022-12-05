package fanur.View;

import fanur.Data.Task;

import java.util.List;
import java.util.logging.Logger;

public class TaskViewer {
    public void showTasks(List <Task> tasksList) {
        tasksList.forEach(task -> Logger.getAnonymousLogger().info(task.toString()));
    }

    public void showTask(Task task){
        Logger.getAnonymousLogger().info(task.toString());

    }


}
