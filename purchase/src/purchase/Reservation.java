package purchase;

public class Reservation {
	private int num;
	private String customer_id;
	private String customer_pwd;
	private String product_number;
	private int ticket_count;
	private int passport_id;
	private boolean isPay;
	
	
	public Reservation(int num, String customer_id, String customer_pwd, String product_number, int ticket_count,
			int passport_id, boolean isPay) {
		this.num = num;
		this.customer_id = customer_id;
		this.customer_pwd = customer_pwd;
		this.product_number = product_number;
		this.ticket_count = ticket_count;
		this.passport_id = passport_id;
		this.isPay = isPay;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	public String getCustomer_pwd() {
		return customer_pwd;
	}


	public void setCustomer_pwd(String customer_pwd) {
		this.customer_pwd = customer_pwd;
	}


	public String getProduct_number() {
		return product_number;
	}


	public void setProduct_number(String product_number) {
		this.product_number = product_number;
	}


	public int getTicket_count() {
		return ticket_count;
	}


	public void setTicket_count(int ticket_count) {
		this.ticket_count = ticket_count;
	}


	public int getPassport_id() {
		return passport_id;
	}


	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}


	public boolean isPay() {
		return isPay;
	}


	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}


	@Override
	public String toString() {
		return "Reservation [num=" + num + ", customer_id=" + customer_id + ", customer_pwd=" + customer_pwd
				+ ", product_number=" + product_number + ", ticket_count=" + ticket_count + ", passport_id="
				+ passport_id + ", isPay=" + isPay + "]";
	}
	
	
	

}
