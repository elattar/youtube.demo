import java.util.Scanner;

public class Application {
	/**
	 * This class is the main class to run from it. 
	 * Software Engineering, 1st term third year 2014
	 * @author Abdelrahman Mostafa El-Attar 20120234
	 * @version 1.00 07/10/2014
	 */
	public static void main(String[] args)
	{		
		Scanner cin = new Scanner(System.in);		
		
		String dep = "";
		do {
			ITDisaster Dis ;	
			
			System.out.println("\t\t\t***** Welcome To Our Program *****");
			System.out.println("Enter 'SW' to search in Software Disasters");
			System.out.println("Enter 'HW' to search in Hardware Disasters");
			System.out.println("Enter 'str' to check String function ");
			System.out.println("Enter 'read' to read all file");
			System.out.println("Enter exit to close the program");
			dep = cin.nextLine();
			
			System.out.println(dep);
			
			if(dep.equals("SW") || dep.equals("sw") )
			{
				Dis = new SWDisaster();
				String disaster;
				System.out.print("Enter name please: ");
				disaster = cin.nextLine();
				Dis.SearchInFile(disaster);
			}
			
			else if(dep.equals("HW") || dep.equals("hw") )
			{				
				Dis = new HWDisaster();
				String disaster;
				System.out.print("Enter name please: ");
				disaster = cin.nextLine();
				Dis.SearchInFile(disaster);				
			}
			
			else if (dep.equals("str"))
			{
				SWDisaster dis1 = new SWDisaster("Mariner" , "1962" , "America" );
				
				HWDisaster dis2 = new HWDisaster("Medical Machine Kills" , "1985" , "canada");
				
			}
			
			else if (dep.equals("read"))
			{
				
				ITDisaster Dis1 = new SWDisaster();
				Dis1.ReadFromFile();
				ITDisaster Dis2 = new HWDisaster();
				Dis2.ReadFromFile();
			}
			
			else if (dep.equals("exit"))
			{
				System.exit(0);	
			}
				
			else
			{
				System.out.println("Please check your entry");
				System.out.println("Enter 'SW' to search in Software Disasters");
				System.out.println("Enter 'HW' to search in Hardware Disasters");
				System.out.println("Enter 'str' to check String function ");
				System.out.println("Enter 'count' to return number of disasters in 'SW' & 'HW'");
				System.out.println("Enter exit to close the program");
			}
			
		}while (!dep.equals("exit"));
		cin.close();		
	
	}
}
