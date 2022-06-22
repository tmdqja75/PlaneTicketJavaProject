package airline;

public class Flight {
	private String flight_id; // 비행편 id
	private String airline; // 항공사
	private String startTime; // 출발시간
	private String arrivalTime; // 도착시간
	private String startingPoint; // 출발지
	private String destination; // 도착지
	private int remnantCount; // 잔여석
	private int flightPrice; // 비행편 가격
	
	public Flight(String flight_id,String operator, String startTime, String arrivalTime,
			String startingPoint, String destination, int remnantCount,int flightPrice){
		this.flight_id = flight_id;
		this.airline = operator;
		this.startTime = startTime;
		this.arrivalTime = arrivalTime;
		this.startingPoint = startingPoint;
		this.destination = destination;
		this.remnantCount = remnantCount;
		this.flightPrice = flightPrice;
	}

	public String getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String operator) {
		this.airline = operator;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getRemnantCount() {
		return remnantCount;
	}

	public void setRemnantCount(int remnantCount) {
		this.remnantCount = remnantCount;
	}

	public int getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(int flightPrice) {
		this.flightPrice = flightPrice;
	}

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", airline=" + airline + ", startTime=" + startTime
				+ ", arrivalTime=" + arrivalTime + ", startingPoint=" + startingPoint + ", destination=" + destination
				+ ", remnantCount=" + remnantCount + ", flightPrice=" + flightPrice + "]";
	}
	
	
}
