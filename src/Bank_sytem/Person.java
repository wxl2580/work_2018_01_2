package Bank_sytem;

public class Person {
	private String id ;
	private String name;
	private Long money;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", money=" + money + "]";
	}

	public Person() {	
	}

	public Person(String id, String name, Long money) {
		this.id= id;
		this.name = name;
		this.money = money;
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

	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
}
