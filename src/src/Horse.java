package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Horse implements Runnable {
    private final String name;
    private int progress = 0;
    private static final int TRACK_LENGTH = 50;
    private static final List<String> raceResults = new ArrayList<>();

    public synchronized void raceResults(String name) {
        raceResults.add(name);
    }

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (progress < TRACK_LENGTH) {
            try {
                // 말의 랜덤 이동 속도
                int move = random.nextInt(3) + 1; // 1~3칸 이동
                progress += move;

                // 현재 상태 출력
                printTrack();

                // 대기 시간 (0.1~0.3초)
                Thread.sleep(random.nextInt(200) + 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(name + " 결승선을 통과했습니다!!");
        raceResults(name); // 경주 결과에 말 이름 추가
    }

    private void printTrack() {
        StringBuilder track = new StringBuilder("|");
        for (int i = 0; i < TRACK_LENGTH; i++) {
            if (i == progress) {
                track.append("🐎"); // 말의 위치 표시
            } else {
                track.append("-");
            }
        }
        track.append("|");
        System.out.println(name + ": " + track);
    }

    public static List<String> getRaceResults() {
        return raceResults;
    }
}
