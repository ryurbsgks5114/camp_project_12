import java.util.Scanner;
import subject.Subject;
import subject.SubjectList;

public class Main {
    // 인덱스 타입 정의
    private static final String INDEX_TYPE_SUBJECT = "SJ";
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static final String INDEX_TYPE_SCORE = "SC";

    // 과목 타입 정의
    private static final int SUBJECT_TYPE_MANDATORY = 1;
    private static final int SUBJECT_TYPE_CHOICE = 2;

    // index 자동 증가
    private static int studentIndex = 0;
    private static int subjectIndex = 0;
    private static int scoreIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SubjectList subjectList = new SubjectList();

        setInitData(subjectList);

        System.out.println("‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗");
        System.out.println("‖ ███████ ████████ ██    ██ ██████  ███████ ███    ██ ████████  ‖");
        System.out.println("‖ ██         ██    ██    ██ ██   ██ ██      ████   ██    ██     ‖");
        System.out.println("‖ ███████    ██    ██    ██ ██   ██ █████   ██ ██  ██    ██     ‖");
        System.out.println("‖      ██    ██    ██    ██ ██   ██ ██      ██  ██ ██    ██     ‖");
        System.out.println("‖ ███████    ██     ██████  ██████  ███████ ██   ████    ██     ‖");
        System.out.println("‖                                                               ‖");
        System.out.println("‖                                                               ‖");
        System.out.println("‖ ███    ███  █████  ███    ██  █████   ██████  ███████ ██████  ‖");
        System.out.println("‖ ████  ████ ██   ██ ████   ██ ██   ██ ██       ██      ██   ██ ‖");
        System.out.println("‖ ██ ████ ██ ███████ ██ ██  ██ ███████ ██   ███ █████   ██████  ‖");
        System.out.println("‖ ██  ██  ██ ██   ██ ██  ██ ██ ██   ██ ██    ██ ██      ██   ██ ‖");
        System.out.println("‖ ██      ██ ██   ██ ██   ████ ██   ██  ██████  ███████ ██   ██ ‖");
        System.out.println("‖‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‖");

        while (true) {
            System.out.println("1. 등록된 과목 조회");
            System.out.println("2. 종료");
            System.out.print("선택: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    subjectList.displaySubjects();
                    break;
                case "2":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close(); // Scanner 자원 해제
                    return; // 프로그램 종료
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    // 초기 데이터 설정
    private static void setInitData(SubjectList subjectList) {
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "Java",
                SUBJECT_TYPE_MANDATORY
        ));
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "객체지향",
                SUBJECT_TYPE_MANDATORY
        ));
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "Spring",
                SUBJECT_TYPE_MANDATORY
        ));
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "JPA",
                SUBJECT_TYPE_MANDATORY
        ));
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "MySQL",
                SUBJECT_TYPE_MANDATORY
        ));
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "디자인 패턴",
                SUBJECT_TYPE_CHOICE
        ));
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "Spring Security",
                SUBJECT_TYPE_CHOICE
        ));
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "Redis",
                SUBJECT_TYPE_CHOICE
        ));
        subjectList.addSubject(new Subject(
                sequence(INDEX_TYPE_SUBJECT),
                "MongoDB",
                SUBJECT_TYPE_CHOICE
        ));
    }

    // index 자동 증가
    private static int sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return subjectIndex;
            }
            default -> {
                scoreIndex++;
                return scoreIndex;
            }
        }
    }
}
