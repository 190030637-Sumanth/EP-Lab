package p1;
import java.sql.SQLException;
import java.util.*;
public class MainClass {

	public static void main(String[] args) throws SQLException {
		Scanner s =new Scanner(System.in);
        Bean b = new Bean();
        DAO d = new DAO();
        while(true)
        {
        	System.out.println("type 1 to insert");
        	System.out.println("type 2 to display");  
        	System.out.println("type 3 to exit");
        	int choice;        	
            choice=s.nextInt();
        	switch(choice)
        	{
        	case 1:System.out.println();
        		System.out.println("enter item name:");
        	        String name=s.next();
        	        System.out.println("enter cost");
        	        float cost=s.nextFloat();
        	        b.setCost(cost);
        	        b.setItemName(name);
        	        d.insert(b);
        	        break;
        	case 2:d.Display();
        	       break;
        	case 3:System.exit(0);
        	      
        	default:System.out.println("enter number in between 1,2,3");
        	}
        }
	}

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}

}
