package student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String studentName;
    private List<String> subjectName;
    private String status;

    /*생성자*/
    public Student(String studentName, String status) {
        this.studentName = studentName;
        this.status = status;
        this.subjectName = new ArrayList<>(); //과목 초기화
    }
    /*수강생 등록정보 조회*/
    public void studentInquiry() {
        System.out.println("학생 이름 : " + studentName);
        System.out.println("수강 과목 목록 :");
        for (String subject : subjectName) {
            System.out.println(subject);
        }
        System.out.println("학생 상태 : " + status);
    }
    //Getter 객체 고유번호 반환
    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    //Setter 사용하여 status 값 수정
    public void setStatus(String status) {
        this.status = status;
    }
    //Setter 사용하여 name 값 수정
    public void setName(String studentName) {
        this.studentName = studentName;
    }
    //Getter 객체 이름 반환
    public String getStudentName() {
        return studentName;
    }
    public String getStatus() {
        return status;
    }

    public List<String> getSubjectList() { // List<String> 반환
        return subjectName;
    }
    public void addSubject(String subject) { // 과목 추가 메서드
        subjectName.add(subject);
    }

}