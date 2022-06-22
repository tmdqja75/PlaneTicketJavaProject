package travel_agency;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
	private ProductDao dao;
	public static String Product_Num = "";
	public static String Nation = "";
	
	public ProductService() {
		dao = new ProductDao();
	}
	
	//���ϴ� �������� ��ǰ ���
	public void SearchByNation(Scanner sc) {
		System.out.println("ã�� ��ǰ�� �������� �Է��ϼ���:");
		String nation = sc.next();
		
		ArrayList<Product> list = dao.SearchByNation(nation);
		if(list.size()==0) {
			System.out.println(nation + "(��)�� ��ϵ� �����ǰ�� �����ϴ�.");
		} else {
			System.out.println(list);
		}
	}
	
	//���ϴ� �װ����� ��ǰ ���
	public void SearchByAgency(Scanner sc) {
		System.out.println("ã�� ��ǰ�� �װ��縦 �Է��ϼ���:");
		String agency = sc.next();
		
		ArrayList<Product> list = dao.SearchByAgency(agency);
		if(list.size()==0) {
			System.out.println(agency +" �װ��翡�� ã�� �����ǰ�� �����ϴ�.");
		} else {
			System.out.println(list);
		}
	}
	
	//��� �����ǰ ���
	public void SearchAll() {
		ArrayList<Product> list = dao.SearchAll();
		for (Product p: list) {
			System.out.println(p);
		}
	}
	
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
