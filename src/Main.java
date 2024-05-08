import score.Score;
import store.ScoreStore;
import store.StudentStore;
import store.SubjectStore;
import subject.Subject;
import student.Intro;
import student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 과목 타입 정의
    private static final int SUBJECT_TYPE_MANDATORY = 1;
    private static final int SUBJECT_TYPE_CHOICE = 2;

    public static void main(String[] args) {

        StudentStore<Student> studentDataStore = new StudentStore<>();
        SubjectStore<Subject> subjectDataStore = new SubjectStore<>();
        ScoreStore<Score> scoreDataStore = new ScoreStore<>();

        String[] mandatoryList = { "Java", "객체지향", "Spring", "JPA", "MySQL" };
        String[] choiceList = { "디자인 패턴", "Spring Security", "Redis", "MongoDB" };

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
            System.out.println("                      5. 점수 등록");
            System.out.println("                      6. 점수 수정");
            System.out.println("                      7. 점수 조회");
            System.out.println("                      8. 종료 ");

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

                    //과목 목록 입력 받음
                    System.out.println("🧾 과목 목록 (종료하려면 'exit' 입력) : ");
                    List<String> subjectList = new ArrayList<>();
                    while (true) {
                        String subject = sc.nextLine();
                        if (subject.equalsIgnoreCase("exit")) {
                            break;
                        }
                        subjectList.add(subject);
                    }

                    // 학생 객체 생성
                    Student student = new Student(studentName, status);
                    // 과목 추가
                    for (String subject : subjectList) {
                        student.addSubject(subject);
                    }
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
                case 5:  // 점수 등록
                    // 점수 등록할 student ID 입력
                    System.out.println("점수를 등록할 수강생의 고유번호를 입력해주세요.");
                    int addStudentId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 student ID가 등록된 ID 인지 확인
                    boolean addverifiationId = false;
                    for (Student student2 : studentDataStore.getDataStore()) {
                        if (student2.getStudentId() == addStudentId) {
                            addverifiationId = true;
                        } else {
                            addverifiationId = false;
                            System.out.println("등록되지 않은 ID 입니다. 확인 후 입력해주세요.");
                        }
                    }

                    // ID가 유효하지 않을 경우 continue
                    if(addverifiationId == false) {
                        continue;
                    }

                    // 점수 등록 가능한 과목 안내
                    subjectDataStore.inquiryData();

                    // 점수 등록할 subject ID 입력
                    System.out.println("과목 코드를 입력해주세요.");
                    int addSubjectId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 학생 ID와 과목 ID를 기준으로 student 객체 필드에 입력된 과목 목록에 subject 이름이 있는지 검사
                    boolean isMatched = false;
                            isMatched= studentDataStore.getDataStore().stream()
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
                    if (isMatched == false) {
                        System.out.println("수강중인 과목이 아닙니다. 확인 후 입력해주세요.");
                        continue;
                    }

                    // 입력된 과목코드의 필수과목 여부 판독
                    int subjectType = 0;
                    for (int i = 0; i < subjectDataStore.getDataStore().size(); i++) {
                        Subject subject = subjectDataStore.getDataStore().get(i);
                        if (subject.getSubjectId() == addSubjectId) {
                            subjectType = subject.getSubjectType();
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
                        }
                    }

                    // 과목 이름 저장
                    for(int i=0; i < subjectDataStore.getDataStore().size(); i++) {
                        Subject subject = subjectDataStore.getDataStore().get(i);
                        if (subject.getSubjectId() == addSubjectId) {
                            addInformSubjectName = subject.getSubjectName();
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
                case 6:    // 점수 수정
                    System.out.println("점수를 수정할 수강생의 고유번호를 입력해주세요.");
                    int modificationStudentId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 student ID가 등록된 ID 인지 확인
                    boolean modifyVerificationId = false;
                    for (Student student2 : studentDataStore.getDataStore()) {
                        if (student2.getStudentId() == modificationStudentId) {
                            modifyVerificationId = true;
                        } else {
                            modifyVerificationId = false;
                            System.out.println("등록되지 않은 ID 입니다. 확인 후 입력해주세요.");
                        }
                    }

                    // ID가 유효하지 않을 경우 continue
                    if(modifyVerificationId == false) {
                        continue;
                    }

                    // 점수 수정할 과목 안내
                    subjectDataStore.inquiryData();

                    System.out.println("수정할 과목 코드를 입력해주세요.");
                    int modificationSubjectId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 학생 ID와 과목 ID를 기준으로 student 객체 필드에 입력된 과목 목록에 subject 이름이 있는지 검사
                    boolean isMatched2 = false;
                    isMatched2= studentDataStore.getDataStore().stream()
                            .filter(el1 -> el1.getStudentId() == modificationStudentId)
                            .flatMap(el2 -> el2.getSubjectList().stream())
                            .anyMatch(studentSubject ->
                                    subjectDataStore.getDataStore().stream()
                                            .filter(el3 -> el3.getSubjectId()==modificationSubjectId)
                                            .anyMatch(dataStoreSubject ->
                                                    studentSubject.equals(dataStoreSubject.getSubjectName())
                                            )
                            );

                    // student 객체의 subjectList 에 등록되지 않은 과목일 경우 continue
                    if (isMatched2 == false) {
                        System.out.println("수강중인 과목이 아닙니다. 확인 후 입력해주세요.");
                        continue;
                    }

                    // 정보제공용 학생/과목 이름 변수 저장
                    String modifyInformStudentName = "";
                    String modifyInformSubjectName = "";

                    for(int i=0; i < studentDataStore.getDataStore().size(); i++){
                        Student student1 = studentDataStore.getDataStore().get(i);
                        if (student1.getStudentId() == modificationStudentId) {
                            modifyInformStudentName = student1.getStudentName();
                        }
                    }

                    for(int i=0; i < subjectDataStore.getDataStore().size(); i++) {
                        Subject subject = subjectDataStore.getDataStore().get(i);
                        if (subject.getSubjectId() == modificationSubjectId) {
                            modifyInformSubjectName = subject.getSubjectName();
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

                case 7:    // 점수 조회
                    // 학생 ID 입력
                    System.out.println("점수를 조회할 수강생의 고유번호를 입력해주세요.");
                    int inquiryStudentId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 student ID가 등록된 ID 인지 boolean 타입 변수에 결과 저장
                    boolean inquiryVerificationId = false;
                    for (Student student2 : studentDataStore.getDataStore()) {
                        if (student2.getStudentId() == inquiryStudentId) {
                            inquiryVerificationId = true;
                        } else {
                            inquiryVerificationId = false;
                            System.out.println("등록되지 않은 ID 입니다. 확인 후 입력해주세요.");
                        }
                    }

                    // ID가 유효하지 않을 경우 continue
                    if(inquiryVerificationId == false) {
                        continue;
                    }

                    // 점수 조회할 과목 안내
                    subjectDataStore.inquiryData();

                    // 과목 코드 입력
                    System.out.println("조회할 과목 코드를 입력해주세요.");
                    int inquirySubjectId = sc.nextInt();
                    sc.nextLine();

                    // 입력된 학생 ID와 과목 ID를 기준으로 student 객체 필드에 입력된 과목 목록에 subject 이름이 있는지 검사
                    boolean isMatched3 = false;
                    isMatched3= studentDataStore.getDataStore().stream()
                            .filter(el1 -> el1.getStudentId() == inquiryStudentId)
                            .flatMap(el2 -> el2.getSubjectList().stream())
                            .anyMatch(studentSubject ->
                                    subjectDataStore.getDataStore().stream()
                                            .filter(el3 -> el3.getSubjectId()==inquirySubjectId)
                                            .anyMatch(dataStoreSubject ->
                                                    studentSubject.equals(dataStoreSubject.getSubjectName())
                                            )
                            );

                    // student 객체의 subjectList 에 등록되지 않은 과목일 경우 continue
                    if (isMatched3 == false) {
                        System.out.println("수강중인 과목이 아닙니다. 확인 후 입력해주세요.");
                        continue;
                    }

                    // 정보제공용 학생/과목 이름 변수 저장
                    String inquiryInformStudentName = "";
                    String inquiryInformSubjectName = "";

                    // 학생 이름 저장
                    for(int i=0; i < studentDataStore.getDataStore().size(); i++){
                        Student student1 = studentDataStore.getDataStore().get(i);
                        if (student1.getStudentId() == inquiryStudentId) {
                            inquiryInformStudentName = student1.getStudentName();
                        }
                    }

                    // 과목 이름 저장
                    for(int i=0; i < subjectDataStore.getDataStore().size(); i++) {
                        Subject subject = subjectDataStore.getDataStore().get(i);
                        if (subject.getSubjectId() == inquirySubjectId) {
                            inquiryInformSubjectName = subject.getSubjectName();
                        }
                    }

                    // 입력된 정보를 바탕으로 scoreList 에서 inquiry 메서드 호출
                    System.out.println("========== " + inquiryInformStudentName + " 수강생의 " + inquiryInformSubjectName + " 과목 점수 조회 결과 ==========" );
                    scoreDataStore.inquiryToScoreList(inquiryStudentId,inquirySubjectId);
                    break;
                case 8:
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
//                    subjectDataStore.inquiryData();
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
