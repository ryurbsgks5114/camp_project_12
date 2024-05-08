package student;

public class Intro {
    public static void main(String[] args) {
        animateIntro();
    }

    public static void animateIntro() {
        System.out.println("=============================================================");

        String introMessage = "매니저 로딩중 ··· 1년 12달 개발하조 팀의 내배캠 수강생 관리 프로그램👩🏻‍💻" ;

        // 문자열을 공백을 기준으로 분할하여 단어들을 배열에 저장
        String[] words = introMessage.split(" ");

        // 단어들을 순서대로 출력
        for (String word : words) {
            System.out.print(word+" ");
            sleep(1); // 각 단어 사이에 0.5초의 딜레이
        }
        System.out.println();
        System.out.print("=============================================================");

    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
