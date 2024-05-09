import score.Score;
import store.ScoreStore;
import store.StudentStore;
import store.SubjectStore;
import subject.Subject;
import student.Intro;
import student.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final StudentStore<Student> studentDataStore = new StudentStore<>();
    private static final SubjectStore<Subject> subjectDataStore = new SubjectStore<>();
    private static final ScoreStore<Score> scoreDataStore = new ScoreStore<>();

    private static final String[] mandatoryList = { "Java", "객체지향", "Spring", "JPA", "MySQL" };
    private static final String[] choiceList = { "디자인 패턴", "Spring Security", "Redis", "MongoDB" };

    private static final int SUBJECT_TYPE_MANDATORY = 1;
    private static final int SUBJECT_TYPE_CHOICE = 2;

    private static final Scanner sc = new Scanner(System.in);

    private static boolean check;

    public static void main(String[] args) {

        setInitSubjectStore();
        displayMain();

    }

    private static void setInitSubjectStore() {

        for (String el : mandatoryList) {
            subjectDataStore.addData(new Subject(el, SUBJECT_TYPE_MANDATORY));
        }

        for (String el : choiceList) {
            subjectDataStore.addData(new Subject(el, SUBJECT_TYPE_CHOICE));
        }

    }

    private static void displayMain() {

        while (true) {

            if (!check) {

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

            }

            System.out.println("\n                      1. 학생 관리");
            System.out.println("                      2. 점수 관리");
            System.out.println("                      3. 프로그램 종료");
            System.out.println("=============================================================");
            System.out.print("                   번호를 선택하세요 : ");
            try{
                int mainNum = sc.nextInt();
                sc.nextLine();

                switch (mainNum) {
                    case 1 -> displayStudent();
                    case 2 -> displayScore();
                    case 3 -> {
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                      }
                    default ->  System.out.println("\n         ❗ 선택지 범위를 벗어났습니다 ··· 다시 선택해주세요.");
                    }
                    check = true;
            } catch(InputMismatchException e){
                System.out.println("\n         ❗ 잘못된 입력입니다 ··· 숫자를 입력해주세요.");
                sc.nextLine();
                check = true;
            }
        }
    }


    private static void displayStudent() {

        boolean checkDisplayStudent = true;
        boolean validStatus;
        String status = "";

        check = true;

        int studentNum = 0;

        while (checkDisplayStudent) {

            System.out.println("\n                      1. 학생 등록");
            System.out.println("                      2. 학생 조회");
            System.out.println("                      3. 학생 수정");
            System.out.println("                      4. 학생 삭제");
            System.out.println("                      5. 학생 · 점수 관리 Menu");
            System.out.println("=============================================================");
            System.out.print("                   번호를 선택하세요 : ");

            try {
                studentNum = sc.nextInt();
                sc.nextLine();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("\n❗ 잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.nextLine();
                continue; // 다시 반복문 처음으로 이동
            }
            System.out.println();
            switch (studentNum) {
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
                            System.out.println("❗ 선택지에 없는 입력입니다. 다시 입력하세요.");
                        }
                    }

                    List<String> subjectList = new ArrayList<>();
                    List<String> mandatorySelections = new ArrayList<>();
                    List<String> choiceSelections = new ArrayList<>();

                    while (true) {
                        System.out.println("🤏🏻 필수 과목 선택 (3개 이상, 공백으로 구분하여 입력)");
                        subjectDataStore.inquiryDataByType(SUBJECT_TYPE_MANDATORY);
                        System.out.println("            --------------------------------");
                        System.out.print("입력 :  ");
                        String mandatoryChoiceStr = sc.nextLine();
                        String[] mandatoryChoicesStr = mandatoryChoiceStr.split(" ");

                        if (mandatoryChoicesStr.length < 3) {
                            System.out.println("❗ 최소 3개의 과목을 선택해야 합니다. 다시 선택하세요.");
                            System.out.println("-------------------------------------------------------------");
                            continue;
                        }

                        if (studentDataStore.validateSelections(mandatoryChoicesStr, mandatoryList, mandatorySelections)) {
                            break;
                        } else {
                            mandatorySelections.clear();
                        }

                    }

                    while (true) {
                        System.out.println("🤏🏻 선택 과목 선택 (2개 이상, 공백으로 구분하여 입력)");
                        subjectDataStore.inquiryDataByType(SUBJECT_TYPE_CHOICE);
                        System.out.println("            --------------------------------");
                        System.out.print("입력 :  ");
                        String choiceChoiceStr = sc.nextLine();
                        String[] choiceChoicesStr = choiceChoiceStr.split(" ");

                        if (choiceChoicesStr.length < 2) {
                            System.out.println("❗ 최소 2개의 과목을 선택해야 합니다. 다시 선택하세요.");
                            System.out.println("-------------------------------------------------------------");

                            continue;
                        }

                        if (studentDataStore.validateSelections(choiceChoicesStr, choiceList, choiceSelections)) {
                            break;
                        } else {
                            choiceSelections.clear();
                        }
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
                    if (studentDataStore.getDataStore().isEmpty()) {
                        System.out.println("❗ 등록된 학생이 없습니다.");
                    }
                    else {
                        while (true) {
                            int studentIdToChange;
                            Student s;
                            System.out.println("===================== 등록된 학생 목록 =========================");
                            for (int i = 0; i < studentDataStore.getDataStore().size(); i++) {
                                s = studentDataStore.getDataStore().get(i);
                                System.out.println("📌 [" + s.getStudentId() + "] " + s.getStudentName());
                            }
                            System.out.println();

                            try {
                                System.out.print("변경할 학생의 고유번호를 입력하세요 (메인 메뉴 - 0 입력): ");
                                studentIdToChange = sc.nextInt();
                                sc.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("\n❗ 잘못된 입력입니다. 숫자를 입력해주세요.");
                                sc.nextLine();
                                continue; // 다시 반복문 처음으로 이동
                            }
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
                            selectedStudent.studentInquiry();

                            System.out.println("\n===================== 변경 사항 선택 =========================");
                            System.out.println("                   1. 학생 이름 변경 ");
                            System.out.println("                   2. 학생 상태 변경  (Green, Red, Yellow) ");
                            System.out.println("                   3. 메인 메뉴 ");
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
                                                System.out.println("❗ 잘못된 입력입니다. 다시 입력하세요.");
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
                                    System.out.println("❗ 선택지에 없는 입력입니다. 다시 입력하세요.");
                            }
                            // 메인 메뉴로 돌아가는 조건
                            if (choice2 == 3) {
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    if (studentDataStore.getDataStore().isEmpty()) {
                        System.out.println("❗ 등록된 학생이 없습니다.");
                    }
                    else {
                        // 학생 삭제
                        int RemoveId;
                        Student s;
                        System.out.println("===================== 등록된 학생 목록 =========================");
                        for (int i = 0; i < studentDataStore.getDataStore().size(); i++) {
                            s = studentDataStore.getDataStore().get(i);
                            System.out.println("📌 [" + s.getStudentId() + "] " + s.getStudentName());
                        }
                        System.out.println();
                        while (true) {
                            try {
                                System.out.print("삭제할 학생의 고유번호를 입력하세요 : ");
                                RemoveId = sc.nextInt();
                                sc.nextLine();
                                boolean validId = false;
                                for (Student student2 : studentDataStore.getDataStore()) {
                                    if (student2.getStudentId() == RemoveId) {
                                        validId = true;
                                        break;
                                    }
                                }
                                if (!validId) {
                                    System.out.println("\n❗ 유효하지 않은 학생 고유번호입니다. 다시 입력해주세요.");
                                    continue; // 다시 반복문 처음으로 이동
                                }
                                break;

                            } catch (InputMismatchException e) {
                                System.out.println("\n❗ 잘못된 입력입니다. 숫자를 입력해주세요.");
                                sc.nextLine();
                                continue; // 다시 반복문 처음으로 이동
                            }
                        }
                        studentDataStore.remove(RemoveId);
                    }
                    break;
                case 5:
                    System.out.println("이전으로 돌아갑니다 ··· ");
                    checkDisplayStudent = false;

                    break;
                default:
                    System.out.println("❗ 선택지에 없는 입력입니다. 다시 입력하세요.");
            }

        }

    }

    private static void displayScore() {

        boolean checkDisplayScore = true;

        check = true;

        while (checkDisplayScore) {

            System.out.println("\n                      1. 점수 등록");
            System.out.println("                      2. 점수 수정");
            System.out.println("                      3. 점수 조회");
            System.out.println("                      4. 평균 점수 조회");
            System.out.println("                      5. 이전으로");
            System.out.println("=============================================================");
            System.out.print("                   번호를 선택하세요 : ");

            int scoreNum = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (scoreNum) {
                case 1:  // 점수 등록
                    Student s1;
                    System.out.println("===================== 등록된 학생 목록 =========================");
                    for (int i = 0; i < studentDataStore.getDataStore().size(); i++) {
                        s1 = studentDataStore.getDataStore().get(i);
                        System.out.println("📌 [" + s1.getStudentId() + "] " + s1.getStudentName());
                    }
                    System.out.println();

                    // 점수 등록할 student ID 입력
                    System.out.println("점수를 등록할 수강생의 고유번호를 입력해주세요.");
                    int addStudentId = sc.nextInt();

                    // 입력된 student ID가 등록된 ID 인지 확인
                    boolean addVerifiationId = false;
                    for (Student student2 : studentDataStore.getDataStore()) {
                        if (student2.getStudentId() == addStudentId) {
                            addVerifiationId = true;
                            break;
                        }
                    }

                    // ID가 유효하지 않을 경우 continue
                    if(!addVerifiationId) {
                        System.out.println("등록되지 않은 ID 입니다. 확인 후 입력해주세요.");
                        break;
                    }

                    // 점수 등록 가능한 과목 안내
                    subjectDataStore.inquiryData();

                    // 점수 등록할 subject ID 입력
                    System.out.println("과목 코드를 입력해주세요.");
                    int addSubjectId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 학생 ID와 과목 ID를 기준으로 student 객체 필드에 입력된 과목 목록에 subject 이름이 있는지 검사
                    boolean isMatched = studentDataStore.getDataStore().stream()
                            .filter(el1 -> el1.getStudentId() == addStudentId)
                            .flatMap(el2 -> el2.getSubjectList().stream())
                            .anyMatch(studentSubject ->
                                    subjectDataStore.getDataStore().stream()
                                            .filter(el3 -> el3.getSubjectId()==addSubjectId)
                                            .anyMatch(dataStoreSubject ->
                                                    studentSubject.equals(dataStoreSubject.getSubjectName())
                                            )
                            );

                    // student 객체의 subjectList 에 등록되지 않은 과목일 경우 continue
                    if (!isMatched) {
                        System.out.println("수강중인 과목이 아닙니다. 확인 후 입력해주세요.");
                        break;
                    }

                    // 입력된 과목코드의 필수과목 여부 판독
                    int subjectType = 0;
                    for (int i = 0; i < subjectDataStore.getDataStore().size(); i++) {
                        Subject subject = subjectDataStore.getDataStore().get(i);
                        if (subject.getSubjectId() == addSubjectId) {
                            subjectType = subject.getSubjectType();
                            break;
                        }
                    }

                    // 정보제공용 학생/과목 이름 변수 저장
                    String addInformStudentName = "";
                    String addInformSubjectName = "";

                    // 학생 이름 저장
                    for(int i=0; i < studentDataStore.getDataStore().size(); i++){
                        Student student1 = studentDataStore.getDataStore().get(i);
                        if (student1.getStudentId() == addStudentId) {
                            addInformStudentName = student1.getStudentName();
                            break;
                        }
                    }

                    // 과목 이름 저장
                    for(int i=0; i < subjectDataStore.getDataStore().size(); i++) {
                        Subject subject = subjectDataStore.getDataStore().get(i);
                        if (subject.getSubjectId() == addSubjectId) {
                            addInformSubjectName = subject.getSubjectName();
                            break;
                        }
                    }

                    // 입력받은 학생 ID, 과목 ID를 통해 기 입력 데이터 존재여부 확인
                    Score tempScore = scoreDataStore.getScoreList(addStudentId, addSubjectId);

                    // 기 입역 데이터 존재여부에 따라 기존 데이터에 추가 저장 또는 새로운 Score 객체 생성 후 저장
                    if (tempScore != null) {    // 기 입력 데이터가 있는 경우
                        System.out.println("========== " + addInformStudentName + " 수강생의 " + addInformSubjectName + " 과목 점수 등록현황 ==========");
                        scoreDataStore.inquiryToScoreList(addStudentId, addSubjectId);

                        System.out.println("등록할 점수의 시험회차를 입력해주세요.");
                        int round = sc.nextInt();

                        System.out.println("점수를 입력해주세요");
                        int scoreValue = sc.nextInt();

                        tempScore.scoreAdd(round, scoreValue);
                    } else {    // 기 입력 데이터가 없는 경우
                        System.out.println(addInformStudentName + " 수강생의 " + addInformSubjectName + " 과목에 등록되어있는 점수가 없습니다. 1회차부터 입력해주세요.");
                        System.out.println("등록할 점수의 시험회차를 입력해주세요.");
                        int round = sc.nextInt();

                        System.out.println("점수를 입력해주세요");
                        int scoreValue = sc.nextInt();

                        Score score = new Score(addStudentId, addSubjectId, subjectType);

                        score.scoreAdd(round, scoreValue);
                        scoreDataStore.addData(score);
                    }
                    break;
                case 2:    // 점수 수정
                    Student s2;
                    System.out.println("===================== 등록된 학생 목록 =========================");
                    for (int i = 0; i < studentDataStore.getDataStore().size(); i++) {
                        s2 = studentDataStore.getDataStore().get(i);
                        System.out.println("📌 [" + s2.getStudentId() + "] " + s2.getStudentName());
                    }
                    System.out.println();

                    System.out.println("점수를 수정할 수강생의 고유번호를 입력해주세요.");
                    int modificationStudentId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 student ID가 등록된 ID 인지 확인
                    boolean modifyVerificationId = false;
                    for (Student student2 : studentDataStore.getDataStore()) {
                        if (student2.getStudentId() == modificationStudentId) {
                            modifyVerificationId = true;
                            break;
                        }
                    }

                    // ID가 유효하지 않을 경우 break
                    if(!modifyVerificationId) {
                        System.out.println("등록되지 않은 ID 입니다. 확인 후 입력해주세요.");
                        break;
                    }

                    // 점수 수정할 과목 안내
                    subjectDataStore.inquiryData();

                    System.out.println("수정할 과목 코드를 입력해주세요.");
                    int modificationSubjectId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 학생 ID와 과목 ID를 기준으로 student 객체 필드에 입력된 과목 목록에 subject 이름이 있는지 검사
                    boolean isMatched2 = studentDataStore.getDataStore().stream()
                            .filter(el1 -> el1.getStudentId() == modificationStudentId)
                            .flatMap(el2 -> el2.getSubjectList().stream())
                            .anyMatch(studentSubject ->
                                    subjectDataStore.getDataStore().stream()
                                            .filter(el3 -> el3.getSubjectId()==modificationSubjectId)
                                            .anyMatch(dataStoreSubject ->
                                                    studentSubject.equals(dataStoreSubject.getSubjectName())
                                            )
                            );

                    // student 객체의 subjectList 에 등록되지 않은 과목일 경우 break
                    if (!isMatched2) {
                        System.out.println("수강중인 과목이 아닙니다. 확인 후 입력해주세요.");
                        break;
                    }

                    // 정보제공용 학생/과목 이름 변수 저장
                    String modifyInformStudentName = "";
                    String modifyInformSubjectName = "";

                    for(int i=0; i < studentDataStore.getDataStore().size(); i++){
                        Student student1 = studentDataStore.getDataStore().get(i);
                        if (student1.getStudentId() == modificationStudentId) {
                            modifyInformStudentName = student1.getStudentName();
                            break;
                        }
                    }

                    for(int i=0; i < subjectDataStore.getDataStore().size(); i++) {
                        Subject subject = subjectDataStore.getDataStore().get(i);
                        if (subject.getSubjectId() == modificationSubjectId) {
                            modifyInformSubjectName = subject.getSubjectName();
                            break;
                        }
                    }

                    // 입력받은 학생 ID, 과목 ID를 통해 기 입력 데이터 존재여부 확인
                    Score tempScore2 = scoreDataStore.getScoreList(modificationStudentId, modificationSubjectId);

                    // 기 입역 데이터 존재여부에 따라 기존 데이터에 추가 저장 또는 새로운 Score 객체 생성 후 저장
                    if (tempScore2 != null) {    // 기 입력 데이터가 있는 경우
                        System.out.println("========== " + modifyInformStudentName + " 수강생의 " + modifyInformSubjectName + " 과목 점수 등록현황 ==========");
                        scoreDataStore.inquiryToScoreList(modificationStudentId,modificationSubjectId);
                        System.out.println("수정할 점수의 시험회차를 입력해주세요.");
                        int round = sc.nextInt();

                        System.out.println("수정하여 입력될 점수를 입력해주세요 (점수범위 : 0 ~ 100)");
                        int scoreValue = sc.nextInt();

                        tempScore2.setScore(modificationStudentId, modificationSubjectId, round, scoreValue);
                    } else {    // 기 입력 데이터가 없는 경우
                        System.out.println(modifyInformStudentName + " 수강생의 " + modifyInformSubjectName + " 과목에 수정할 수 있는 데이터가 없습니다.");
                        break;
                    }
                    break;

                case 3:    // 점수 조회
                    Student s3;
                    System.out.println("===================== 등록된 학생 목록 =========================");
                    for (int i = 0; i < studentDataStore.getDataStore().size(); i++) {
                        s3 = studentDataStore.getDataStore().get(i);
                        System.out.println("📌 [" + s3.getStudentId() + "] " + s3.getStudentName());
                    }
                    System.out.println();

                    // 학생 ID 입력
                    System.out.println("점수를 조회할 수강생의 고유번호를 입력해주세요.");
                    int inquiryStudentId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 student ID가 등록된 ID 인지 boolean 타입 변수에 결과 저장
                    boolean inquiryVerificationId = false;
                    for (Student student2 : studentDataStore.getDataStore()) {
                        if (student2.getStudentId() == inquiryStudentId) {
                            inquiryVerificationId = true;
                            break;
                        }
                    }

                    // ID가 유효하지 않을 경우 break
                    if(!inquiryVerificationId) {
                        System.out.println("등록되지 않은 ID 입니다. 확인 후 입력해주세요.");
                        break;
                    }

                    // 점수 조회할 과목 안내
                    subjectDataStore.inquiryData();

                    // 과목 코드 입력
                    System.out.println("조회할 과목 코드를 입력해주세요.");
                    int inquirySubjectId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 학생 ID와 과목 ID를 기준으로 student 객체 필드에 입력된 과목 목록에 subject 이름이 있는지 검사
                    boolean isMatched3 = studentDataStore.getDataStore().stream()
                            .filter(el1 -> el1.getStudentId() == inquiryStudentId)
                            .flatMap(el2 -> el2.getSubjectList().stream())
                            .anyMatch(studentSubject ->
                                    subjectDataStore.getDataStore().stream()
                                            .filter(el3 -> el3.getSubjectId()==inquirySubjectId)
                                            .anyMatch(dataStoreSubject ->
                                                    studentSubject.equals(dataStoreSubject.getSubjectName())
                                            )
                            );

                    // student 객체의 subjectList 에 등록되지 않은 과목일 경우 break
                    if (!isMatched3) {
                        System.out.println("수강중인 과목이 아닙니다. 확인 후 입력해주세요.");
                        break;
                    }

                    // 정보제공용 학생/과목 이름 변수 저장
                    String inquiryInformStudentName = "";
                    String inquiryInformSubjectName = "";

                    // 학생 이름 저장
                    for(int i=0; i < studentDataStore.getDataStore().size(); i++){
                        Student student1 = studentDataStore.getDataStore().get(i);
                        if (student1.getStudentId() == inquiryStudentId) {
                            inquiryInformStudentName = student1.getStudentName();
                            break;
                        }
                    }

                    // 과목 이름 저장
                    for(int i=0; i < subjectDataStore.getDataStore().size(); i++) {
                        Subject subject = subjectDataStore.getDataStore().get(i);
                        if (subject.getSubjectId() == inquirySubjectId) {
                            inquiryInformSubjectName = subject.getSubjectName();
                            break;
                        }
                    }

                    // 입력된 정보를 바탕으로 scoreList 에서 inquiry 메서드 호출
                    System.out.println("========== " + inquiryInformStudentName + " 수강생의 " + inquiryInformSubjectName + " 과목 점수 조회 결과 ==========" );
                    scoreDataStore.inquiryToScoreList(inquiryStudentId,inquirySubjectId);
                    break;
                case 4:    // 수강생의 수강중인 과목들의 평균 등급 조회
                    Student s4;
                    System.out.println("===================== 등록된 학생 목록 =========================");
                    for (int i = 0; i < studentDataStore.getDataStore().size(); i++) {
                        s4 = studentDataStore.getDataStore().get(i);
                        System.out.println("📌 [" + s4.getStudentId() + "] " + s4.getStudentName());
                    }
                    System.out.println();

                    // 학생 ID 입력
                    System.out.println("점수를 조회할 수강생의 고유번호를 입력해주세요.");
                    int avgInquiryStudentId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 student ID의 studentList 등록 여부를 boolean 타입 변수에 결과 저장
                    boolean avgInquiryVerificationId = false;
                    for (Student tempStudent : studentDataStore.getDataStore()) {
                        if (tempStudent.getStudentId() == avgInquiryStudentId) {
                            avgInquiryVerificationId = true;
                            break;
                        }
                    }

                    // ID가 유효하지 않을 경우 break
                    if(!avgInquiryVerificationId) {
                        System.out.println("등록되지 않은 ID 입니다. 확인 후 입력해주세요.");
                        break;
                    }

                    // 정보제공용 학생/과목 이름 변수 저장
                    String avgInquiryInformStudentName = "";

                    // 학생 이름 저장
                    for(int i=0; i < studentDataStore.getDataStore().size(); i++){
                        Student student1 = studentDataStore.getDataStore().get(i);
                        if (student1.getStudentId() == avgInquiryStudentId) {
                            avgInquiryInformStudentName = student1.getStudentName();
                            break;
                        }
                    }

                    System.out.println("========== " + avgInquiryInformStudentName + " 수강생의 수강중인 과목 평균 등급" + " ==========");
                    for(int i=0; i < scoreDataStore.getDataStore().size(); i++) {
                        Score score = scoreDataStore.getDataStore().get(i);
                        if (score.getStudentId() == avgInquiryStudentId) {
                            for (int j=0; j < subjectDataStore.getDataStore().size(); j++) {
                                Subject subject = subjectDataStore.getDataStore().get(j);
                                if (score.getSubjectid() == subject.getSubjectId()) {
                                    System.out.print(subject.getSubjectName() + " : ");
                                    score.getAvgScore();
                                }
                            }
                        }
                    }

                    break;
                case 5:
                    System.out.println("이전으로 돌아갑니다.");
                    checkDisplayScore = false;

                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }

        }

    }

}
