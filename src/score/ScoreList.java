package score;

import student.Student;

import java.util.ArrayList;

// N수강생들의 모든 Score 객체가 저장되는 클래스, main 클래스에서 프로그램이 동작함과 동시에 초기화가 필요함.
public class ScoreList {
    private static ArrayList<Score> scoreStore;

    public ScoreList(){
        ScoreList scoreStore = new ScoreList();
    };

    public void scoreListAdd (Score score) {
        scoreStore.add(score);
        System.out.println("점수 객체가 리스트에 저장되었습니다.");
    }

//    public void getScoreList (Student studentId) {
//        for (int i=0; i<)
//        scoreStore.get();
//    }
}
