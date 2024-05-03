import java.util.Scanner;
import subject.Subject;
import subject.SubjectList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SubjectList subjectList = new SubjectList();

        while (true) {
            System.out.println("\n1. 과목 등록 ");
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
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerSubject(Scanner sc, SubjectList subjectList) {
        System.out.println("과목 ID를 입력하세요 (종료하려면 'exit' 입력)");
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("exit")) {
            int subjectId = Integer.parseInt(input);
            System.out.println("과목 이름을 입력하세요:");
            String subjectName = sc.nextLine();
            System.out.println("과목 유형을 입력하세요 (0: 선택과목, 1: 필수과목):");
            int subjectType = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기
            Subject subject = new Subject(subjectId, subjectName, subjectType);
            subjectList.addSubject(subject);
            System.out.println("과목이 등록되었습니다.");
            System.out.println("계속해서 과목을 등록하려면 과목 ID를 입력하세요 (종료하려면 'exit' 입력)");
            input = sc.nextLine();
        }
    }
}
