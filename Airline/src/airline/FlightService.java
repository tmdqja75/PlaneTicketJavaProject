package airline;

import java.util.ArrayList;
import java.util.Scanner;



public class FlightService {
	private FlightDao dao;
	
	public FlightService() {
		dao = new FlightDao();
	}

	// �װ��� �߰�
	public void addFlight(Scanner sc) {
		System.out.print("flight_id:");
		String flight_id = sc.next();
		
		System.out.print("operator:");
		String operator = sc.next();
		
		System.out.print("startTime:");
		String startTime = sc.next();
		
		sc.nextLine();
		
		System.out.print("arrivalTime:");
		String arrivalTime = sc.next();
		
		sc.nextLine();
		
		System.out.print("startingPoint:");
		String startingPoint = sc.next();
		
		sc.nextLine();
		
		System.out.print("destination:");
		String destination = sc.next();
		
		sc.nextLine();
		
		System.out.print("remnantCount:");
		int remnantCount = sc.nextInt();

		System.out.print("flightPrice:");
		int flightPrice = sc.nextInt();
		// vo�� ��ǰ ������ ���
		Flight p = new Flight(flight_id, operator, startTime, arrivalTime, startingPoint, destination, remnantCount, flightPrice);
		// �迭�� �߰�. dao.insert()�� �� �۾� ����
		dao.insert(p);
	}
	
	public void editAll(Scanner sc) { // ��� �ð�, ���� �ð� ����
		
		System.out.print("������ flight_id:");
		String flight_id = sc.next();
		
		System.out.print("operator:");
		String operator = sc.next();
		
		System.out.print("startTime:");
		String startTime = sc.next();
		
		sc.nextLine();
		
		System.out.print("arrivalTime:");
		String arrivalTime = sc.next();
		
		sc.nextLine();
		
		System.out.print("startingPoint:");
		String startingPoint = sc.next();
		
		sc.nextLine();
		
		System.out.print("destination:");
		String destination = sc.next();
		
		sc.nextLine();
		
		System.out.print("remnantCount:");
		int remnantCount = sc.nextInt();

		System.out.print("flightPrice:");
		int flightPrice = sc.nextInt();
		
		Flight p = new Flight(flight_id, operator, startTime, arrivalTime, startingPoint, destination, remnantCount, flightPrice);
        dao.update(p);
    }
	
    public void editTime(Scanner sc) { // ��� �ð�, ���� �ð� ����

        System.out.println("�����Ϸ��� �װ��� id: ");
        String flight_id = sc.next();
        System.out.println("��߽ð� : ");
        String startTime = sc.next();
        System.out.println("�����ð� : ");
        String arrivalTime = sc.next();

        dao.updateTime(startTime, arrivalTime,flight_id);
    }

    public void editPlace(Scanner sc) { // �����, ������ ����

    	System.out.println("�����Ϸ��� �װ��� id: ");
        String flight_id = sc.next();
        System.out.println("����� : ");
        String startingPoint = sc.next();
        System.out.println("������ : ");
        String destination = sc.next();

        dao.updatePlace(startingPoint, destination,flight_id);
    }

    public void editRemnantCount(Scanner sc) {

    	System.out.println("�����Ϸ��� �װ��� id: ");
        String flight_id = sc.next();
        System.out.println("�ܿ��� : ");
        int remnantCount = sc.nextInt();
        

        dao.updateRemnantCount(remnantCount, flight_id);
    }


    public void editPrice(Scanner sc) {

    	System.out.println("�����Ϸ��� �װ��� id: ");
        String flight_id = sc.next();
        System.out.println("�װ��� ���� : ");
        int flightPrice = sc.nextInt();

        dao.updateFlightPrice(flightPrice, flight_id);
    }

	
	// ��ǰ��ȣ�� �˻�
	public void getFlightByFlightId(Scanner sc) {
		System.out.print("search flight id: ");
		String id = sc.next();

		Flight p = dao.selectByFlightId(id);
		if (p == null) {
			System.out.println("���� �װ��� ��ȣ");
		} else {
			System.out.println(p);
		}
	}

//	// �ֹ����� �ʿ��� �޼���.
//	// �ֹ����� ������ ��ǰ�� ����
//	public Flight getProduct(int num) {
//		return dao.selectByNum(num);
//	}

	// ��ü���
	public void printAll() {
		ArrayList<Flight> list = dao.selectAll();
		for (Flight p : list) {
			System.out.println(p);
		}
	}

	// ����
	public void delFlight(Scanner sc) {
		System.out.print("������ �װ��� id:");
		String id = sc.next();
		boolean flag = dao.delete(id);
		if (flag) {
			System.out.println("�����Ϸ�");
		} else {
			System.out.println("���� ��ҵ�");
		}
	}


	
}
