package com.subscription.controller;

import javax.servlet.http.HttpServlet;

import org.apache.commons.lang.StringUtils;

public class SubscriptionController {

//	public static void main(String[] args) {
//		
//		System.out.println(new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 24));
//		System.out.println(new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 23));
//		System.out.println(new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 4));
//		System.out.println(new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26));
//		System.out.println(new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 30));
//		
//	}
//	
//	@RequestMapping(value="/subscribe" , method = RequestMethod.GET)
//	public String subscribe(HttpServlet request){
//		String orderDetails = getOrderDetails(request);
//		String truncatedOrderDetails = truncate(orderDetails,25);
//		log(truncatedOrderDetails);
//	}
	
	public String truncate(String strInput, int outputLength){
		String truncatedOutputString=null;
		String truncatedPlaceHolderString="... (truncated) ...";
		int lenTruncatedPlaceHolder=truncatedPlaceHolderString.length();
		StringBuffer output=new StringBuffer();
		StringBuffer operationsSB=new StringBuffer();
		
		if(StringUtils.isNotEmpty(strInput) && 
				validateIfInputCanBeTransformed(strInput,outputLength,lenTruncatedPlaceHolder)){
			 
			int endCharacters = ( outputLength - lenTruncatedPlaceHolder ) / 2;
			int remainder = ( outputLength - lenTruncatedPlaceHolder ) % 2;
			
			output.append(strInput.substring(0, endCharacters + remainder));
			output.append(truncatedPlaceHolderString);
			operationsSB.append(strInput).reverse();
			output.append(new StringBuffer().append(operationsSB.toString().substring(0,endCharacters)).reverse());
			truncatedOutputString=output.toString();
			
		}else{
			truncatedOutputString=strInput;
		}
		return truncatedOutputString;
		
	}
	
	private boolean validateIfInputCanBeTransformed(String strInput,int outputLength,int lenTruncatedPlaceHolder){
		return (strInput.length() >= outputLength && (lenTruncatedPlaceHolder + 2) <= outputLength );
	}

	
}
