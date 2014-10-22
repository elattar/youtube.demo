
// check
// abstract all functions
// inheritance 
// es2al el DR

public abstract class ITDisaster {
	protected String Name;	
	protected String Date, Place, Description;
	
	/**
	 * This class is an example for ITDisaster catalogue 
	 * Software Engineering, 1st term third year 2014
	 * It represents a Disaster and has one data field (Name) 
	 * @author Abdelrahman Mostafa El-Attar 20120234
	 * @version 1.00 07/10/2014
	 */
	
	//////////////////////////Constructors ///////////////////////////////
	public ITDisaster()
	{
		Name  = "";
		Place = "";
		Date  = "";
		Description = "";
	}
	public ITDisaster(String Name)
	{
		this.Name = Name;
	}
	public ITDisaster(String name,String date, String place )
	{
		this.Name = name;
		this.Date = date;
		this.Place = place;	
	}
	
	//////////////////////////Setters & Getters ////////////////////////
	/** The setName method assigns a given value to Name 
     * @param name The value to set the Name data field to */
	public void setName(String name)
	{
		Name = name;
	}
	
	/** The getName method returns the value of the Name
     * @return returns the value of Name */
	public String getName()
	{
	    return Name;
	}
	/** The setDate method assigns a given value to Date 
	  * @param date The value to set the Date data field to */
	public void setDate(String date)
	{
		Date = date;
	}
	
	/** The setPlace method assigns a given value to Place 
	  * @param place The value to set the Place data field to */
	public void setPlace(String place)
	{
		Place = place;
	}
	
	/** The setDescription method assigns a given value to Description 
	  * @param desc The value to set the Description data field to */
	public void setDescription(String desc)
	{	
		Description = desc;
	}
	
	/** The getDate method returns the value of the Date
	  * @return returns the value of Date */
	public String getDate()
	{
		return Date;
	}
	
	/** The getDate method returns the value of the Date
	  * @return returns the value of Date */	
	public String getPlace()
	{
		return Place;
	}
	
	/** The getDescription method returns the value of the Description
	  * @return returns the value of Description */
	public String getDescription()
	{
		return Description;
	}
	
	//////////////////////////Methods ////////////////////////////////////
	/** The ReadFromFile method reads from the file */
	abstract public void ReadFromFile();	//abstract
	/** The WriteToFile method writes into the file */
	abstract public void WriteToFile(String name);
	/** The SearchInFile method searches in the file */
	abstract public void SearchInFile(String name);
	

}
