package com.jsp.schoolmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.schoolmanagement.dto.Students;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Students createStudent(Students student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

		return student;
	}

	public Students getStudentById(int id) {
		return entityManager.find(Students.class, 1);

	}

	public void updateStudent(int id, Students s) {
		Students s1 = entityManager.find(Students.class, id);
		if (s1 != null) {
			s1.setName(s.getName());
			s1.setEmail(s.getEmail());
			s1.setPhone_num(s.getPhone_num());
			entityTransaction.begin();
			entityManager.merge(s1);
			entityTransaction.commit();
		} else {
			System.out.println("entity not found for thee given id");
		}
	}

	public void deleteStudent(int id) {

		Students s1 = entityManager.find(Students.class, id);

		entityTransaction.begin();
		entityManager.remove(s1);
		entityTransaction.commit();
	}
}
