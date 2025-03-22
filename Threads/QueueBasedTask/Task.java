package QueueBasedTask;

import java.util.concurrent.Callable;

public interface Task extends Callable<String> {
    String getTaskName();
}
