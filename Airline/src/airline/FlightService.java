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
		// vo에 제품 정보를 담아
		Flight p = new Flight(flight_id, operator, startTime, arrivalTime, startingPoint, destination, remnantCount, flightPrice);
		// 배열에 추가. dao.insert()가 이 작업 수행
		dao.insert(p);
	}
	
	public void editAll(Scanner sc) { // 출발 시간, 도착 시간 변경
		
		System.out.print("수정할 flight_id:");
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

	
	// 제품번호로 검색
	public void getFlightByFlightId(Scanner sc) {
		System.out.print("search flight id: ");
		String id = sc.next();

		Flight p = dao.selectByFlightId(id);
		if (p == null) {
			System.out.println("없는 항공편 번호");
		} else {
			System.out.println(p);
		}
	}

//	// 주문에서 필요한 메서드.
//	// 주문으로 선택한 제품을 전달
//	public Flight getProduct(int num) {
//		return dao.selectByNum(num);
//	}

	// 전체출력
	public void printAll() {
		ArrayList<Flight> list = dao.selectAll();
		for (Flight p : list) {
			System.out.println(p);
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
