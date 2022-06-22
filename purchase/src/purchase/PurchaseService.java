package purchase;

import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseService {
	private PurchaseDao dao;

	public PurchaseService() {
		dao = new PurchaseDao();
	}

	// 1. ��ǰ ��ȸ
	public void searchProducts() {
		ArrayList<Product> list = dao.printProducts(); 
		for (Product p : list) {
			System.out.println(p);
		}

	}

	// 2. �����ǰ ����
	public void buyProduct(Scanner sc) {
		searchProducts();
		String pwd = null;
		System.out.println("������ ��ǰ ��ȣ�� �Է��ϼ���.");
		String number = sc.next();
		boolean flag = dao.checkAbroad(number); // �ؿܿ������� Ȯ��
		if (flag) {
			System.out.println("���� ����� �ʿ��� ��ǰ�Դϴ�. ����� ���Ͻ� ��� ������ּ���.");
		}
		System.out.println("���̵� �Է��ϼ���.");
		String id = sc.next();
		String check = dao.checkIsbuy(id); // id�� ���ų����� �ִ��� Ȯ��
		if(check != "") {
			System.out.println("������ �̷��� �ֽ��ϴ�. ������ �Է��� ��й�ȣ�� �Է����ּ���,");
			pwd = sc.next();
			if (!check.equals(pwd)) { // ������ �Է��� ��й�ȣ�� ���� �Է��� ��й�ȣ�� �ٸ����
				System.out.println("�Է��� ��й�ȣ�� Ʋ���ϴ�.");
				return;
				
			}
		}else {
			System.out.println("��й�ȣ�� �Է��ϼ���.");
			pwd = sc.next();
		}
		
		System.out.println("������ �ż��� �Է��ϼ���.");
		int cnt = sc.nextInt();
		
		// num(�ڵ��Ҵ�), passport_id �� �ϴ� 0���� �Է�
		dao.purchase(new Reservation(0, id, pwd, number, cnt, 0, false));

	}
	

	// 3. ���� Ȯ��
	public void checkReservation(Scanner sc) {
		ArrayList<Reservation> list = null;
		System.out.println("���Ž� �Է��� ���̵� �Է��ϼ���.");
		String id = sc.next();
		System.out.println("���Ž� �Է��� ��й�ȣ�� �Է��ϼ���.");
		String pwd = sc.next();
		
		list = dao.search(id, pwd); // ���̵� �н������ db�˻��Ͽ� list�� ��ȯ
		if (list.size() != 0) { // list != null => list.size() !=0 ���� ���� ����Ʈ�� ������������� ���
			for (Reservation r : list) {
				System.out.println(r);
			}

		} else {
			System.out.println("���̵� ��й�ȣ�� �߸��Ǿ����ϴ�.");

		}

	}

	// 4. ����
	public void pay(Scanner sc) {
		System.out.println("���Ž� �Է��� ���̵� �Է��ϼ���.");
		String id = sc.next();
		boolean check = dao.minusSeat(id); // �¼��� -
		if (check) {
			boolean paycheck = dao.checkIspay(id);
			if (paycheck) { // ispay üũ
				System.out.println("�̹� �����Ǿ��ų�, ���������� �����ϴ�.");
			} else {
				boolean flag = dao.updateIspay(id); // ����ó��
				if (flag) {
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				} else {
					System.out.println("���� ������ �ٽ� Ȯ�����ּ���.");
				}
			}
		} else {
			System.out.println("�¼��� �����մϴ�. �ٽ� Ȯ�����ּ���.");
		}

	}

	

	// 5. ���� ���
	public void cancelPay(Scanner sc) {
		System.out.println("���Ž� �Է��� ���̵� �Է��ϼ���.");
		String id = sc.next();
		System.out.println("���Ž� �Է��� ��й�ȣ�� �Է��ϼ���.");
		String pwd = sc.next();
		
		
		boolean paycheck = dao.checkIspay(id); // �����߾����� üũ
		if (paycheck) {
			boolean flag = dao.cancelIspay(id, pwd); // �Ƶ�� ��й�ȣ üũ
			if (flag) {
				dao.plusSeat(id);
				System.out.println("��Ұ� �Ϸ�Ǿ����ϴ�.");
			} else {
				System.out.println("�߸��� ������ �Է��ϼ̽��ϴ�.");
			}
		}else {
			System.out.println("������ �Ϸ���� ���� ��ǰ�̰ų�, �߸��� ������ �Է��ϼ̽��ϴ�.");
		}
		
	}

	// 6. ���� ���
	public void cancelReserv(Scanner sc) {
		System.out.println("���Ž� �Է��� ���̵� �Է��ϼ���.");
		String id = sc.next();
		System.out.println("���Ž� �Է��� ��й�ȣ�� �Է��ϼ���.");
		String pwd = sc.next();

		boolean flag = dao.cancelReservation(id, pwd);
		if (flag) {
			System.out.println("��Ұ� �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("�߸��� ������ �Է��ϼ̰ų�, ������ �Ϸ�� ��ǰ�Դϴ�.");
		}
	}

}

