package student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String studentName;
    private List<String> subjectName;
    private String status;

    /*생성자*/
    public Student(int studentId, String studentName, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.status = status;
        this.subjectName = new ArrayList<String>(); //과목 초기화
    }
    /*수강생 등록 메서드*/
    public void studentAdd(int studentId, String studentName, List<String> subjectName) {
        if(this.studentId != studentId) {
            this.studentId = studentId; //새로운 학생의 고유번호
        }
        this.studentName = studentName; //학생 이름 설정
        this.subjectName = subjectName; //과목 목록 추가
    }
    /*수강생 등록정보 조회*/
    public void studentInquiry() {
        System.out.println("학생 아이디: " + studentId);
        System.out.println("학생 이름: " + studentName);

        System.out.println("수강 과목 목록:");
        for (String subject : subjectName) {
            System.out.println(subject);
        }

        System.out.println("학생 상태: " + status);
    }
    //Setter 사용하여 status 값 수정
    public void setStatus(String status) {
        this.status = status;
    }

}
