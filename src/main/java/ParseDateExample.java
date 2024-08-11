import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParseDateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        String dateString = "2023-07-10";
		        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
		        System.out.println(date); // Output: 2023-07-10
		        
		        String str="Ajay";
		        int i2=Integer.parseInt(str);
		        System.out.println(i2);
		    
		
	
	}

}
