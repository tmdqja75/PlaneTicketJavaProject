import Package.PackageService;
import java.util.Scanner;

public class Menu {
    private PackageService packservice;

    public Menu() {
        packservice = new PackageService();
    }

    public void run(Scanner sc) {
        boolean flag = true;
        int m = 0;
        while (flag) {
            System.out.println("1. 상품 추가, 2. 상품 수정, 3. 종료");
            m = sc.nextInt();
            switch (m) {
                case 1:
                    packservice.addPackage(sc);
                    break;
                case 2:
                    runEditPackage(sc);
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }

    public void runEditPackage(Scanner sc) {
        boolean flag = true;
        int m = 0;
        while (flag) {
            System.out.println("1. 출발 항공편 수정, 2. 도착 항공편 수정 3. 여행사 수정, 4. 설명 수정, 5. 호텔 여부 수정, 6. 해외 여부 수정, 7. 가격 수정 8. 종료");
            m = sc.nextInt();
            switch (m) {
                
                case 1:
                    packservice.editDepartflight(sc);
                    break;
                case 2:
                    packservice.editArriveflight(sc);
                    break;
                case 3:
                    packservice.editAgency(sc);
                    break;
                case 4:
                    packservice.editManual(sc);
                    break;
                case 5:
                    packservice.editHotel(sc);
                    break;
                case 6:
                    packservice.editType(sc);
                    break;
                case 7:
                    packservice.editPrice(sc);
                    break;
                case 8:
                    flag = false;
                    break;
            }
        }
    }
}