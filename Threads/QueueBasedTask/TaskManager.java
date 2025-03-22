package QueueBasedTask;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskManager {
    private static final Logger LOGGER = Logger.getLogger(TaskManager.class.getName());
    private final ScheduledThreadPoolExecutor service;
    private final Queue<Future<String>> runningTasks;
    private final Map<String,String> taskResultMap;
    public TaskManager() {
        final int THREAD_POOL_SIZE = 2;
        service = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(THREAD_POOL_SIZE); // process 5 thread parallel
        service.setMaximumPoolSize(THREAD_POOL_SIZE * 3); // It's the queue size.

        // If queue is full, then old thread still waiting in queue will be removed
        service.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());

        runningTasks = new LinkedBlockingDeque<>(service.getMaximumPoolSize());
        taskResultMap = new ConcurrentHashMap<>();
    }
    public void runImmediately(Task task) {
        LOGGER.log(Level.INFO,"Going to execute task : {0} immediately .. ",new Object[]{task.getTaskName()});
        Future<String> future = service.submit(task);
        runningTasks.add(future);
    }
    public void runWithSpecifiedDelay(Task task ,int delay, TimeUnit unit) {
        LOGGER.log(Level.INFO,"Going to execute task : {0} for a delay of {1} in {2} .. ",new Object[]{task.getTaskName(),delay,unit.name()});
        Future<String> future = service.schedule(task, delay, unit);
        runningTasks.add(future);
    }
    public void seeStatusOfQueue() {
        try {
            runningTasks
                    .stream()
                    .parallel()
                    .filter(Future::isDone)
                    .forEach(x -> {
                        try {
                            System.out.println("Task output : "+x.get());
                            // here we can implement if task fails then return any String as failed,
                            // and we can handle as per retry count OR something !
                            runningTasks.remove(x);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception on watching queue... ",e);
        }
    }

    public boolean isStillActive() {
        return !runningTasks.isEmpty();
    }
    public void endService() {
        service.shutdown();
    }
}
