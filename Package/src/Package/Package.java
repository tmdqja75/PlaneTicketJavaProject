package travel_agency;

public class Package {
	private int product_num; // 여행상품번호
	private String departflight_id; //출발 비행기 번호
    private String arriveflight_id; //돌아오는 비행기 번호
	private String agency; // 여행사 이름
	private String destination; // 목적지
	private int period; // 여행 기간
	private String manual; // 설명
	private boolean isHotel; // 호텔 예약 여부
	private boolean flight_type; // 국/내외 여행
	private int product_price; // 상품 가격
	
	public Package() {
	}

	public Package(String departflight_id, String arriveflight_id, String agency, 
			String manual, boolean isHotel, boolean flight_type, int product_price) {
		//int product_num;
		this.departflight_id = departflight_id;
		this.arriveflight_id = arriveflight_id;
		this.agency = agency;
		//String destinationn;
		//int period;
		this.manual = manual;
		this.isHotel = isHotel;
		this.flight_type = flight_type;
		this.product_price = product_price;
	}

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public String getDepartflight_id() {
		return departflight_id;
	}

	public void setDepartflight_id(String departflight_id) {
		this.departflight_id = departflight_id;
	}

	public String getArriveflight_id() {
		return arriveflight_id;
	}

	public void setArriveflight_id(String arriveflight_id) {
		this.arriveflight_id = arriveflight_id;
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
		return "Package [product_num=" + product_num + ", departflight_id=" + departflight_id + ", arriveflight_id="
				+ arriveflight_id + ", agency=" + agency + ", destination=" + destination + ", period=" + period
				+ ", manual=" + manual + ", isHotel=" + isHotel + ", flight_type=" + flight_type + ", product_price="
				+ product_price + "]";
	}
	
	
}
