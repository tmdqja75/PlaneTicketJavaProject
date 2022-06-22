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
			System.out.println("1.항공사 2.여행사 3.여행자 4.여권 5.종료");
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
			System.out.println("1.여행상품등록 2.여행상품검색 3.여행상품수정 4.여행상품삭제 5.종료");
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
			System.out.println("1.비행사검색 2.여행사검색 3.전체검색 4.종료");
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
