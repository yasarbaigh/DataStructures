package oy.ds.string;

public class StoNum
{

	public static Integer atoInt(String str)
	{
		if(str == null || str.length() == 0)
		{
			throw new RuntimeException("Invalid String");
		}
		int i = 0, len = str.length(), result = 0;
		boolean isNegative = false;
		
		char firstChar = str.charAt(0);
		if(firstChar < '0')
		{
			if(firstChar == '-')			
				isNegative = true;
			
			else if(firstChar != '+')
				throw new RuntimeException("Invalid Sign");
			
			i++;
			if(len == 1)
			{
				throw new RuntimeException("Only Signature");
			}
		} 
		
		while(i<len)
		{
			int digit = str.charAt(i) - '0';
			if(digit < 0 || digit > 9){
				//non-numeric char so return result
				return result;
			}
			result *= 10;
			result += digit;
			i++;
		}
		
		return isNegative? -result: result;		
	}
	
	public static void main(String[] args)
	{
		System.out.println(atoInt("554546"));
	}
}
