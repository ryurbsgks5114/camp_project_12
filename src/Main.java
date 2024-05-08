import store.StudentStore;
import store.SubjectStore;
import subject.Subject;
import student.Intro;
import student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 과목 타입 정의
    private static final int SUBJECT_TYPE_MANDATORY = 1;
    private static final int SUBJECT_TYPE_CHOICE = 2;

    public static void main(String[] args) {

        StudentStore<Student> studentDataStore = new StudentStore<>();
        SubjectStore<Subject> subjectDataStore = new SubjectStore<>();

        String[] mandatoryList = {"Java", "객체지향", "Spring", "JPA", "MySQL"};
        String[] choiceList = {"디자인 패턴", "Spring Security", "Redis", "MongoDB"};

        for (String el : mandatoryList) {
            subjectDataStore.addData(new Subject(el, SUBJECT_TYPE_MANDATORY));

        }

        for (String el : choiceList) {
            subjectDataStore.addData(new Subject(el, SUBJECT_TYPE_CHOICE));
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

        boolean validStatus = false;
        String status = "";
        int studentId = 0;
        while (true) {
            System.out.println("\n                      1. 학생 등록");
            System.out.println("                      2. 학생 조회");
            System.out.println("                      3. 학생 수정");
            System.out.println("                      4. 학생 삭제");
            System.out.println("                      5. 종료 ");

            System.out.println("=============================================================");
            System.out.print("                   번호를 선택하세요 : ");

            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choice) {
                //학생 등록
                case 1:
                    validStatus = false;

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

                    List<String> subjectList = new ArrayList<>();

                    List<String> mandatorySelections = new ArrayList<>();
                    List<String> choiceSelections = new ArrayList<>();

                    while (true) {
                        System.out.println("필수 과목을 선택하세요 (3개 이상, 공백으로 구분하여 입력)");
                        subjectDataStore.inquiryDataByType(SUBJECT_TYPE_MANDATORY);
                        System.out.print("입력 :  ");
                        String mandatoryChoiceStr = sc.nextLine();
                        String[] mandatoryChoicesStr = mandatoryChoiceStr.split(" ");

                        if (mandatoryChoicesStr.length < 3) {
                            System.out.println("최소 3개의 과목을 선택해야 합니다. 다시 선택하세요.");
                            continue;
                        }

                        boolean validInput = true;
                        for (String choiceMandatory : mandatoryChoicesStr) {
                            int index = Integer.parseInt(choiceMandatory) - 1; // 인덱스 변환
                            if (index >= 0 && index < mandatoryList.length) {
                                mandatorySelections.add(mandatoryList[index]);
                            } else {
                                validInput = false;
                                System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                                break; // 잘못된 선택이 하나라도 있으면 더 이상 검사하지 않고 반복문 종료
                            }
                        }

                        if (!validInput) {
                            // 잘못된 선택이 있으면 반복문의 처음으로 돌아가 다시 입력을 받음
                            mandatorySelections.clear(); // 이전에 선택된 필수과목 항목들을 제거
                            continue;
                        }

                        break; // 필수 과목 선택이 유효하면 반복문 종료
                    }

                    while (true) {
                        System.out.println("선택 과목을 선택하세요 (2개 이상, 공백으로 구분하여 입력)");
                        subjectDataStore.inquiryDataByType(SUBJECT_TYPE_CHOICE);
                        System.out.print("입력 :  ");
                        String choiceChoiceStr = sc.nextLine();
                        String[] choiceChoicesStr = choiceChoiceStr.split(" ");

                        if (choiceChoicesStr.length < 2) {
                            System.out.println("최소 2개의 과목을 선택해야 합니다. 다시 선택하세요.");
                            continue;
                        }

                        boolean validInput = true;
                        for (String choiceChoice : choiceChoicesStr) {
                            int index = Integer.parseInt(choiceChoice) - 1; // 인덱스 변환
                            if (index >= 0 && index < choiceList.length) {
                                choiceSelections.add(choiceList[index]);
                            } else {
                                validInput = false;
                                System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                                break; // 잘못된 선택이 하나라도 있으면 더 이상 검사하지 않고 반복문 종료
                            }
                        }

                        if (!validInput) {
                            // 잘못된 선택이 있으면 반복문의 처음으로 돌아가 다시 입력을 받음
                            choiceSelections.clear(); // 이전에 선택된 선택과목 항목들을 제거
                            continue;
                        }

                        break; // 선택 과목 선택이 유효하면 반복문 종료
                    }

// 최종 선택 합치기
                    subjectList.addAll(mandatorySelections);
                    subjectList.addAll(choiceSelections);

                    // 학생 객체 생성
                    Student student = new Student(studentName, status);
                    student.setSubjectList(subjectList);

                    // 학생 추가
                    studentDataStore.addData(student);

                    System.out.print("-------------------------------------------------------------");
                    break;
                case 2:
                    studentDataStore.inquiryData();
                    break;
                case 3:
                    //학생 수정
                    while (true) {
                        Student s = null;
                        System.out.println("===================== 등록된 학생 목록 =========================");
                        for (int i = 0; i < studentDataStore.getDataStore().size(); i++) {
                            s = studentDataStore.getDataStore().get(i);
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
                        for (Student student2 : studentDataStore.getDataStore()) {
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
                                    validStatus = false;
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
                    // 학생 삭제
                    Student s = null;
                    System.out.println("===================== 등록된 학생 목록 =========================");
                    for (int i = 0; i < studentDataStore.getDataStore().size(); i++) {
                        s = studentDataStore.getDataStore().get(i);
                        System.out.println("📌 [" + s.getStudentId() + "] " + s.getStudentName());
                    }
                    System.out.println();

                    System.out.print("삭제할 학생의 이름을 입력하세요 : ");
                    String RemoveName = sc.nextLine();
                    studentDataStore.remove(RemoveName);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }

    }
}
