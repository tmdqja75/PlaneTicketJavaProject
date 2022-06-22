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
			System.out.println("1. �װ��� �߰� 2. ��ü ���� 3. �ð� ���� 4. �����, ������ ���� 5. �ܿ��� ����");
			System.out.println("6. ���� ���� 7. ��ǰ �˻� 8. ��ü ��� 9. ���� 10.����");
			
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