package fanur.Controller;

import fanur.Data.Priority;
import fanur.Data.Task;
import fanur.Repository.ReaderService;
import fanur.Service.SchedulerService;
import fanur.Service.TaskService;
import fanur.View.TaskViewer;

import java.util.HashMap;
import java.util.List;

public class Controller {
    private final SchedulerService scheduleService = new SchedulerService();
    private final TaskService taskService;
    private final TaskViewer viewer;

    private final ReaderService readerService;

    public Controller() {
        this.taskService = new TaskService();
        this.viewer = new TaskViewer();
        this.readerService = new ReaderService();
    }

    public void startScheduler() {
        this.scheduleService.startScheduler();

    }

    public void addTask(Priority priority, String handler, String description, String author) {
        scheduleService.addTaskInScheduler(taskService.createTask(priority, handler, description, author));
    }

    public void showTasks()
    {this.viewer.showTasks(scheduleService.getTasks());
    }

    public  List<Task> getTasks(){
        return scheduleService.getTasks();
    }


    public void editTask(Integer taskId, HashMap<String ,?> map ){
        this.taskService.editTask(scheduleService.getTaskById(taskId),map);
    }

    public void showTaskById(Integer taskId){
        this.viewer.showTask(scheduleService.getTaskById(taskId));

    }

    public void deleteTask(Integer taskId){
        scheduleService.deleteTaskById(taskId);
    }

    public void writeData(List<Task> taskList, String format){

        this.readerService.writeData(taskList, format);

    }

    public void readeData( String format) {

        this.readerService.readData(format);

    }

}