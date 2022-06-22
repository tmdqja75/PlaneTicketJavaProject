package airline;

import java.util.ArrayList;
import java.util.Scanner;



public class FlightService {
	private FlightDao dao;
	
	public FlightService() {
		dao = new FlightDao();
	}

	// 항공편 추가
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
		// vo에 제품 정보를 담아
		Flight p = new Flight(flight_id, airline, startTime, arrivalTime, startingPoint, destination, remnantCount, flightPrice);
		// 배열에 추가. dao.insert()가 이 작업 수행
		dao.insert(p);
	}
	
	public void editAll(Scanner sc) { // 출발 시간, 도착 시간 변경
		
		System.out.print("수정할 flight_id:");
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
	
    public void editTime(Scanner sc) { // 출발 시간, 도착 시간 변경

        System.out.println("수정하려는 항공편 id: ");
        String flight_id = sc.next();
        System.out.println("출발시간 : ");
        String startTime = sc.next();
        System.out.println("도착시간 : ");
        String arrivalTime = sc.next();

        dao.updateTime(startTime, arrivalTime,flight_id);
    }

    public void editPlace(Scanner sc) { // 출발지, 도착지 변경

    	System.out.println("수정하려는 항공편 id: ");
        String flight_id = sc.next();
        System.out.println("출발지 : ");
        String startingPoint = sc.next();
        System.out.println("도착지 : ");
        String destination = sc.next();

        dao.updatePlace(startingPoint, destination,flight_id);
    }

    public void editRemnantCount(Scanner sc) {

    	System.out.println("수정하려는 항공편 id: ");
        String flight_id = sc.next();
        System.out.println("잔여석 : ");
        int remnantCount = sc.nextInt();
        

        dao.updateRemnantCount(remnantCount, flight_id);
    }


    public void editPrice(Scanner sc) {

    	System.out.println("수정하려는 항공편 id: ");
        String flight_id = sc.next();
        System.out.println("항공편 가격 : ");
        int flightPrice = sc.nextInt();

        dao.updateFlightPrice(flightPrice, flight_id);
    }
    
    // 전체출력
 	public void searchAll() {
 		ArrayList<Flight> list = dao.selectAll();
 		for (Flight p : list) {
 			System.out.println(p);
 		}
 	}

	
	// 제품번호로 검색
	public void searchFlightByFlightId(Scanner sc) {
		System.out.print("search flight id: ");
		String id = sc.next();

		ArrayList<Flight> list = dao.selectByFlightId(id);
		if (list.size() == 0) {
			System.out.println("없는 항공편입니다.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
 		
		
	}
	
	// 고객용
	public void searchFlightByPlace(Scanner sc) {
		System.out.print("출발지 : ");
		String startingPoint = sc.next();
		
		System.out.print("도착지 : ");
		String destination = sc.next();

		ArrayList<Flight> list = dao.selectByPlace(startingPoint, destination);
		if (list.size() == 0) {
			System.out.println("없는 항공편입니다.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	public void searchFlightByStartingPoint(Scanner sc) {
		System.out.print("출발지 : ");
		String startingPoint = sc.next();

		ArrayList<Flight> list = dao.selectBystartingPoint(startingPoint);
		if (list.size() == 0) {
			System.out.println("없는 항공편입니다.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	public void searchFlightByDestination(Scanner sc) {
		System.out.print("도착지 : ");
		String destination = sc.next();

		ArrayList<Flight> list = dao.selectByDestination(destination);
		if (list.size() == 0) {
			System.out.println("없는 항공편입니다.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	public void searchFlightByDay(Scanner sc) {
		System.out.print("날짜(년-월-일 형태로 입력) : ");
		String day = sc.next();

		ArrayList<Flight> list = dao.selectByDay(day);
		if (list.size() == 0) {
			System.out.println("없는 항공편입니다.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	public void searchFlightByPlaceAndDay(Scanner sc) {
		System.out.print("날짜(년-월-일 형태로 입력) : ");
		String day = sc.next();

		System.out.print("출발지 : ");
		String startingPoint = sc.next();
		
		System.out.print("도착지 : ");
		String destination = sc.next();
		
		ArrayList<Flight> list = dao.selectByPlaceAndDay(startingPoint, destination, day);
		if (list.size() == 0) {
			System.out.println("없는 항공편입니다.");
		}
		else {
			for (Flight p : list) {
	 			System.out.println(p);
	 		}
		}
	}
	
	// 삭제
	public void delFlight(Scanner sc) {
		System.out.print("삭제할 항공편 id:");
		String id = sc.next();
		boolean flag = dao.delete(id);
		if (flag) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제 취소됨");
		}
	}


	
}
