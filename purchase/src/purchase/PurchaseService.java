package purchase;

import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseService {
	private PurchaseDao dao;

	public PurchaseService() {
		dao = new PurchaseDao();
	}

	// 1. 상품 조회
	public void searchProducts() {
		ArrayList<Product> list = dao.printProducts(); 
		for (Product p : list) {
			System.out.println(p);
		}

	}

	// 2. 여행상품 구매
	public void buyProduct(Scanner sc) {
		searchProducts();
		String pwd = null;
		System.out.println("구매할 제품 번호를 입력하세요.");
		String number = sc.next();
		boolean flag = dao.checkAbroad(number); // 해외여행인지 확인
		if (flag) {
			System.out.println("여권 등록이 필요한 상품입니다. 등록을 안하신 경우 등록해주세요.");
		}
		System.out.println("아이디를 입력하세요.");
		String id = sc.next();
		String check = dao.checkIsbuy(id); // id로 구매내력이 있는지 확인
		if(check != "") {
			System.out.println("구매한 이력이 있습니다. 이전에 입력한 비밀번호를 입력해주세요,");
			pwd = sc.next();
			if (!check.equals(pwd)) { // 이전에 입력한 비밀번호가 지금 입력한 비밀번호와 다를경우
				System.out.println("입력한 비밀번호가 틀립니다.");
				return;
				
			}
		}else {
			System.out.println("비밀번호를 입력하세요.");
			pwd = sc.next();
		}
		
		System.out.println("구매할 매수를 입력하세요.");
		int cnt = sc.nextInt();
		
		// num(자동할당), passport_id 는 일단 0으로 입력
		dao.purchase(new Reservation(0, id, pwd, number, cnt, 0, false));

	}
	

	// 3. 예매 확인
	public void checkReservation(Scanner sc) {
		ArrayList<Reservation> list = null;
		System.out.println("구매시 입력한 아이디를 입력하세요.");
		String id = sc.next();
		System.out.println("구매시 입력한 비밀번호를 입력하세요.");
		String pwd = sc.next();
		
		list = dao.search(id, pwd); // 아이디 패스워드로 db검색하여 list로 반환
		if (list.size() != 0) { // list != null => list.size() !=0 으로 변경 리스트가 비어있지않으면 출력
			for (Reservation r : list) {
				System.out.println(r);
			}

		} else {
			System.out.println("아이디나 비밀번호가 잘못되었습니다.");

		}

	}

	// 4. 결제
	public void pay(Scanner sc) {
		System.out.println("구매시 입력한 아이디를 입력하세요.");
		String id = sc.next();
		boolean check = dao.minusSeat(id); // 좌석수 -
		if (check) {
			boolean paycheck = dao.checkIspay(id);
			if (paycheck) { // ispay 체크
				System.out.println("이미 결제되었거나, 예매정보가 없습니다.");
			} else {
				boolean flag = dao.updateIspay(id); // 결제처리
				if (flag) {
					System.out.println("결제가 완료되었습니다.");
				} else {
					System.out.println("예매 정보를 다시 확인해주세요.");
				}
			}
		} else {
			System.out.println("좌석이 부족합니다. 다시 확인해주세요.");
		}

	}

	

	// 5. 결제 취소
	public void cancelPay(Scanner sc) {
		System.out.println("구매시 입력한 아이디를 입력하세요.");
		String id = sc.next();
		System.out.println("구매시 입력한 비밀번호를 입력하세요.");
		String pwd = sc.next();
		
		
		boolean paycheck = dao.checkIspay(id); // 결제했었는지 체크
		if (paycheck) {
			boolean flag = dao.cancelIspay(id, pwd); // 아디디 비밀번호 체크
			if (flag) {
				dao.plusSeat(id);
				System.out.println("취소가 완료되었습니다.");
			} else {
				System.out.println("잘못된 정보를 입력하셨습니다.");
			}
		}else {
			System.out.println("결제가 완료되지 않은 상품이거나, 잘못된 정보를 입력하셨습니다.");
		}
		
	}

	// 6. 예매 취소
	public void cancelReserv(Scanner sc) {
		System.out.println("구매시 입력한 아이디를 입력하세요.");
		String id = sc.next();
		System.out.println("구매시 입력한 비밀번호를 입력하세요.");
		String pwd = sc.next();

		boolean flag = dao.cancelReservation(id, pwd);
		if (flag) {
			System.out.println("취소가 완료되었습니다.");
		} else {
			System.out.println("잘못된 정보를 입력하셨거나, 결제가 완료된 상품입니다.");
		}
	}

}

