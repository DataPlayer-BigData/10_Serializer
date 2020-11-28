package tu.cit.example.JsonSerializer;

public class StudentModel {
    private int studentid;
    private String studentname;
    private String dept;
    private String coursename;
    private Double marks;

    StudentModel(){}
    StudentModel(int studentid, String studentname, String dept, String coursename, Double marks){
        this.studentid=studentid;
        this.studentname=studentname;
        this.dept = dept;
        this.coursename=coursename;
        this.marks=marks;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    //If we don't override, then on command prompt using console-consumer, it will not print value of Object. It will print object only.
    @Override
    public String toString(){
        String msg = studentid + " , "+studentname + " , "+ dept + " , " + coursename + " , " + marks;
        return msg;
    }
}
