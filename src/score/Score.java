package score;

import java.util.ArrayList;

// 1수강생, 1과목에 대한 점수를 저장하는 객체 생성 클래스
public class Score {
    private final int STUDENT_ID;  // 수강생 고유번호
    private final int SUBJECT_ID;  // 과목 고유번호
    private final int SUBJECT_TYPE;
    ArrayList<ArrayList<String>> scoreAndGrade;    // 회차는 Index를 기준으로 함 (0~9)
    private final int SCORE_AND_GRADE_MAX_INDEX = 10;
    private final int MIN_SCORE = 0;
    private final int MAX_SCORE = 100;

    // 수강생 ID, 과제 ID를 기준으로 점수 객체 생성
    public Score(int studentId, int subjectId, int subjectType) {
        this.STUDENT_ID = studentId;
        this.SUBJECT_ID = subjectId;
        this.SUBJECT_TYPE = subjectType;
        scoreAndGrade = new ArrayList<>();
    }

    // 회차별 점수 등록
    public void scoreAdd(int score) {    // 입력할 회차에 점수가 기 등록되어있을 경우,이 메서드는 거부되어야함.
        if (score >= MIN_SCORE && score <= MAX_SCORE) {
            String scoreToString = Integer.toString(score);
            String scoreToGrade = "";

            switch (SUBJECT_TYPE) {
                case 1:
                    if (score >= 95) {
                        scoreToGrade = "A";
                    } else if (score >= 90) {
                        scoreToGrade = "B";
                    } else if (score >= 80) {
                        scoreToGrade = "C";
                    } else if (score >= 70) {
                        scoreToGrade = "D";
                    } else if (score >= 60) {
                        scoreToGrade = "F";
                    } else {
                        scoreToGrade = "N";
                    }
                    break;

                case 2:
                    if (score >= 90) {
                        scoreToGrade = "A";
                    } else if (score >= 80) {
                        scoreToGrade = "B";
                    } else if (score >= 70) {
                        scoreToGrade = "C";
                    } else if (score >= 60) {
                        scoreToGrade = "D";
                    } else if (score >= 50) {
                        scoreToGrade = "F";
                    } else {
                        scoreToGrade = "N";
                    }
                    break;

                default:
                    System.out.println("10회차까지 점수를 입력했거나, ");
            }

            ArrayList<String> scoreAndGradePair = new ArrayList<>();
            scoreAndGradePair.add(scoreToString);
            scoreAndGradePair.add(scoreToGrade);

            scoreAndGrade.add(scoreAndGradePair);

            animateScoreCompletion();
            System.out.println("                    점수 등록 완료 👌🏻");
        } else {
            System.out.println("❗ 점수는 0부터 100까지의 정수만 입력할 수 있습니다.");
        }
    }
    public void animateScoreCompletion() {
        String message = "                  ··· 점수 등록중 ···\n";

        for (char c : message.toCharArray()) {
            System.out.print(c);
            sleep(50);
        }
    }

    // sleep 메서드는 그대로 유지됩니다.
    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 점수 및 등급 수정
    public void setScore(int studentId, int subjectId, int round, int score) {
        if (this.STUDENT_ID == studentId && this.SUBJECT_ID == subjectId) {
            String scoreToString = Integer.toString(score);
            String scoreToGrade = "";

            switch (SUBJECT_TYPE) {
                case 1 : if (score >= 95) {
                    scoreToGrade = "A";
                } else if (score >= 90) {
                    scoreToGrade = "B";
                } else if (score >= 80) {
                    scoreToGrade = "C";
                } else if (score >= 70) {
                    scoreToGrade = "D";
                } else if (score >= 60) {
                    scoreToGrade = "F";
                } else {
                    scoreToGrade = "N";
                }
                    break;

                case 2 : if (score >= 90) {
                    scoreToGrade = "A";
                } else if (score >= 80) {
                    scoreToGrade = "B";
                } else if (score >= 70) {
                    scoreToGrade = "C";
                } else if (score >= 60) {
                    scoreToGrade = "D";
                } else if (score >= 50) {
                    scoreToGrade = "F";
                } else {
                    scoreToGrade = "N";
                }
                    break;

                default :
                    System.out.println("❗ 과목 타입에 오류가 있습니다.");
            }

            ArrayList<String> scoreAndGradePair = new ArrayList<>();
            scoreAndGradePair.add(scoreToString);
            scoreAndGradePair.add(scoreToGrade);

            for (int i = 0; i < scoreAndGrade.size(); i++) {
                if (i == round-1) {
                    scoreAndGrade.set(i, scoreAndGradePair);
                }
            }
        }
    }


    // 과목별 점수 조회
    public void getScore () {
        if (!scoreAndGrade.isEmpty()) {
            for (int i = 0; i < scoreAndGrade.size(); i++) {
                System.out.println("👉🏻"+i + 1 + "회차 : " + scoreAndGrade.get(i).get(0) + "점, 등급 : " + scoreAndGrade.get(i).get(1));
            }
        } else {
            System.out.println("❗ 등록된 점수가 없습니다.");
        }
    }

    // 과목 평균 등급 조회
    public void getAvgScore () {
        int sum = 0;
        for (int i=0; i < scoreAndGrade.size(); i++) {
            sum += Integer.parseInt(scoreAndGrade.get(i).get(0));
        }
        int avg = sum / scoreAndGrade.size();

        String avgGrade = "";
        switch (SUBJECT_TYPE) {
            case 1:
                if (avg >= 95) {
                    avgGrade = "A";
                } else if (avg >= 90) {
                    avgGrade = "B";
                } else if (avg >= 80) {
                    avgGrade = "C";
                } else if (avg >= 70) {
                    avgGrade = "D";
                } else if (avg >= 60) {
                    avgGrade = "F";
                } else {
                    avgGrade = "N";
                }
                break;

            case 2:
                if (avg >= 90) {
                    avgGrade = "A";
                } else if (avg >= 80) {
                    avgGrade = "B";
                } else if (avg >= 70) {
                    avgGrade = "C";
                } else if (avg >= 60) {
                    avgGrade = "D";
                } else if (avg >= 50) {
                    avgGrade = "F";
                } else {
                    avgGrade = "N";
                }
        }

        System.out.println(scoreAndGrade.size() + "회차 총점 " + sum + "점, " + "평균 " + avg + "점, " + avgGrade + "등급");
    }

    public int getStudentId() {
        return this.STUDENT_ID;
    }

    public int getSubjectid() {
        return this.SUBJECT_ID;
    }

    public int getScoreArraySize() {
        return this.scoreAndGrade.size();
    }
}