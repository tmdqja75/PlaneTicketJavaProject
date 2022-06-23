package airline_ticket.Flight;

import java.util.Scanner;



public class Menu {
	private FlightService fservice;

	public Menu() {
		fservice = new FlightService();
		
	}
	public void Flightrun(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while (flag) {
			
			System.out.println("1. 항공편 추가 | 2. 항공편 검색 | 3. 항공편 수정 | 4. 항공편 삭제 | 5. 종료");
			
			m = sc.nextInt();
			switch (m) {
			case 1:
				fservice.addFlight(sc);
				break;
			case 2:
				FlightSearchRun(sc);
				break;
			case 3:
				FlightEditRun(sc);
				break;
			case 4:
				fservice.delFlight(sc);
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}
	public void FlightEditRun(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while (flag) {
			
			System.out.println("1. 전체 수정 | 2. 출발지, 도착지 변경 | 3. 시간 변경 | 4. 잔여석 변경");
			System.out.println("5. 가격 변경 | 6. 뒤로가기");
			
			m = sc.nextInt();
			
			switch (m) {
			case 1:
				fservice.editAll(sc);
				break;
			case 2:
				fservice.editPlace(sc);
				break;
			case 3:
				fservice.editTime(sc);
				break;
			case 4:
				fservice.editRemnantCount(sc);
				break;
			case 5:
				fservice.editPrice(sc);
				break;
			case 6:
				flag = false;
				break;
				
			}
		}
	}
	public void FlightSearchRun(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while (flag) {
			System.out.println("1. 전체 출력 | 2. 항공편 id 검색 | 3. 출발지, 도착지 검색 | 4. 출발지 검색");
			System.out.println("5. 도착지 검색 | 6. 시간 검색 | 7. 장소,시간 포함 검색 | 8. 뒤로가기");
			
			m = sc.nextInt();
			
			switch (m) {
			case 1:
				fservice.searchAll();
				break;
			case 2:
				fservice.searchFlightByFlightId(sc);
				break;
			case 3:
				fservice.searchFlightByPlace(sc);
				break;
			case 4:
				fservice.searchFlightByStartingPoint(sc);
				break;
			case 5:
				fservice.searchFlightByDestination(sc);
				break;
			case 6:
				fservice.searchFlightByDay(sc);
				break;
			case 7:
				fservice.searchFlightByPlaceAndDay(sc);
				break;
			case 8:
				flag = false;
				break;
				
			}
		}
	}
}