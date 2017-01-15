package bookingSystem;

public class Customer {
	private String name;
	private String tel;
	private double money;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money -= money;
	}

	public Customer(String name, String tel, double money) {
		this.name = name;
		this.tel = tel;
		this.money = money;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
