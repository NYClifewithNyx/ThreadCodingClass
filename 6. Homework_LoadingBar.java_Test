import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Title {

    private static volatile boolean running = true;
    // 다른 스레드에서 값을 바꿀 수 있게 volatile 사용

    public static void main(String[] args) throws Exception {
        System.out.println("게임을 로딩 중입니다...\n");

        int total = 20; // 로딩바 길이

        for (int i = 0; i <= total; i++) {

            // ■■□□ 형태로 막대 생성
            String bar = "■".repeat(i) + "□".repeat(total - i);

            int percent = (i * 100) / total;

            System.out.print("\r[" + bar + "] " + percent + "%");

            Thread.sleep(200);
        }

        pressEnterToStart();
        System.out.println("\n게임을 시작합니다...");
    }

    public static void pressEnterToStart() throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String red = "\u001B[31m";
        String reset = "\u001B[0m";

        String text = "PRESS ENTER TO START";
        String message = red + text + reset;
        String empty = " ".repeat(text.length());

        // ✨ 스레드 1: 깜빡이는 텍스트
        Thread blinkThread = new Thread(() -> {
            try {
                while (running) {
                    System.out.print("\r" + message);
                    Thread.sleep(400);
                    System.out.print("\r" + empty);
                    Thread.sleep(400);
                }
            } catch (InterruptedException ignored) {}
        });

        blinkThread.start();

        // ✨ 스레드 2: 엔터 입력 감지
        br.readLine();  // 엔터 누를 때까지 대기

        // 스레드 종료 신호
        running = false;

        // 깜빡임 마지막 남은 줄 지우기
        System.out.print("\r" + empty);

        // 완전히 멈출 때까지 대기
        blinkThread.join();
    }
}
//public class Title {
//
//    public static void main(String[] args) throws InterruptedException {
//        loading();
//    }
//
//        public static void loading() throws InterruptedException {
//            System.out.println("게임을 로딩 중입니다...\n");
//
//            int total = 20; // 로딩바 길이
//
//            for (int i = 0; i <= total; i++) {
//
//                // ■■□□ 형태로 막대 생성
//                String bar = "■".repeat(i) + "□".repeat(total - i);
//
//                int percent = (i * 100) / total;
//
//                System.out.print("\r[" + bar + "] " + percent + "%");
//
//                Thread.sleep(200);
//            }
//
//            System.out.println("\n\n게임이 로딩 되었습니다!");
//        }
//
//
//    public static void loading() throws InterruptedException {
//        System.out.println("게임을 로딩 중입니다...");
//
//        for (int i = 0; i <= 10; i++) {
//            System.out.printf("\r로딩: %3d%%", i * 10);
//            Thread.sleep(300); // 0.3초
//        }
//
//        for (int i = 0; i <= 10; i++) {
//            System.out.print("\r로딩: " + (i * 10) + "%");
//            Thread.sleep(300); // 0.3초
//        }
//
//
//}
