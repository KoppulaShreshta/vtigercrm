package genericlibraries;


	
	import java.text.SimpleDateFormat;
	/**
	 * this class contains reusable methods to perform java related operations
	 */
	import java.util.Date;
import java.util.Random;


	public class JavaUtility {
		/**
		 * This method is used to generate random number within specified limit
		 * @param limit
		 * @return
		 */
		
		public int generateRandomNum(int limit) {
			Random random=new Random();
			return random.nextInt(limit);
		}
		/**
		 * this method fethches current data and time in specified format
		 * @return
		 */
		public String getCurrentTime() {
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_mm_ss");
			return sdf.format(date);
			
			
			
		}

	}


