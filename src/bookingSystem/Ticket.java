package bookingSystem;

public class Ticket {
	private String customerName;
	private String customerTel;
	private String showName;
	private String time;
	private int[] reserve;


//	public String getReserve() {
//		return reserve;
//	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerTel() {
		return customerTel;
	}


	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}


	public String getShowName() {
		return showName;
	}


	public void setShowName(String showName) {
		this.showName = showName;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int[] getReserve() {
		return reserve;
	}


	public void setReserve(int[] reserve) {
		this.reserve = reserve;
	}


	public Ticket(String customerName, String customerTel, String showName, String time, int[] reserve) {

		this.customerName = customerName;
		this.customerTel = customerTel;
		this.showName = showName;
		this.time = time;
		this.reserve = reserve;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
