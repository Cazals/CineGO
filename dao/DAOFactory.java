/**
 * 
 */
package dao;

import classes.Address;
import classes.Classe;
import classes.Ecole;
import classes.PositionCase;
import classes.Student;
import classes.Teacher;
import dao.bddsql.ClasseDAO;
import dao.bddsql.EcoleDAO;
import dao.bddsql.StudentDAO;
import dao.bddsql.TeacherDAO;
import dao.bddsql.PositionCaseDAO;

/**
 * @author thomas
 *
 */
public class DAOFactory {
	
	public static DAO<PositionCase> getPositionCaseDAO(){
		return new PositionCaseDAO();
	}
	
	public static DAO<Classe> getClasseDAO(){
		return new ClasseDAO();
	}

	public static DAO<Ecole> getEcoleDAO(){
		return new EcoleDAO();
	}

	public static DAO<Student> getStudentDAO(){
		return new StudentDAO();
	}

	public static DAO<Teacher> getTeacherDAO(){
		return new TeacherDAO();
	}

}
