import java.util.HashMap;

/**
 * 
 */

/**
 * @author LAP-2
 *
 */
public class Test {

	/**
	 * @param args
	 */
	
	
	public int subtract(int first,int second) {
		return first-second;
	}
	
	
	public HashMap<String, String> getData() {
		HashMap<String, String> retrieveData= new HashMap<>();
		String StatusCode="FAIL";
		StatusCode ="SUCCESS";
		retrieveData.put("status", StatusCode);
		retrieveData.put("data", "<html><h1>Some Data</h1></html>");
		return retrieveData;
		
	}
	public static void main(String[] args) {

		
		
		
		
		
		
	}

}
