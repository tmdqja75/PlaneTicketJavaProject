package travel_agency;

public class Product {
	private int pnum; // �����ǰ��ȣ
	private String filght_id; //����� ��ȣ
	private String agency; // ����� �̸�
	private String destination; // ������
	private int period; // ���� �Ⱓ
	private String manual; // ����
	private boolean ishotel; // ȣ�� ���� ����
	private boolean flight_type; // ��/���� ����
	private int product_price; // ��ǰ ����
	
	public Product() {
	}
	
	public Product(int pnum, String filght_id, String agency, String destination, int period, String manual,
			boolean ishotel, boolean flight_type, int product_price) {
		super();
		this.pnum = pnum;
		this.filght_id = filght_id;
		this.agency = agency;
		this.destination = destination;
		this.period = period;
		this.manual = manual;
		this.ishotel = ishotel;
		this.flight_type = flight_type;
		this.product_price = product_price;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getFilght_id() {
		return filght_id;
	}

	public void setFilght_id(String filght_id) {
		this.filght_id = filght_id;
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

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getManual() {
		return manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}

	public boolean isIshotel() {
		return ishotel;
	}

	public void setIshotel(boolean ishotel) {
		this.ishotel = ishotel;
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
		return "Product [pnum=" + pnum + ", filght_id=" + filght_id + ", agency=" + agency + ", destination="
				+ destination + ", period=" + period + ", manual=" + manual + ", ishotel=" + ishotel + ", flight_type="
				+ flight_type + ", product_price=" + product_price + "]";
	}
	
	
}
