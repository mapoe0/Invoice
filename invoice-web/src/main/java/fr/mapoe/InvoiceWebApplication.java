package fr.mapoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class InvoiceWebApplication {

	public static void main(String[] args)
	{
		ApplicationContext context =  SpringApplication.run(InvoiceWebApplication.class, args);
/*		DataSource ds = context.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			System.out.println("connection success");
			String query = "SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE";
			ResultSet rs = conn.createStatement().executeQuery(query);
			while (rs.next()){
				System.out.println(rs.getLong("INVOICE_NUMBER")+" | "+rs.getString("CUSTOMER_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try{
				if (conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	}

}
