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
			System.out.println("1.비행사검색 2.여행사검색 3.전체검색 4.종료");
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
            System.out.println("1. 출발 항공편 수정, 2. 도착 항공편 수정 3. 여행사 수정, 4. 설명 수정, 5. 호텔 여부 수정, 6. 해외 여부 수정, 7. 가격 수정 8. 종료");
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
