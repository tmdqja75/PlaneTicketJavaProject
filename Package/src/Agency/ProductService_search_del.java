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
	
	//원하는 국가명의 상품 출력
	public void SearchByNation(Scanner sc) {
		System.out.println("찾을 상품의 국가명을 입력하세요:");
		String nation = sc.next();
		
		ArrayList<Product> list = dao.SearchByNation(nation);
		if(list.size()==0) {
			System.out.println(nation + "(으)로 등록된 여행상품이 없습니다.");
		} else {
			System.out.println(list);
		}
	}
	
	//원하는 항공사의 상품 출력
	public void SearchByAgency(Scanner sc) {
		System.out.println("찾을 상품의 항공사를 입력하세요:");
		String agency = sc.next();
		
		ArrayList<Product> list = dao.SearchByAgency(agency);
		if(list.size()==0) {
			System.out.println(agency +" 항공사에는 찾는 여행상품이 없습니다.");
		} else {
			System.out.println(list);
		}
	}
	
	//모든 여행상품 출력
	public void SearchAll() {
		ArrayList<Product> list = dao.SearchAll();
		for (Product p: list) {
			System.out.println(p);
		}
	}
	
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
