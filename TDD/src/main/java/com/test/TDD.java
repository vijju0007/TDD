package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TDD {


	int addNumber(String number)
	{
		
		
		int sum=0;
		if(number!=null &&!number.trim().isEmpty())
		{
			
			String delimitor=",";
			String delimitedString[]=  number.split("/");
			if(delimitedString.length>1)
			{
				delimitor=delimitedString[0];
				number=delimitedString[1];
			}
			StringBuilder negativeNumbers=new StringBuilder();
			int count= this.getNegativenumberCount(number,negativeNumbers);
			if(count==1)
			{
				throw new RuntimeException("negative numbers not allowed negative_number");
			}else if(count >1)
			{
				throw new RuntimeException(negativeNumbers.toString()+ " negative numbers found");
			}
			String filteredString = number.replaceAll("\\\\[nrt]", "");
			String arr[]=filteredString.split(delimitor);
			for(String num:arr)
			{

				try {
					sum=sum+Integer.parseInt(num.trim());	
				}catch(Exception ex)
				{

				}

			}

			return sum;
		}
		else
			return sum;

	}
	
	 private static int getNegativenumberCount(String input,StringBuilder negativeNumbers) {
	        
	        String regex = "-?\\d+(\\.\\d+)?";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(input);

	        int count = 0;
	        while (matcher.find()) {
	           
	            double number = Double.parseDouble(matcher.group());
	            if (number < 0) {
	                count++;
	                negativeNumbers.append(number).append(",");
	            }
	        }

	        return count;
	    }
	 


}
