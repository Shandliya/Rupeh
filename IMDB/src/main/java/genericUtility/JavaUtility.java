package genericUtility;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {
		public String getCurrentDate(String strategy, int i) {
			return new SimpleDateFormat(strategy).format(new Date(i));
		}
		/**
		 * To generate randomNumber
		 * @return
		 */
		
		public int getRandomNumber() {
			return new Random().nextInt(100);
		}
}
