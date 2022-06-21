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
            System.out.println("1. 추가, 2. 항공편 수정");
            m = sc.nextInt();
            switch(m) {
                case 1:
                    packservice.addPackage(sc);
                    break;
                case 2:
                    packservice.editFlight(sc);
            }
        }
    }
}