import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcTest {

	// DRIVER SEARCH, DB CONNECT -> MAKE CONNECTION
	public static void main(String[] args) {

		// Connection
		// DriverManager
		// SQLException,

		
		// DRIVER SEARCH
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

			String db_id = "service";
			String db_pw = "12345";

			DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB CONNECT -> MAKE CONNECTION

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe"
					,"service", "12345"
					);
			System.out.println("CONNECT SUCCESS");
		} catch (SQLException e) {
			System.err.println("CONNECT FAIL");
			System.exit(0);
		}
		try {
			if( conn != null) {
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		/*
		 * Connection conn = null; try {
		 * 
		 * 
		 * } catch(SQLException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 */
	}

}