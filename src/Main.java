import java.util.Scanner;
import subject.Subject;
import subject.SubjectList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SubjectList subjectList = new SubjectList();

        System.out.println("‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗");
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
            System.out.println("1. 과목 등록 ");
            System.out.println("2. 등록된 과목 조회");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    registerSubject(sc, subjectList);
                    break;
                case "2":
                    subjectList.displaySubjects();
                    break;
                case "3":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close(); // Scanner 자원 해제
                    return; // 프로그램 종료
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerSubject(Scanner sc, SubjectList subjectList) {
        while (true) {
            System.out.println("과목 ID를 입력하세요 (종료하려면 'exit' 입력)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                return; // 과목 등록 종료
            }
            try {
                int subjectId = Integer.parseInt(input);
                System.out.println("과목 이름을 입력하세요:");
                String subjectName = sc.nextLine();
                System.out.println("과목 유형을 입력하세요 (0: 선택과목, 1: 필수과목):");
                int subjectType = Integer.parseInt(sc.nextLine());
                if (subjectType != 0 && subjectType != 1) {
                    System.out.println("잘못된 과목 유형입니다. 다시 입력하세요.");
                    continue; // 다음 반복으로 이동
                }
                Subject subject = new Subject(subjectId, subjectName, subjectType);
                subjectList.addSubject(subject);
                System.out.println("과목이 등록되었습니다.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식의 입력입니다. 다시 입력하세요.");
            }
        }
    }
}
