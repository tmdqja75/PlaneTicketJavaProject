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
		String airline = sc.next();
		
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
		Flight p = new Flight(flight_id, airline, startTime, arrivalTime, startingPoint, destination, remnantCount, flightPrice);
		// �迭�� �߰�. dao.insert()�� �� �۾� ����
		dao.insert(p);
	}
	
	public void editAll(Scanner sc) { // ��� �ð�, ���� �ð� ����
		
		System.out.print("������ flight_id:");
		String flight_id = sc.next();
		
		System.out.print("airline:");
		String airline = sc.next();
		
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
		
		Flight p = new Flight(flight_id, airline, startTime, arrivalTime, startingPoint, destination, remnantCount, flightPrice);
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
    
    // ��ü���
 	public void searchAll() {
 		ArrayList<Flight> list = dao.selectAll();
 		for (Flight p : list) {
 			System.out.println(p);
 		}
 	}

	
	// ��ǰ��ȣ�� �˻�
	public void searchFlightByFlightId(Scanner sc) {
		System.out.print("search flight id: ");
		String id = sc.next();

		ArrayList<Flight> list = dao.selectByFlightId(id);
		if (list.size() == 0) {
			System.out.println("���� �װ����Դϴ�.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
 		
		
	}
	
	// ����
	public void searchFlightByPlace(Scanner sc) {
		System.out.print("����� : ");
		String startingPoint = sc.next();
		
		System.out.print("������ : ");
		String destination = sc.next();

		ArrayList<Flight> list = dao.selectByPlace(startingPoint, destination);
		if (list.size() == 0) {
			System.out.println("���� �װ����Դϴ�.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	public void searchFlightByStartingPoint(Scanner sc) {
		System.out.print("����� : ");
		String startingPoint = sc.next();

		ArrayList<Flight> list = dao.selectBystartingPoint(startingPoint);
		if (list.size() == 0) {
			System.out.println("���� �װ����Դϴ�.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	public void searchFlightByDestination(Scanner sc) {
		System.out.print("������ : ");
		String destination = sc.next();

		ArrayList<Flight> list = dao.selectByDestination(destination);
		if (list.size() == 0) {
			System.out.println("���� �װ����Դϴ�.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	public void searchFlightByDay(Scanner sc) {
		System.out.print("��¥(��-��-�� ���·� �Է�) : ");
		String day = sc.next();

		ArrayList<Flight> list = dao.selectByDay(day);
		if (list.size() == 0) {
			System.out.println("���� �װ����Դϴ�.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	public void searchFlightByPlaceAndDay(Scanner sc) {
		System.out.print("��¥(��-��-�� ���·� �Է�) : ");
		String day = sc.next();

		System.out.print("����� : ");
		String startingPoint = sc.next();
		
		System.out.print("������ : ");
		String destination = sc.next();
		
		ArrayList<Flight> list = dao.selectByPlaceAndDay(startingPoint, destination, day);
		if (list.size() == 0) {
			System.out.println("���� �װ����Դϴ�.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
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
