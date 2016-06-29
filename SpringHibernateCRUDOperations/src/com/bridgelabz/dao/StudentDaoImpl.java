package com.bridgelabz.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.model.Student;
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	//creating seession factory object  
	private SessionFactory sessionFactory;
	//method to save student
	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}
	//method to return all students
	@SuppressWarnings("unchecked")
	public List<Student> listStudents() {
		return (List<Student>) sessionFactory.getCurrentSession().createCriteria(Student.class).list();
	}
	//method to return one student of given id  
	public Student getStudent(int stuid) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, stuid);
	}
	//method to delete student
	public void deleteStudent(Student student )
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Student WHERE stuid = "+student.getStuId()).executeUpdate();
	}
}