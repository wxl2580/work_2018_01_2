package User;

public class Admin {
	private String name;
	private String id;
	private String sex;
	
	public Admin() {
	
	}

	public Admin(String name, String id, String sex) {
		super();
		this.name = name;
		this.id = id;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", id=" + id + ", sex=" + sex + "]";
	}
	
	
}
