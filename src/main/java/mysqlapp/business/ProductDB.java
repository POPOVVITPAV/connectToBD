package mysqlapp.business;

import java.sql.*;
import java.util.ArrayList;

public class ProductDB {

		private static String url ="jdbc:mysql://localhost/productdb?serverTimezone=Europe/Moscow&useSSL=false";
		private static String username = "root";
		private static String password = "root";
		
		public static ArrayList<Product> select(){
			
			ArrayList<Product> products = new ArrayList<Product>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
				try(Connection conn = DriverManager.getConnection(url,username,password)){
					Statement statement = conn.createStatement();
					ResultSet resultSet = statement.executeQuery("SLECT * FROM products");
					while(resultSet.next()) {
						int id =resultSet.getInt(1);
						String name = resultSet.getString(2);
						int price = resultSet.getInt(3);
						Product product = new Product(id,name,price);
						products.add(product);
				}
			}
		}
			catch(Exception ex) {
				System.out.println(ex);
			}
			return products;
			
		
		
	}	
	

}
