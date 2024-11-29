import java.util.ArrayList;
import java.util.List;

public class HorseRaceGame {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        // 말 생성
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("마오너"));
        horses.add(new Horse("페잌마"));
        horses.add(new Horse("구말유시"));
        horses.add(new Horse("제홀스"));
        horses.add(new Horse("케리마"));

        for (Horse horse : horses) {
            Thread thread = new Thread(horse);
            threads.add(thread);
        }

        System.out.println("🏁 H1 경기를 시작합니다! 🏁");

        // 쓰레드 실행
        for (Thread thread : threads) {
            thread.start();
        }

        // 모든 쓰레드가 끝날 때까지 대기
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 경주 결과 출력
        List<String> results = Horse.getRaceResults();
        System.out.println("\nGG!");
        System.out.println("🏆 1등 : " + results.get(0) + " 🏆"); // 우승자 출력
        System.out.println("경기 결과:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + "등: " + results.get(i));
        }
    }
}
