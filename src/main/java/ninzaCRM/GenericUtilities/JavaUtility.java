package ninzaCRM.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic method related to Java
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method will capture the current system date in required format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"_"+dArr[3].replace(":", "-");
		return date;
	}
	
	/**
	 * This method will generate random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r= new Random();
		int ranNum = r.nextInt(1000);
		return ranNum;
	}

}
