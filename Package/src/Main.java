import java.util.Scanner;

//날짜 관련
// import java.util.Date;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu m = new Menu();
		m.run(sc);




		// String a = "12-12-2018";
		// String b = "12-16-2018";

		// SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy");  
		// Date date1;
		// try {
		// 	date1 = obj.parse(a);
		   
        // Date date2 = obj.parse(b);  
		// long time_difference = date2.getTime()-date1.getTime();
		// long days_difference = (time_difference / (1000*60*60*24)) % 365; 

		// System.out.println(days_difference+ "days");
		// } catch (ParseException prs){
		// 	prs.printStackTrace();
		// }
		// sc.close();
	}
}
