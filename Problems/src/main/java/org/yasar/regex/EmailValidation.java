package org.yasar.regex;


public class EmailValidation
{
	
	/*
	 * 
Email condition

If you look at the Wikipedia article for valid email address it supports a lot of special characters but to cover most of the valid
 email addresses, I am assuming an email address to consist of characters, digits and special characters +, – , . and _. Also every
 email address must contain only one @ symbol.

For the domain name, we can have subdomains also. So a subdomain can contain characters, digits and special characters – and _. 
Again subdomain can be of multiple levels like xyz.abc.com. So middle level TLDs must start with . (DOT) and it can contain 
characters, digits and special characters – and _. The last TLD should be of minimum length 2 and can contain words only.


Invalid emails:

journaldev – No @ symbole
journaldev@.com.my – Dot after @ symbol
journaldev123@gmail.a – last TLD length is less than 2
journaldev123@@.com.com – Two @ symbols
.journaldev@journaldev.com – ID can’t start with .
journaldev()*@gmail.com – invalid special characters in the ID
journaldev@%*.com – invalid special characters in the TLD
journaldev..2002@gmail.com – ID can’t have two dots
journaldev.@gmail.com – ID can’t end with dot
journaldev@journaldev@gmail.com – Two @ symbols
journaldev@gmail.com.1a – last TLD can have characters only


 
	 * 
	 */
	public static void main(String[] args)
	{
		String[] passEmails= {
				
				"journaldev@yahoo.com",
				"+journaldev@yahoo.com",
				"-journaldev@yahoo.com",
				"1journaldev123@gmail.aabc",
				"journaldev-100@yahoo.com",
				"journaldev.100@yahoo.com",
				"journaldev111@journaldev.com",
				"journaldev-100@journaldev.net",
				"journaldev.100@journaldev.com.au",
				"journaldev@1.com",
				"journaldev@gmail.com.com",
				"journaldev+100@gmail.com",
				"journaldev-100@yahoo-test.com",
				"journaldev_100@yahoo-test.ABC.CoM",
		};
		
		String[] failEmails= {
				"journaldev",
				"journaldev@.com.my",
				"journaldev123@gmail.a",
				
				"journaldev123@@.com.com",
				".journaldev@journaldev.com",
				"journaldev()*@gmail.com",
				"journaldev@%*.com",
				"journaldev..2002@gmail.com",
				"journaldev.@gmail.com",
				"journaldev@journaldev@gmail.com",
				"journaldev@gmail.com.1a"
		};
		

		String regex = "";
		
		//regex for first character should not be a number
		//regex = "^[a-zA-Z_\\+-][\\w\\+-]+(\\.[\\w\\+-])*@(.*)$";
		
		
		//regex failed to validate 2 dots should not come together
		//regex = "^[\\w\\+-]+[\\w\\+-\\.]*@[\\w-]+[\\w\\+-\\.]*(\\.[a-zA-Z]{2,4})$";
		
		//checks for non existence of 2 continous dots
		regex = "^[\\w\\+-]+(\\.[\\w\\+-]+)*@[\\w-]+(\\.[\\w\\+-]+)*(\\.[a-zA-Z]{2,4})$";
		
		
		
		//actual regex,
		//(\\.[\\w]+)* validates that there should not 2 dots(.) continous
		//[\\w\\+-\\.]* this wont do the above
		//regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$";
		for (int i = 0; i < passEmails.length; i++) 
		{
			if(passEmails[i].matches(regex))
			{
				System.out.println(passEmails[i] + " Regex-Passed");
			}
			else
			{
				System.out.println(passEmails[i] + " Regex-Failed");			
			}
		}
		System.out.println("----------------------------------------------------");
		for (int i = 0; i < failEmails.length; i++) 
		{
			if(failEmails[i].matches(regex))
			{
				System.out.println(failEmails[i] + " Regex-Passed");
			}
			else
			{
				System.out.println(failEmails[i] + " Regex-Failed");			
			}
		}		
	}
}
