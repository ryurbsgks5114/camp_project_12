import student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String SUBJECT_TYPE_MANDATORY = "필수";
    private static final String SUBJECT_TYPE_CHOICE = "선택";
    private static int studentIdx;
    private static int subjectIdx;
    private static int scoreIdx;

    public Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("\n1. 학생 등록 ");
            System.out.println("2. 학생 조회");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    System.out.print("고유번호: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("이름: ");
                    String studentName = sc.nextLine();

                    System.out.print("상태: ");
                    String status = sc.nextLine();

                    Student student = new Student(studentId, studentName, status);

                    System.out.println("과목 목록 입력 (종료하려면 'exit' 입력)");
                    List<String> subjectList = new ArrayList<>();
                    while (true) {
                        String subject = sc.nextLine();
                        if (subject.equalsIgnoreCase("exit")) {
                            break;
                        }
                        subjectList.add(subject);
                    }

                    student.studentAdd(studentId, studentName, subjectList);
                    studentList.add(student);
                    break;
                case 2:
                    System.out.println("===== 등록된 학생 목록 💌 =====");
                    for (int i = 0; i < studentList.size(); i++) {
                        Student s = studentList.get(i);
                        s.studentInquiry();

                        // 학생의 상태를 변경할지 여부를 물어봄
                        System.out.print("상태를 변경하시겠습니까? (Y/N): ");
                        String changeStatus = sc.nextLine();

                        if (changeStatus.equalsIgnoreCase("Y")) {
                            System.out.print("새로운 상태 입력: ");
                            String newStatus = sc.nextLine();
                            s.setStatus(newStatus);
                            System.out.println("상태가 변경되었습니다.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void setDataList() {

//        List<Student> studentList = new ArrayList<>();
//        List<Subject> subjectList = new ArrayList<>();
//        List<Score> scoreList = new ArrayList<>();

        List<String> mandatoryList = new ArrayList<String>();
        List<String> choiceList = new ArrayList<String>();

    }

}