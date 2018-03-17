import java.io.Serializable;


public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6129984888916477463L;
	private int id;
	private String Name;
	private int grade;
	protected String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void upgrade(){
		grade++;
		
	}
	public String getType(){
		return this.type;
	}

}
