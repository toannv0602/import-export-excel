package com.example.importexcel.entity;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



@Entity
@Table(name="student", schema = "public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_code", unique = true, nullable = false)
    Long studentCode;
    @Column(name = "full_name")
    String fullName;
    @Column(name = "class_name")
    String className;
    @Column(name = "dob")
    Date dOB;
    @Column(name = "sdt")
    Integer sDT;
    @Column(name="email")
    String email;
    @Column(name = "address")
    String address;
    @Column(name = "pob")
    String pOB;
    @Column(name = "create_date")
    Date createDate;

    public Long getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Long studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public Integer getsDT() {
        return sDT;
    }

    public void setsDT(Integer sDT) {
        this.sDT = sDT;
    }

    public Student(Long studentCode, String fullName, String className, Date dOB, Integer sDT, String email, String address, String pOB, Date createDate) {
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.className = className;
        this.dOB = dOB;
        this.sDT = sDT;
        this.email = email;
        this.address = address;
        this.pOB = pOB;
        this.createDate = createDate;
    }

    public Student(String fullName, String className, Date dOB, Integer sDT, String email, String address, String pOB, Date createDate) {
        this.fullName = fullName;
        this.className = className;
        this.dOB = dOB;
        this.sDT = sDT;
        this.email = email;
        this.address = address;
        this.pOB = pOB;
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getpOB() {
        return pOB;
    }

    public void setpOB(String pOB) {
        this.pOB = pOB;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Student() {
    }



    @Override
    public String toString() {
        return "student: "+studentCode+" - "+fullName+ " - "+className+" - "+dOB+" - "+sDT+" - "+email+" - "+address
                +" - "+pOB+" - "+createDate;
    }

    public String[] propertites(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return new String[]{String.valueOf(studentCode), fullName, className, dateFormat.format(dOB),
            String.valueOf(sDT),email,address,pOB,dateFormat.format(createDate)};
    }
}
