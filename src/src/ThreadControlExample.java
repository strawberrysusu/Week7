package src;

class MyThreadcontrol extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Running: " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadControlExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        try {
            thread.join(); // MyThread가 끝날 때까지 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ends.");
    }
}

