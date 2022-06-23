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
	
	//�����ǰ ���
	public void addPackage(Scanner sc) {
        // int min = 100000;
        // int max = 999999;
        // String prod_num = String.valueOf((int) (Math.random() * (max - min + 1) + min));

        System.out.println("��� �װ���ȣ: ");
        String departflight_id = sc.next();

        System.out.println("���� �װ���ȣ: ");
        String arriveflight_id = sc.next();

        System.out.println("�����: ");
        String agency = sc.next();

        // System.out.println("������: ");
        // String dest = sc.next();

        // System.out.println("�Ⱓ: ");
        // String period = sc.next();

        System.out.println("����: ");
        String manual = sc.next();

        System.out.println("ȣ�� ����(true/false): ");
        Boolean hotel = sc.nextBoolean();

        System.out.println("�ؿ�(true)/����(false)");
        Boolean flight_type = sc.nextBoolean();

        System.out.println("����: ");
        int price = sc.nextInt();

        Package p = new Package(departflight_id, arriveflight_id, agency, manual, hotel, flight_type, price);

        dao.insert(p);
    }

	
	//���ϴ� �������� ��ǰ ���
	public void SearchByNation(Scanner sc) {
		System.out.println("ã�� ��ǰ�� �������� �Է��ϼ���:");
		String nation = sc.next();
		
		//ArrayList<Package> list = dao.SearchByNation(nation);
		dao.SearchByNation(nation);
	}
	
	//���ϴ� �װ����� ��ǰ ���
	public void SearchByAgency(Scanner sc) {
		System.out.println("ã�� ��ǰ�� �װ��縦 �Է��ϼ���:");
		String agency = sc.next();
		
		//ArrayList<Package> list = dao.SearchByAgency(agency);
		dao.SearchByAgency(agency);
	}
	
	//��� �����ǰ ���
	public void SearchAll() {
		dao.SearchAll();
	}
	
	//���� ����� ����
	public void editDepartflight(Scanner sc) {

        System.out.println("������ ���� ��Ű�� ���� ��ȣ: ");
        String prod_num = sc.next();

        System.out.println("������ ����װ���ȣ: ");
        String flight_id = sc.next();

        int per = dao.getDepartPeriod(prod_num, flight_id);
        if (per < 0) {
            System.out.println("���õ� ǥ�� ������ ���Ŀ� ����մϴ�. ���� ����.");
        } else {
            dao.update_departflightid(prod_num, flight_id);
            dao.update_period(prod_num, per);
        }

    }

	//��� ����� ����
    public void editArriveflight(Scanner sc) {

        System.out.println("������ ���� ��Ű�� ���� ��ȣ: ");
        String prod_num = sc.next();

        System.out.println("������ ���� �װ���ȣ: ");
        String flight_id = sc.next();

        int per = dao.getDepartPeriod(prod_num, flight_id);
        if (per < 0) {
            System.out.println("���õ� ǥ�� ����� ������ �����մϴ�. ���� ����.");
        } else {
            dao.update_arriveflightid(prod_num, flight_id);
            dao.update_period(prod_num, per);
        }

    }

    //����� ����
    public void editAgency(Scanner sc) {

        System.out.println("������ ���� ��Ű�� ���� ��ȣ: ");
        String prod_num = sc.next();
        System.out.println("������ �����: ");
        String agency = sc.next();

        dao.update_agency(prod_num, agency);
    }

    // public void editDest(Scanner sc) {

    //     System.out.println("������ ���� ��Ű�� ���� ��ȣ: ");
    //     String prod_num = sc.next();
    //     System.out.println("������ ������: ");
    //     String dest = sc.next();

    //     dao.update_dest(prod_num, dest);
    // }

    
    //���� ����
    public void editManual(Scanner sc) {

        System.out.println("������ ���� ��Ű�� ���� ��ȣ: ");
        String prod_num = sc.next();
        System.out.println("������ ����: ");
        String man = sc.next();

        dao.update_manual(prod_num, man);
    }

    public void editHotel(Scanner sc) {

        System.out.println("������ ���� ��Ű�� ���� ��ȣ: ");
        String prod_num = sc.next();
        System.out.println("ȣ�� ���� ����: ");
        Boolean hotel = sc.nextBoolean();

        dao.update_hotel(prod_num, hotel);
    }

    //������ ���� ���� ����
    public void editType(Scanner sc) {

        System.out.println("������ ���� ��Ű�� ���� ��ȣ: ");
        String prod_num = sc.next();
        System.out.println("�ؿ� ���� (true/false): ");
        Boolean man = sc.nextBoolean();

        dao.update_flighttype(prod_num, man);
    }

    //���� ����
    public void editPrice(Scanner sc) {

        System.out.println("������ ���� ��Ű�� ���� ��ȣ: ");
        String prod_num = sc.next();
        System.out.println("������ ����: ");
        int price = sc.nextInt();

        dao.update_flighttype(prod_num, price);
    }

	//��ǰ����
	public void DeleteProduct(Scanner sc) {
		System.out.print("������ ��ǰ�� ��ȣ�� �Է��ϼ��� :");
		int num = sc.nextInt();
		boolean flag = dao.delProduct(num);
		if(flag) {
			System.out.println(num+"�� ��ǰ�� �����Ǿ����ϴ�.");
		}else {
			System.out.println("���� ��ǰ ��ȣ�Դϴ�");
		}
	}
}
