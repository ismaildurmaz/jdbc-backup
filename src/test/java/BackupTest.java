import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.intenum.jdbc.backup.Backup;

public class BackupTest {
	@Test
	public void fetchTablesAndColumns() throws ClassNotFoundException,
			SQLException {
		
		/**
		 * You must define a valid jdbc connection !!!!!
		 */
		Backup backup = new Backup(null);
		
		
		print("Backup start time : " + new Date().toString());
		backup.execute(System.out);
		print("Backup end time : " + new Date().toString());
	}

	private void print(Object message) {
		System.out.println(message);
	}
}
