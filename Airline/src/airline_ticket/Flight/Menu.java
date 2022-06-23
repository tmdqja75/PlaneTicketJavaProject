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
			
			System.out.println("1. �װ��� �߰� | 2. �װ��� �˻� | 3. �װ��� ���� | 4. �װ��� ���� | 5. ����");
			
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
			
			System.out.println("1. ��ü ���� | 2. �����, ������ ���� | 3. �ð� ���� | 4. �ܿ��� ����");
			System.out.println("5. ���� ���� | 6. �ڷΰ���");
			
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
			System.out.println("1. ��ü ��� | 2. �װ��� id �˻� | 3. �����, ������ �˻� | 4. ����� �˻�");
			System.out.println("5. ������ �˻� | 6. �ð� �˻� | 7. ���,�ð� ���� �˻� | 8. �ڷΰ���");
			
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