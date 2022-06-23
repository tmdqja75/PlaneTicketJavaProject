package ticket_reservation;

import java.util.Scanner;

import travel_agency.PackageService;

public class Menu {
	private PackageService packservice;
	
	public Menu() {
		packservice = new PackageService();
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while (flag) {
			System.out.println("1.�װ��� 2.����� 3.������ 4.���� 5.����");
			m = sc.nextInt();
			switch (m) {
			case 1:
				break;
			case 2:
				runAgency(sc);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}
	
	public void runAgency(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while(flag) {
			System.out.println("1.�����ǰ��� 2.�����ǰ�˻� 3.�����ǰ���� 4.�����ǰ���� 5.����");
			m = sc.nextInt();
			switch(m) {
			case 1:
				packservice.addPackage(sc);
				break;
			case 2:
				searchProduct(sc);
				break;
			case 3:
				runEditPackage(sc);
				break;
			case 4:
				packservice.DeleteProduct(sc);
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}
	
	public void searchProduct(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while(flag) {
			System.out.println("1.�����˻� 2.�����˻� 3.��ü�˻� 4.����");
			m = sc.nextInt();
			switch(m) {
			case 1:
				packservice.SearchByNation(sc);
				break;
			case 2:
				packservice.SearchByAgency(sc);
				break;
			case 3:
				packservice.SearchAll();
				break;
			case 7:
				flag = false;
				break;
			}
		}
	}
	
	public void runEditPackage(Scanner sc) {
        boolean flag = true;
        int m = 0;
        while (flag) {
            System.out.println("1. ��� �װ��� ����, 2. ���� �װ��� ���� 3. ����� ����, 4. ���� ����, 5. ȣ�� ���� ����, 6. �ؿ� ���� ����, 7. ���� ���� 8. ����");
            m = sc.nextInt();
            switch (m) {
                
                case 1:
                    packservice.editDepartflight(sc);
                    break;
                case 2:
                    packservice.editArriveflight(sc);
                    break;
                case 3:
                    packservice.editAgency(sc);
                    break;
                case 4:
                    packservice.editManual(sc);
                    break;
                case 5:
                    packservice.editHotel(sc);
                    break;
                case 6:
                    packservice.editType(sc);
                    break;
                case 7:
                    packservice.editPrice(sc);
                    break;
                case 8:
                    flag = false;
                    break;
            }
        }
    }
}
