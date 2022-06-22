package purchase;

import java.util.Scanner;

public class Menu {
	
	private PurchaseService service;
	
	public Menu() {
	service = new PurchaseService();
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int m;
		while(flag) {
			System.out.println("1.상품조회 2.여행상품 구매 3.예매확인 4.결제 5.결제취소 6.예매취소 7.여권등록 8.종료");
			m = sc.nextInt();
			switch(m) {
			case 1:
				service.searchProducts();
				break;
			case 2: 
				service.buyProduct(sc);
				break;
			case 3:
				service.checkReservation(sc);
				break;
			case 4:
				service.pay(sc);
				break;
			case 5:
				service.cancelPay(sc);
				break;	
			case 6:
				service.cancelReserv(sc);
				break;
				
			case 7:
				
				break;
			case 8:
				flag = false;
				break;
				
			
			
			}
		}
	}
	
}
