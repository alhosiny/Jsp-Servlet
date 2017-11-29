package com.Students;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentInfo {
	private int id;
	private String fullName, department, hobbies, grade;
	private static DataBaseWork db;
	public StudentInfo() throws InstantiationException, IllegalAccessException, SQLException {
		db = new DataBaseWork();
	}
	public StudentInfo(int id,  String fullName, String department, String grade, String hobbies) throws InstantiationException, IllegalAccessException, SQLException {
		this.id = id;
		this.grade = grade;
		this.fullName = fullName;
		this.department = department;
		this.hobbies = hobbies;
		db = new DataBaseWork();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	private static boolean isEmpty(String m) {
		if(m == null) return true;
		return (m.length() == 0);
	}
	private static boolean isInt(String d) {
		String pattern = "\\d+";
		Pattern r = Pattern.compile(pattern);
		return d.matches(pattern);
	}
	private static boolean idIsUsed(String id) throws SQLException, InstantiationException, IllegalAccessException {
		db = new DataBaseWork();
		ResultSet rs = db.select("SELECT * FROM students where id=" + id);
		return rs.last();
	}
	public static ArrayList isValid(String id, String name, String department) throws InstantiationException, IllegalAccessException, SQLException {
		ArrayList<String> allvalid = new ArrayList<String>();
		if(isEmpty(id)) {
			allvalid.add("Please enter you id");
		}
		else if(!isInt(id)) {
			allvalid.add("Please make sure your id is a number");
		}
		else if(idIsUsed(id)) {
			allvalid.add("this id is used");
		}
		
		if(isEmpty(name)) {
			allvalid.add("Please enter you full name");
		}
		
		if(department.equals("ch")) {
			allvalid.add("Please enter you department");
		}
		return allvalid;
	}
	
	public static ArrayList isValidForUbdate(String name, String department){
		ArrayList<String> allvalid = new ArrayList<String>();
		if(isEmpty(name)) {
			allvalid.add("Please enter you full name");
		}
		
		if(department.equals("ch")) {
			allvalid.add("Please enter you department");
		}
		return allvalid;
	}
	public void addStudent() throws SQLException {
		db.excuteDml("insert into `students` VALUES ('"+ this.id+"', '" + this.fullName+"', '"+this.department+"', '"+this.grade+"', '"+this.hobbies+"');");
	}
	
	public void updateStudent() throws SQLException {
		db.excuteDml("update students set fullName= '" + this.fullName + "',department= '" +this.department +"',grade= '" + this.grade + "', hobbies= '" + this.hobbies + "'where id=" + this.id);
	}
	public void deleteStudent() throws SQLException {
		db.excuteDml("delete from students where id=" + this.id);
	}
	
	public void fillStudent() throws SQLException {
		ResultSet stud = db.select("select * from students where id=" + this.id);
		stud.next();
		this.fullName = stud.getString("fullName");
		this.department = stud.getString("department");
		this.grade = stud.getString("grade");
		this.hobbies = stud.getString("hobbies");
	}
	public static ArrayList getAll() throws SQLException, InstantiationException, IllegalAccessException {
		db = new DataBaseWork();
		ArrayList<StudentInfo> all = new ArrayList<StudentInfo>();
		ResultSet resAll = db.select("select * from students");
		while(resAll.next()) {
			StudentInfo st = new StudentInfo();
			st.id = Integer.parseInt(resAll.getString("id"));
			st.fullName = resAll.getString("fullName");
			st.department = resAll.getString("department");
			st.grade = resAll.getString("grade");
			st.hobbies = resAll.getString("hobbies");
			all.add(st);
		}
		return all;
	}
	public static ArrayList searchStudent(String s) throws SQLException, InstantiationException, IllegalAccessException{
		db = new DataBaseWork();
		ArrayList<StudentInfo> match = new ArrayList<StudentInfo>();
		String query = "select * from students where fullName like '%" + s + "%'"
				        +"or department like '%" + s + "%'"
				        +"or grade like '%" + s + "%'"
				        + "or hobbies like '%" + s + "%'";
		ResultSet setMatch = db.select(query);
		while(setMatch.next()) {
			StudentInfo st  = new StudentInfo();
			st.id = Integer.parseInt(setMatch.getString("id"));
			st.fullName = setMatch.getString("fullName");
			st.department = setMatch.getString("department");
			st.grade = setMatch.getString("grade");
			st.hobbies = setMatch.getString("hobbies");
			match.add(st);
		}
		return match;
	}
	public static void main(String [] args) throws SQLException, InstantiationException, IllegalAccessException {
		/*StudentInfo ii = new StudentInfo(1, "hos","de", 4 , "hob");
		ii.addStudent();
		StudentInfo i1 = new StudentInfo(2, "hos","de", 3 , "hob");
		i1.addStudent();
		
		//ii.deleteStudent();
		ArrayList<StudentInfo> a = StudentInfo.searchStudent("3");
		System.out.println(a.size());
		System.out.println(a.get(0).fullName + "   " + a.get(0).department + "  " + a.get(0).grade + "  "+ a.get(0).hobbies);
		
		ArrayList<StudentInfo> a1 = StudentInfo.searchStudent("hos");
		System.out.println(a1.size());
		int i = 0;
		while(i < a1.size()) {
		  System.out.println(a1.get(i).fullName + "   " + a1.get(i).department + "  " + a1.get(i).grade + "  "+ a1.get(i).hobbies);
		  i++;
		}
		ii.deleteStudent();
		i1.deleteStudent();*/
	}
	
}
