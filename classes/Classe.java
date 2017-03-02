package classes;

import java.util.ArrayList;

public class Classe {
	
	private int id;
	private String niveau;
	private Teacher classTeacher;
	private ArrayList<Student> listStudent = new ArrayList<Student>();
	
	public Classe()	{}
	
	public Classe(int id, String niveau,Teacher classTeacher,ArrayList<Student> listStudent)
	{
		super();
		this.id = id;
		this.niveau = niveau;
		this.setClassTeacher(classTeacher);
		this.setListStudent(listStudent);
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the niveau
	 */
	public String getNiveau()
	{
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(String niveau)
	{
		this.niveau = niveau;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Classe [id=" + id + ", niveau=" + niveau + "]";
	}

	
	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
	public void addStudent(Student stu){
		this.listStudent.add(stu);
	}
	
	public Student getStudent(int indice){
		return this.listStudent.get(indice);
	}

	public Teacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}
	
	
}
