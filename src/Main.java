import idx.AutoIncrement;
import store.StaticDataStore;
import store.DynamicDataStore;
import score.Score;
import subject.Subject;
import subject.SubjectList;
import student.Intro;
import student.Student;
import student.StudentList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 과목 타입 정의
    private static final int SUBJECT_TYPE_MANDATORY = 1;
    private static final int SUBJECT_TYPE_CHOICE = 2;

    public static void main(String[] args) {

        DynamicDataStore<Student> studentDataStore = new DynamicDataStore<>();
        DynamicDataStore<Score> scoreDataStore = new DynamicDataStore<>();
        StaticDataStore<Subject> subjectDataStore = new StaticDataStore<>();
        AutoIncrement studentIdx = new AutoIncrement();
        AutoIncrement subjectIdx = new AutoIncrement();
        AutoIncrement scoreIdx = new AutoIncrement();

        SubjectList subjectList = new SubjectList();

        String[] mandatoryList = {"Java", "객체지향", "Spring", "JPA", "MySQL"};
        String[] choiceList = {"디자인 패턴", "Spring Security", "Redis", "MongoDB"};

        for (String el : mandatoryList) {
            subjectDataStore.addData(new Subject(subjectIdx.increase(), el, SUBJECT_TYPE_MANDATORY));
        }

        for (String el : choiceList) {
            subjectDataStore.addData(new Subject(subjectIdx.increase(), el, SUBJECT_TYPE_CHOICE));
        }

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

        Intro.animateIntro();

        Scanner sc = new Scanner(System.in);
        //학생 객체 저장 리스트
        List<Student> studentList = new ArrayList<>();
        boolean validStatus = false;
        String status = "";
        int studentId = 0;
        while (true) {
            System.out.println("\n                      1. 학생 등록");
            System.out.println("                      2. 학생 조회");
            System.out.println("                      3. 학생 수정");
            System.out.println("                      4. 학생 추가");
            System.out.println("                      5. 학생 삭제");
            System.out.println("                      6. 종료 ");

            System.out.println("=============================================================");
            System.out.print("                   번호를 선택하세요 : ");


            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choice) {
                //학생 등록
                case 1:
                    System.out.print("🎫 고유번호 : ");
                    while (!sc.hasNextInt()) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                        System.out.print("🎫 고유번호 : ");
                        sc.nextLine();
                    }
                    studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("📝 이름 : ");
                    String studentName = sc.nextLine();

                    while (!validStatus) {
                        System.out.print("🌠 상태 (Green, Red, Yellow) : ");
                        status = sc.nextLine();


                        if (status.equalsIgnoreCase("Green") || status.equalsIgnoreCase("Red") || status.equalsIgnoreCase("Yellow")) {
                            validStatus = true;
                        } else {
                            System.out.println("선택지에 없는 입력입니다. 다시 입력하세요.");
                        }
                    }
                    //학생 객체 생성
                    Student student = new Student(studentId, studentName, status);

                    //과목 목록 입력 받음
                    System.out.println("🧾 과목 목록 (종료하려면 'exit' 입력) : ");
                    List<String> newSubjectList = new ArrayList<>();
                    while (true) {
                        String subject = sc.nextLine();
                        if (subject.equalsIgnoreCase("exit")) {
                            break;
                        }
                        newSubjectList.add(subject);
                    }
                    // 학생 정보 및 과목 목록 추가
                    student.studentAdd(studentId, studentName, newSubjectList);
                    //생성된 학생 객체를 학생 리스트에 추가 - 새로운 학생을 등록할 때마다 그 학생을 리스트에 추가하여 관리
                    studentList.add(student);
                    System.out.print("-------------------------------------------------------------");


                    break;
                case 2:
                    System.out.println("전체 학생을 조회합니다.");
                    System.out.println("===================== 등록된 학생 목록 =========================");
                    for (Student student_inquiry : studentList) {
                        System.out.println("\n고유 번호 :" + student_inquiry.getStudentId() + "\n이름 : " + student_inquiry.getStudentName() +
                                "\n상태: " + student_inquiry.getStatus());
                        System.out.println("과목 목록:");
                        for (String subject : student_inquiry.getSubjectList()) {
                            System.out.println("    - " + subject);
                        }
                        System.out.print("-------------------------------------------------------------");
                    }
                    break;
                case 3:
                    //학생 수정
                    while (true) {
                        Student s = null;
                        System.out.println("===================== 등록된 학생 목록 =========================");
                        for (int i = 0; i < studentList.size(); i++) {
                            s = studentList.get(i);
                            System.out.println("📌 [" + s.getStudentId() + "] " + s.getStudentName());
                        }
                        System.out.println();

                        System.out.print("변경할 학생의 고유번호를 입력하세요 (메인 메뉴로 돌아가려면 0 입력): ");
                        int studentIdToChange = sc.nextInt();
                        sc.nextLine();

                        if (studentIdToChange == 0) {
                            break; // 메인 메뉴로 돌아가기
                        }

                        // 입력한 학생의 고유번호와 일치하는 학생 찾기
                        Student selectedStudent = null;
                        for (Student student2 : studentList) {
                            if (student2.getStudentId() == studentIdToChange) {
                                selectedStudent = student2;
                                break;
                            }
                        }

                        if (selectedStudent == null) {
                            System.out.println("해당하는 고유번호의 학생을 찾을 수 없습니다.");
                            continue; // 다시 입력 받기
                        }

                        // 선택된 학생의 정보 출력
                        System.out.println("<<선택한 학생 정보 ↓>> ");
                        System.out.println();
                        selectedStudent.studentInquiry();

                        System.out.println("\n===================== 변경 사항 선택 =========================");
                        System.out.println("1. 학생 이름 변경 ");
                        System.out.println("2. 학생 상태 변경  (Green, Red, Yellow) ");
                        System.out.println("3. 메인 메뉴 ");
                        System.out.print("선택: ");
                        int choice2 = sc.nextInt();
                        sc.nextLine();

                        switch (choice2) {

                            case 1:
                                System.out.print("이름을 변경하시겠습니까? (Y/N): ");
                                String changeName = sc.nextLine();

                                if (changeName.equalsIgnoreCase("Y")) {
                                    System.out.print("새로운 이름 입력: ");
                                    String newName = sc.nextLine();
                                    selectedStudent.setName(newName);
                                    System.out.println("이름이 변경되었습니다.");
                                }
                                break;
                            case 2:
                                System.out.print("상태를 변경하시겠습니까? (Y/N): ");
                                String changeStatus = sc.nextLine();

                                if (changeStatus.equalsIgnoreCase("Y")) {
                                    while (!validStatus) {
                                        System.out.print("새로운 상태 입력 (Green, Red, Yellow) : ");
                                        String newStatus = sc.nextLine();
                                        if (newStatus.equalsIgnoreCase("Green") || newStatus.equalsIgnoreCase("Red") || newStatus.equalsIgnoreCase("Yellow")) {
                                            validStatus = true;
                                        } else {
                                            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                                        }
                                        selectedStudent.setStatus(newStatus);
                                        System.out.println("상태가 변경되었습니다.");
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("메인 메뉴로 돌아갑니다.");
                                break;
                            default:
                                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                        }
                        // 메인 메뉴로 돌아가는 조건
                        if (choice2 == 3) {
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("새로운 학생을 추가합니다. ");
                    System.out.print("🎫 고유번호 : ");
                    while (!sc.hasNextInt()) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                        System.out.print("🎫 고유번호 : ");
                        sc.nextLine();
                    }
                    int newStudentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("📝 이름 : ");
                    String newName = sc.nextLine();

                    // 학생 추가할 때마다 validStatus 초기화
                    validStatus = false;
                    while (!validStatus) {
                        System.out.print("🌠 상태 (Green, Red, Yellow) : ");
                        String newStatus = sc.nextLine();
                        if (newStatus.equalsIgnoreCase("Green") || newStatus.equalsIgnoreCase("Red") || newStatus.equalsIgnoreCase("Yellow")) {
                            validStatus = true;
                            // 올바른 상태일 때만 추가
                            System.out.println("🧾 과목 목록 (종료하려면 'exit' 입력) : ");
                            List<String> newsubjectList = new ArrayList<>();
                            while (true) {
                                String subject = sc.nextLine();
                                if (subject.equalsIgnoreCase("exit")) {
                                    break;
                                }
                                newsubjectList.add(subject);
                            }
                            // 올바른 상태일 때만 추가
                            StudentList.studentAdd(studentList, newStudentId, newName, newStatus, newsubjectList);
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                        }
                    }

                    break;
                case 5:
                    // 학생 삭제
                    System.out.print("삭제할 학생의 이름을 입력하세요 : ");
                    String RemoveName = sc.nextLine();
                    StudentList.studentRemove(studentList, RemoveName);
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }

//        while (true) {
//            System.out.println("1. 등록된 과목 조회");
//            System.out.println("2. 종료");
//            System.out.print("선택: ");
//            String choice = sc.nextLine();
//
//            switch (choice) {
//                case "1":
//                    subjectList.displaySubjects();
//                    break;
//                case "2":
//                    System.out.println("프로그램을 종료합니다.");
//                    sc.close(); // Scanner 자원 해제
//                    return; // 프로그램 종료
//                default:
//                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
//            }
//        }

    }

}
