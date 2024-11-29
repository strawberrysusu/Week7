import static java.lang.Math.PI;

class Task extends Thread {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(taskName+" : "+Math.random() / PI);
        }
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        int taskCount = 1000;

        for (int i = 0; i < taskCount; i++) {
            Task task = new Task("Task" + i);
            task.start();
        }
    }
}