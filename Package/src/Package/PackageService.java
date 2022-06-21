package Package;

import java.util.Scanner;

public class PackageService {
    private PackageDao dao;

    public PackageService() {
        dao = new PackageDao();
    }

    public void addPackage(Scanner sc) {
        int min = 10000;
        int max = 99999;
        String prod_num = String.valueOf((int) (Math.random() * (max - min + 1) + min));

        System.out.println("항공번호: ");
        String flight_id = sc.next();

        System.out.println("여행사: ");
        String agency = sc.next();

        // System.out.println("목적지: ");
        // String dest = sc.next();

        System.out.println("기간: ");
        String period = sc.next();

        System.out.println("설명: ");
        String manual = sc.next();

        System.out.println("호텔 여부(true/false): ");
        Boolean hotel = sc.nextBoolean();

        System.out.println("해외(true)/국내(false)");
        Boolean flight_type = sc.nextBoolean();

        System.out.println("가격: ");
        int price = sc.nextInt();

        Package p = new Package(prod_num, flight_id, agency, period, manual, hotel, flight_type, price);

        dao.insert(p);
    }

    public void editFlight(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();

        System.out.println("수정된 항공번호: ");
        String flight_id = sc.next();

        dao.update_flightid(prod_num, flight_id);
    }

    public void editAgency(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("수정된 여행사: ");
        String agency = sc.next();

        dao.update_agency(prod_num, agency);
    }

    public void editDest(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("수정된 목적지: ");
        String dest = sc.next();

        dao.update_dest(prod_num, dest);
    }

    public void editPeriod(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("수정된 기간: ");
        String per = sc.next();

        dao.update_period(prod_num, per);
    }

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

    public void editType(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("해외 여부 (true/false): ");
        Boolean man = sc.nextBoolean();

        dao.update_flighttype(prod_num, man);
    }

    public void editPrice(Scanner sc) {

        System.out.println("수정할 여행 패키지 고유 번호: ");
        String prod_num = sc.next();
        System.out.println("수정된 가격: ");
        int price = sc.nextInt();

        dao.update_flighttype(prod_num, price);
    }
}
