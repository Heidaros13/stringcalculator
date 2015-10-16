package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("," ) || text.contains("\n" )){
			return sum(splitNumbers(text));
		}
		
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    if (numbers.startsWith("//")){
 			String delimeter = numbers.substring(2,3);
 			numbers = numbers.substring(2);
 			numbers = numbers.replaceAll(delimeter,"");
			numbers = numbers.replaceAll("\n","");
			numbers = numbers.replaceAll(",","");
 			return numbers.split("");
	    }
	    return numbers.split("(,|\n)");  
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    if (toInt(number) < 0) {
		    	throw new IllegalArgumentException("Negatives not allowed: " + number);
		    }
		    if (toInt(number) <= 1000){
		    	total += toInt(number);
		    }
		}
		return total;
    }
}