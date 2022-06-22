package ticket_reservation;

import java.util.Scanner;

import travel_agency.ProductService;

public class Menu {
	private ProductService pservice;
	
	public Menu() {
		pservice = new ProductService();
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
				
				break;
			case 2:
				searchProduct(sc);
				break;
			case 3:
				
				break;
			case 4:
				pservice.DeleteProduct(sc);
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
				pservice.SearchByNation(sc);
				break;
			case 2:
				pservice.SearchByAgency(sc);
				break;
			case 3:
				pservice.SearchAll();
				break;
			case 7:
				flag = false;
				break;
			}
		}
	}
}
