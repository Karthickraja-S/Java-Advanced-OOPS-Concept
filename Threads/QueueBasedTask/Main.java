package QueueBasedTask;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Task task = new Task() {
            @Override
            public String getTaskName() {
                return "Add Even Numbers";
            }

            @Override
            public String call() throws Exception {

                int sum = 0;
                for (int i = 0; i <= 10; i++) {
                    if (i % 2 == 0) {
                        Thread.sleep(2000);
                        sum += i;
                    }
                }
                return "Thread : "+getTaskName() + "; "+ new Date() + "; Sum : " + sum;
            }
        };
        Task task2 = new Task() {
            @Override
            public String getTaskName() {
                return "Add Odd Numbers";
            }

            @Override
            public String call() throws Exception {

                int sum = 0;
                for (int i = 0; i <= 10; i++) {
                    if (i % 2 != 0) {
                        sum += i;
                    }
                }
                return "Thread : "+getTaskName() + " "+ new Date() + " Sum : " + sum;
            }
        };
        TaskManager taskManager = new TaskManager();
        taskManager.runImmediately(task);
        taskManager.runImmediately(task2);
        while (taskManager.isStillActive()) {
            taskManager.seeStatusOfQueue();
        }
        System.out.println("Finished all tasks.. Like wise people can create task in multiple places and use");
        System.out.println("task manager as a single point of contact to manage all the tasks");
        taskManager.endService();
    }
}
