package com.example.importexcel;

import com.example.importexcel.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ImportExcelApplication implements CommandLineRunner{

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ImportExcelApplication.class, args);



    }
    public void importExcel(){
        System.out.println("Import information student from excel");
        Excel excel = new Excel();
        List<Student> list = excel.readFile();
        for(Student student : list){
            studentRepository.save(student);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        Excel excel = new Excel();

        importExcel();
        System.out.println("Import done!");
        List<Student> studentList=  studentRepository.findAll();
        excel.exportFile(studentList);
        System.out.println("Export Done!");
    }

    public void allStudent(){
        System.out.println("All student in database");
        List<Student> list = studentRepository.findAll();
        for (Student student : list){
            System.out.println(student);
        }
    }

}
