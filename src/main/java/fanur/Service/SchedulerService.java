package fanur.Service;

import fanur.Repository.ReaderService;
import fanur.Data.Scheduler;
import fanur.Data.Task;

import java.util.List;
import java.util.Optional;


public class SchedulerService {

    private final Scheduler scheduler = new Scheduler();
    private final ReaderService reader = new ReaderService();


    public void startScheduler() {
        System.out.println("Планировщик задач запущен");
    }

    public void addTaskInScheduler(Task task) {
        List<Task> tasksList = scheduler.getTasks();
        tasksList.add(task);
    }

    public List<Task> getTasks() {
        return scheduler.getTasks();
    }


    public Task getTaskById(Integer idTask) {
        List<Task> tasksList = new SchedulerService().getTasks();
        Optional<Task> task = tasksList.stream().
                filter(item -> idTask.equals(item.getId()))
                .findAny();
        if (!task.isPresent()) {
            throw new RuntimeException("Задача не найдена!");
        } else {
            return task.get();
        }
    }

    public void deleteTaskById(Integer taskId) {
        List<Task> taskList = this.getTasks();
        taskList.remove(this.getTaskById(taskId));


    }


}