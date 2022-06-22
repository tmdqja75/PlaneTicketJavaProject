package purchase;

public class Product {
	private String product_number;
	private String flight_id;
	private String agency;
	private String destination;
	private String period;
	private String manual;
	private boolean isHotel;
	private boolean flight_type;
	private int product_price;
	
	
	public Product(String product_number, String flight_id, String agency, String destination, String period,
			String manual, boolean isHotel, boolean flight_type, int product_price) {
		this.product_number = product_number;
		this.flight_id = flight_id;
		this.agency = agency;
		this.destination = destination;
		this.period = period;
		this.manual = manual;
		this.isHotel = isHotel;
		this.flight_type = flight_type;
		this.product_price = product_price;
	}


	public String getProduct_number() {
		return product_number;
	}


	public void setProduct_number(String product_number) {
		this.product_number = product_number;
	}


	public String getFlight_id() {
		return flight_id;
	}


	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}


	public String getAgency() {
		return agency;
	}


	public void setAgency(String agency) {
		this.agency = agency;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getPeriod() {
		return period;
	}


	public void setPeriod(String period) {
		this.period = period;
	}


	public String getManual() {
		return manual;
	}


	public void setManual(String manual) {
		this.manual = manual;
	}


	public boolean isHotel() {
		return isHotel;
	}


	public void setHotel(boolean isHotel) {
		this.isHotel = isHotel;
	}


	public boolean isFlight_type() {
		return flight_type;
	}


	public void setFlight_type(boolean flight_type) {
		this.flight_type = flight_type;
	}


	public int getProduct_price() {
		return product_price;
	}


	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}


	@Override
	public String toString() {
		return "Product [product_number=" + product_number + ", flight_id=" + flight_id + ", agency=" + agency
				+ ", destination=" + destination + ", period=" + period + ", manual=" + manual + ", isHotel=" + isHotel
				+ ", flight_type=" + flight_type + ", product_price=" + product_price + "]";
	}
	
	
	
	
	
	
	
	

}
