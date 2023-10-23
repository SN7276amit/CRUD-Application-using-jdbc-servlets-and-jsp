package jdbc_library_management;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UserCrud {

	public Connection getConnection() throws Exception {

		FileInputStream fileInputStream = new FileInputStream("libraryconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		return connection;
	}

	public void signUp(User user) throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER(ID,NAME,PHONE,EMAIL,PASSWORD) values(?,?,?,?,?)");
        preparedStatement.setInt(1,user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getPassword());

		int result = preparedStatement.executeUpdate();

		if (result != 0) {
			System.out.println("SignUp successfully");

		} else {
			System.out.println("Invalid !!!!");
		}

		connection.close();
	}

	public boolean login(User user) throws Exception {

		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("select password from user where email=?");
		preparedStatement.setString(1, user.getEmail());

		ResultSet resultSet = preparedStatement.executeQuery();
		;

		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		if (user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}

	}
}
