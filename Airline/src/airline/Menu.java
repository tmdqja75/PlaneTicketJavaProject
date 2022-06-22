package airline;

import java.util.Scanner;



public class Menu {
	private FlightService fservice;

	public Menu() {
		fservice = new FlightService();
		
	}

	
	public void run(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while (flag) {
			System.out.println("1. 항공편 추가 2. 전체 수정 3. 시간 변경 4. 출발지, 도착지 변경 5. 잔여석 변경");
			System.out.println("6. 가격 변경 7. 제품 검색 8. 전체 출력 9. 삭제 10.종료");
			
			m = sc.nextInt();
			switch (m) {
			case 1:
				fservice.addFlight(sc);
				break;
			case 2:
				fservice.editAll(sc);
				break;
				
			case 3:
				fservice.editTime(sc);
				break;
				
			case 4:
				fservice.editPlace(sc);
				break;
				
			case 5:
				fservice.editRemnantCount(sc);
				break;
				
			case 6:
				fservice.editPrice(sc);
				break;
				
			case 7:
				fservice.getFlightByFlightId(sc);
				break;
				
			case 8:
				fservice.printAll();
				break;
				
			case 9:
				fservice.delFlight(sc);
				break;
				
			case 10:
				flag = false;
				break;
			}
		}
	}

}