package travel_agency;

import java.util.ArrayList;
import java.util.Scanner;

public class PackageService {
	private PackageDao dao;
	public static String Product_Num = "";
	public static String Nation = "";
	
	public PackageService() {
		dao = new PackageDao();
	}
	
	//여행상품 등록
	public void addPackage(Scanner sc) {
        // int min = 100000;
        // int max = 999999;
        // String prod_num = String.valueOf((int) (Math.random() * (max - min + 1) + min));

        System.out.println("출발 항공번호: ");
        String departflight_id = sc.next();

        System.out.println("도착 항공번호: ");
        String arriveflight_id = sc.next();

        System.out.println("여행사: ");
        String agency = sc.next();

        // System.out.println("목적지: ");
        // String dest = sc.next();

        // System.out.println("기간: ");
        // String period = sc.next();

        System.out.println("설명: ");
        String manual = sc.next();

        System.out.println("호텔 여부(true/false): ");
        Boolean hotel = sc.nextBoolean();

        System.out.println("해외(true)/국내(false)");
        Boolean flight_type = sc.nextBoolean();

        System.out.println("가격: ");
        int price = sc.nextInt();

        Package p = new Package(departflight_id, arriveflight_id, agency, manual, hotel, flight_type, price);

        dao.insert(p);
    }

	
	//원하는 국가명의 상품 출력
	public void SearchByNation(Scanner sc) {
		System.out.println("찾을 상품의 국가명을 입력하세요:");
		String nation = sc.next();
		
		//ArrayList<Package> list = dao.SearchByNation(nation);
		dao.SearchByNation(nation);
	}
	
	//원하는 항공사의 상품 출력
	public void SearchByAgency(Scanner sc) {
		System.out.println("찾을 상품의 항공사를 입력하세요:");
		String agency = sc.next();
		
		//ArrayList<Package> list = dao.SearchByAgency(agency);
		dao.SearchByAgency(agency);
	}
	
	//모든 여행상품 출력
	public void SearchAll() {
		dao.SearchAll();
	}
	
	//도착 비행기 수정
	public void editDepartflight(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();

        System.out.println("수정된 출발항공번호: ");
        String flight_id = sc.next();

        int per = dao.getDepartPeriod(prod_num, flight_id);
        if (per < 0) {
            System.out.println("선택된 표는 도착일 이후에 출발합니다. 수정 종료.");
        } else {
            dao.update_departflightid(prod_num, flight_id);
            dao.update_period(prod_num, per);
        }

    }

	//출발 비행기 수정
    public void editArriveflight(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();

        System.out.println("수정된 도착 항공번호: ");
        String flight_id = sc.next();

        int per = dao.getDepartPeriod(prod_num, flight_id);
        if (per < 0) {
            System.out.println("선택된 표는 출발일 이전에 도착합니다. 수정 종료.");
        } else {
            dao.update_arriveflightid(prod_num, flight_id);
            dao.update_period(prod_num, per);
        }

    }

    //여행사 수정
    public void editAgency(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("수정된 여행사: ");
        String agency = sc.next();

        dao.update_agency(prod_num, agency);
    }

    // public void editDest(Scanner sc) {

    //     System.out.println("수정할 여행 패키지 고유 번호: ");
    //     String prod_num = sc.next();
    //     System.out.println("수정된 목적지: ");
    //     String dest = sc.next();

    //     dao.update_dest(prod_num, dest);
    // }

    
    //설명 수정
    public void editManual(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("수정된 설명: ");
        String man = sc.next();

        dao.update_manual(prod_num, man);
    }

    public void editHotel(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("호텔 포함 여부: ");
        Boolean hotel = sc.nextBoolean();

        dao.update_hotel(prod_num, hotel);
    }

    //국내외 여행 여부 수정
    public void editType(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("해외 여부 (true/false): ");
        Boolean man = sc.nextBoolean();

        dao.update_flighttype(prod_num, man);
    }

    //가격 수정
    public void editPrice(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("수정된 가격: ");
        int price = sc.nextInt();

        dao.update_flighttype(prod_num, price);
    }

	//상품삭제
	public void DeleteProduct(Scanner sc) {
		System.out.print("삭제할 상품의 번호를 입력하세요 :");
		int num = sc.nextInt();
		boolean flag = dao.delProduct(num);
		if(flag) {
			System.out.println(num+"번 상품이 삭제되었습니다.");
		}else {
			System.out.println("없는 상품 번호입니다");
		}
	}
}
