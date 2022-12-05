package fanur.Repository;

import fanur.Data.Task;

import java.util.List;

public interface Reader {

    String filename = "";

    void writeData(List<Task> tasks);

    void readData();
}
