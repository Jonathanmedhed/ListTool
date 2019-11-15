package listTool;

import java.util.ArrayList;

public class ListTools {

	
	
	/**
	 * Turn spaces into commas in string
	 * 
	 * @param s
	 * @return
	 */
	public String spaceTo(String s, String sep) {

		s = s.replaceAll("\\s+", sep);

		return s;
	}

	/**
	 * Surround a string with a String
	 * 
	 * @param s
	 * @return
	 */
	public String surroundAllString(String s, String both) {

		s = both + s + both;

		return s;
	}
	
	/**
	 * Surround a string with two different strings
	 * 
	 * @param s
	 * @return
	 */
	public String surroundAllString(String s, String before, String after) {

		s = before + s + after;

		return s;
	}
	
	/**
	 * Surround a string with a char
	 * 
	 * @param s
	 * @return
	 */
	public String surroundAllString(String s, char both) {

		s = both + s + both;

		return s;
	}
	
	/**
	 * Surround a string with two different char
	 * 
	 * @param s
	 * @return
	 */
	public String surroundAllString(String s, char before, char after) {

		s = before + s + after;

		return s;
	}
	/**
	 * Turn array of strings into single linear string
	 * @param list
	 * @return
	 */
	public String arrayToLinear(String[] list) {

		String result = "";

		for (String x : list) {
			result = result + x;
		}

		return result;
	}
	
	/**
	 * Turn array list of strings into single linear string
	 * @param list
	 * @return
	 */
	public String arrayToLinear(ArrayList<String> list) {

		String result = "";

		for (String x : list) {
			result = result + x;
		}

		return result;
	}

	/**
	 * Separates string in spaces into array of strings
	 * 
	 * @param s
	 * @return
	 */
	public String[] spaceToArray(String s) {

		String[] array = s.split("\\s+");

		return array;
	}

	/**
	 * Separates string in the separator string into an array of strings
	 * 
	 * @param s
	 * @return
	 */
	public String[] separatorToArray(String s, String c) {

		String[] array = s.split(c);

		return array;
	}
	
	/**
	 * Separates string in the separator char into an array of strings
	 * 
	 * @param s
	 * @return
	 */
	public String[] separatorToArray(String s, char c) {
		
		String x = ""+c;
		String[] array = s.split(x);

		return array;
	}

	/**
	 * Turn Array of strings into Array List of Strings prefixed with a String
	 * inputed
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> before(String[] array, String s) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(s + x);
		}

		return results;
	}
	
	/**
	 * Turn Array of strings into Array List of Strings prefixed with a String
	 * inputed, adding a separator
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> beforeWithSeparator(String[] array, String s, String separator) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(s + x + separator);
		}

		return results;
	}

	/**
	 * Turn Array of strings into Array List of Strings with a string inputed at the
	 * end
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> after(String[] array, String s) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(x + s);
		}

		return results;
	}
	
	/**
	 * Turn Array of strings into Array List of Strings with a string inputed at the
	 * end, with a separator
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> afterWithSeparator(String[] array, String s, String separator) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(x + s + separator);
		}

		return results;
	}
	

	/**
	 * Turn Array of strings into Array List of Strings with a string inputed at
	 * both ends
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> both(String[] array, String s) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(s + x + s);
		}

		return results;
	}

	/**
	 * Turn Array of strings into Array List of Strings with different strings
	 * inputed at both ends
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> both(String[] array, String first, String last) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(first + x + last);
		}

		return results;
	}
	
	/**
	 * Turn Array of strings into Array List of Strings with a string inputed at
	 * both ends, including a separator
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> bothWithSeparator(String[] array, String s, String separator) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(s + x + s + separator);
		}

		return results;
	}

	/**
	 * Turn Array of strings into Array List of Strings with different strings
	 * inputed at both ends, including a separator
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> bothWithSeparator(String[] array, String first, String last, String separator) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(first + x + last + separator);
		}

		return results;
	}

	/**
	 * Turn Array of strings into Array List of Strings prefixed with a char inputed
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> before(String[] array, char s) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(s + x);
		}

		return results;
	}

	/**
	 * Turn Array of strings into Array List of Strings with a char inputed at the
	 * end
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> after(String[] array, char s) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(x + s);
		}

		return results;
	}

	/**
	 * Turn Array of strings into Array List of Strings with a char inputed at both
	 * ends
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> both(String[] array, char s) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(s + x + s);
		}

		return results;
	}

	/**
	 * Turn Array of strings into Array List of Strings with different chars inputed
	 * at both ends
	 * 
	 * @param array
	 * @return
	 */
	public ArrayList<String> both(String[] array, char first, char last) {

		ArrayList<String> results = new ArrayList<String>();

		for (String x : array) {
			results.add(first + x + last);
		}

		return results;
	}

}
