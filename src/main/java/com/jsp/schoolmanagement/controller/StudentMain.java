package com.jsp.schoolmanagement.controller;

import com.jsp.schoolmanagement.dao.StudentDao;
import com.jsp.schoolmanagement.dto.Students;

public class StudentMain {
	public static void main(String[] args) {
		Students student = new Students();

		student.setName("naushad");
		student.setEmail("naushad@gmail.com");
		student.setPhone_num("458596475");
		StudentDao studentDao = new StudentDao();

//		TO INSERT A VALUE INTO TABLE
		studentDao.createStudent(student);

//		TO UPDATE AN EXISTING VALUE
		studentDao.updateStudent(2, student);

//		TO DELETE A RECORD FROM TABLE
		studentDao.deleteStudent(3);

//		TO READ A RECORD FROM THE TABLE BY ID
		Students s = studentDao.getStudentById(1);
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getEmail());
		System.out.println(s.getPhone_num());

		System.out.println("All Good");
	}
}
