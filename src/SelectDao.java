/*
@author: Divyang Soni
@date : 10/18/2017
@ This class is having database related methods for login application
*/
import java.sql.*;

public class SelectDao {

	public static double getPrice() {
		
		double price = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/prices", "query", "query");
			
			PreparedStatement ps = con.prepareStatement("SELECT price from pricehistory ORDER BY id DESC LIMIT 1");
			// price = "SELECT price from pricehistory ORDER BY id DESC LIMIT 1";
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				price = rs.getDouble(1);
			} else {
				price = 0;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return price;
	}
}