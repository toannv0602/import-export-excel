package com.example.importexcel;

import com.example.importexcel.entity.Student;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Excel {

    public List<Student> readFile(){
        try {
            FileInputStream excelFile = new FileInputStream(new File("test-import-student.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();
            Iterator<Row> iterator = datatypeSheet.iterator();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Row firstRow = iterator.next();

            List<Student> listStudent = new ArrayList<Student>();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Student student = new Student();
                student.setFullName(currentRow.getCell(0).getStringCellValue());
                student.setClassName(currentRow.getCell(1).getStringCellValue());
                student.setdOB(dateFormat.parse(currentRow.getCell(2).getStringCellValue()));
                student.setsDT(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(3))));
                student.setEmail(currentRow.getCell(4).getStringCellValue());
                student.setAddress(currentRow.getCell(5).getStringCellValue());
                student.setpOB(currentRow.getCell(6).getStringCellValue());
                student.setCreateDate(dateFormat.parse(currentRow.getCell(7).getStringCellValue()));
                listStudent.add(student);
            }
            for (Student student: listStudent){
                System.out.println(student);
            }
            return listStudent;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void exportFile(List<Student> listStudent) throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student_Infor");

        Column[] columns = Column.values();

        int rowNum = 0;

        Cell cell;
        Row row = sheet.createRow(rowNum);

        for (int i=0; i< columns.length; ++i){
            cell= row.createCell(i);
            cell.setCellValue(columns[i].toString());
        }

        for(Student student: listStudent){
            rowNum++;
            row = sheet.createRow(rowNum);
            String arr[]= student.propertites();
            for (int i=0; i< arr.length; ++i){
                cell = row.createCell(i);
                cell.setCellValue(arr[i]);
            }
        }
        FileOutputStream file = new FileOutputStream("Student_Information.xlsx");
        workbook.write(file);
    }

}
