package com.bridgelabz.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bridgelabz.bean.StudentBean;
import com.bridgelabz.model.Student;
import com.bridgelabz.service.StudentService;
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	/* here matching with respective url pattern and open their respective view pages*/ 
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("command")StudentBean studentBean, 
			BindingResult result) {
		Student student = prepareModel(studentBean);
		studentService.addStudent(student);
		return new ModelAndView("addSuccess");
	}
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public ModelAndView listStudents() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students",prepareListofBean(studentService.listStudents()));
		return new ModelAndView("studentsList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudent(@ModelAttribute("command")  StudentBean studentBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("addStudent", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@ModelAttribute("command")  StudentBean studentBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", 	prepareStudentBean(studentService.getStudent(studentBean.getId())));
		model.put("students",  prepareListofBean(studentService.listStudents()));
		return new ModelAndView("update", model);
	}
		@RequestMapping(value = "/editOP", method = RequestMethod.GET)
		public ModelAndView editStudentData(@ModelAttribute("command") StudentBean studentBean,
				BindingResult result) {
			studentService.deleteStudent(prepareModel(studentBean));
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("student", null);
			model.put("students",  prepareListofBean(studentService.listStudents()));
			return new ModelAndView("updateStudent", model);
	}
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public ModelAndView StudentDataUpdate(@ModelAttribute("command")StudentBean studentBean, 
				BindingResult result) {
			Student student = prepareModel(studentBean);
			studentService.addStudent(student);
			return new ModelAndView("updateSuccess");
		}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editStudent(@ModelAttribute("command")  StudentBean studentBean,
			BindingResult result) {
		System.out.println("20");
		studentService.deleteStudent(prepareModel(studentBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", null);
		model.put("students",  prepareListofBean(studentService.listStudents()));
		return new ModelAndView("deleteSuccess", model);
	}
	@RequestMapping(value = "/deleteOP", method = RequestMethod.GET)
	public ModelAndView deleteStudentData(@ModelAttribute("command") StudentBean studentBean,
			BindingResult result) {
		studentService.deleteStudent(prepareModel(studentBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", null);
		model.put("students",  prepareListofBean(studentService.listStudents()));
		return new ModelAndView("deletStudent", model);
	}
	//here student class fields match with student fields of studentBean 
	private Student prepareModel(StudentBean studentBean){
		Student student = new Student();
		student.setStuAddress(studentBean.getAddress());
		student.setStuMarks(studentBean.getMarks());
		student.setStuName(studentBean.getName());
		student.setStuEmail(studentBean.getEmail());
		student.setStuId(studentBean.getId());
		studentBean.setId(null);
		return student;
	}
	//here we are getting students data
	private List<StudentBean> prepareListofBean(List<Student> students){
		List<StudentBean> beans = null;
		if(students != null && !students.isEmpty()){
			beans = new ArrayList<StudentBean>();
			StudentBean bean = null;
			for(Student student : students){
				bean = new StudentBean();
				bean.setName(student.getStuName());
				bean.setId(student.getStuId());
				bean.setAddress(student.getStuAddress());
				bean.setMarks(student.getStuMarks());
				bean.setEmail(student.getStuEmail());
				beans.add(bean);
			}
		}
		return beans;
	}
	//here studentBean class fields match with student fields of student
	private StudentBean prepareStudentBean(Student student){
		StudentBean bean = new StudentBean();
		bean.setAddress(student.getStuAddress());
		bean.setMarks(student.getStuMarks());
		bean.setName(student.getStuName());
		bean.setEmail(student.getStuEmail());
		bean.setId(student.getStuId());
		return bean;
	}
}