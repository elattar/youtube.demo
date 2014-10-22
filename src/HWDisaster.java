import java.util.*;
import java.io.*;


public class HWDisaster extends ITDisaster
{

	Scanner in = new Scanner(System.in);
	File file  = new File("CatalogHW.txt"); //specify filename and location
	
	/**
	 * This class is an example for HWDisaster catalogue 
	 * Software Engineering, 1st term third year 2014
	 * It represents a Disaster and has three data fields (Date, Place, Description) 
	 * @author Abdelrahman Mostafa El-Attar 20120234
	 * @version 1.00 07/10/2014
	 */
	
	//////////////////////////Constructors ///////////////////////////////
	public HWDisaster()
	{}
	
	public HWDisaster(String name, String date, String place )
	{
		super(name,date,place);
		System.out.printf("The HW Constructor %s" , this);
		System.out.println("");
	}
	
	//////////////////////////Setters & Getters ////////////////////////
	
	//////////////////////////Methods ////////////////////////////////////
	/** The toString method to change the format of the output*/
	public String toString()
	{
		return String.format("%s %s %s", Name, Date ,Place);
	}
	
	/** The WriteToFile method writes to the file
	 *@param name the name of the HW disaster to wrtie to the file
	 */
	public void WriteToFile(String name)
	{
		try {
			
			//check whether file exists or not
			if(!file.exists()){
		    	   file.createNewFile();
		    	}
			/*
			  	PrintWriter(OutputStream out, boolean autoFlush) 
				to force to write what in memory to the file with println
				BufferedWriter ---> to give better performance
				and append at the end of file
			 */
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			
			/*
			 	from here start to write in file the name of the disaster
			 	and its place, Date, and Description.
			 */
			
			fout.write("Name: "); fout.write(name); fout.println("");
			
			// i used nextLine to take whole line until clicking enter
			System.out.print("Enter Place: ");
			Place = in.nextLine();
			
			fout.write("Place: "); fout.write(Place); fout.println("");
			
			System.out.print("Enter Date: ");
			Date = in.nextLine();
			
			fout.write("Date: "); fout.write(Date); fout.println("");
			
			System.out.print("Enter Description: ");
			Description = in.nextLine();
			
			fout.write("Description: "); fout.write(Description); fout.println();
			
			fout.write(",");
			//fout.flush(); i'm already using true in parameter to automatically flush
		    fout.close();

		}catch (IOException e) 
			{
				System.out.println("Write Exception occurred");
				e.printStackTrace();
			}
			
	}
	
	/** The ReadFromFile method reads from the file */
	public void ReadFromFile()
	{
		
		try {
			
			FileReader read = new FileReader(file); // to reach file
			
			/* 
			 	create variable temp to save the whole line in file 
			 	and keep reading until reaching the end of file
			 */

			Scanner src = new Scanner(read); // to read 
		    src.useDelimiter(",");
		    System.out.println("\t\t...Reading from 'HW' File ....");
		    
		    while (src.hasNext()) 
		    {
		    	String temp = src.next();
		    	System.out.println(temp);		    	
		    }
			 
		    read.close();
		    src.close();
		}catch (IOException e) 
		{
			System.out.println("Write Exception occurred");
			e.printStackTrace();
		}
	}
	
	/** The SearchInFile method searches in the file with parameter name*/
	public void SearchInFile(String name)

	{
		try {			
			
			if(file.exists() && !file.isDirectory())
			{
				Scanner scanner = new Scanner(file); // to get from file
				boolean check = false;
				
				/*
				 * while loop its parameter check do file contain another line or not
				 * if true will continue reading each line and save it in line
				 * then it checks the line does it contain the name of disaster or not 
				 * if yes it prints the name and all information until the delimiter ','
				 * and make check equals true
				 */
				while (scanner.hasNextLine()) 
				{
					String line = scanner.nextLine();
					
					if(line.contains(name)) 
					{
						System.out.println("Name: " + name);
						
						scanner.useDelimiter(",");	
						
						String temp = scanner.next();
						System.out.println(temp);
						check = true;
						//break;
					}
				}
				/*
				 * if check equals false that means name doesn't exist in file
				 * and start write it to file
				 */
				if (check == false)
				{
					System.out.println("Name doesn't exist in file Do you want to add it ...");
					System.out.println("Enter Yes Or No ?");
					String res = "";
					res = in.nextLine();
					
					if (res.equals("yes") || res.equals("YES"))
					{
						this.WriteToFile(name);
					}
					else if (res.equals("no") || res.equals("NO"))
					{
						System.exit(0);
					}
				}
				
				scanner.close();
			}
			else
			{
				file.createNewFile();
			}
	}catch (IOException e) 
		{
			System.out.println("Search Exception occurred");
			e.printStackTrace();
		}
		
	}
	
	
}

