import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	final String URL = "jdbc:mysql://localhost:3306/javaweb?serverTimezone=GMT";//在jdbc连接的url后面加上serverTimezone=GMT即可解决数据库和系统时区差异问题。
	final String USERNAME = "root";
	final String PWD = "admit";
	public void upDate() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("加载驱动成功");
		Connection connection = DriverManager.getConnection(URL, USERNAME, PWD);
		System.out.println("连接数据库成功");
		Statement stmt = connection.createStatement();
		System.out.println("创建语句成功");
		String sql = "create table test2 (name varchar(20))";
		stmt.execute(sql);
		System.out.println("建表成功");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		connection jdbc = new connection();
		jdbc.upDate();
	}

}
