package jdbc_library_management;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BookCrud {

	public Connection getConnection() throws Exception {

		FileInputStream fileInputStream = new FileInputStream("libraryconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		return connection;
	}

	public void addBook(Book book) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BOOK VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, book.getId());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setString(3, book.getAuthor());
		preparedStatement.setDouble(4, book.getPrice());
		preparedStatement.setString(5, book.getGenre());

		int result = preparedStatement.executeUpdate();
		
		if(result!=0) {
			System.out.println("Book Details Saved....");
		}
		else {
			System.out.println("Somthing Wrong....\n Try again");
		}
		connection.close();
	}

	public void showBookAll(Book book) throws Exception  {
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK");
		
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) {
			ResultSet resultSet1= preparedStatement.executeQuery();
			while (resultSet1.next()) {
					System.out.println("ID: "+resultSet1.getInt("id"));
					System.out.println("Name: "+resultSet1.getString("name"));
					System.out.println("Author: "+resultSet1.getString("author"));
					System.out.println("Price: "+resultSet1.getDouble("price"));
					System.out.println("Genre: "+resultSet1.getString("genre"));
					System.out.println("------------------------------");
					
			}

		}
		else {
			System.out.println("No Data Found...");
		}
		connection.close();
		
	}

	public void findByID(int id) throws Exception {
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE ID=?");
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) {
			ResultSet resultSet1= preparedStatement.executeQuery();
			while (resultSet1.next()) {
					System.out.println("Name: "+resultSet1.getString("name"));
					System.out.println("Author: "+resultSet1.getString("author"));
					System.out.println("Price: "+resultSet1.getDouble("price"));
					System.out.println("Genre: "+resultSet1.getString("genre"));
					System.out.println("------------------------------");
					
			}

		}
		else {
			System.out.println("No Data Found...");
		}
		connection.close();
		
	}

	public void findByName(String name) throws Exception {
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE NAME=?");
		preparedStatement.setString(1, name);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) {
			ResultSet resultSet1= preparedStatement.executeQuery();
			while (resultSet1.next()) {
					System.out.println("Name: "+resultSet1.getString("name"));
					System.out.println("Author: "+resultSet1.getString("author"));
					System.out.println("Price: "+resultSet1.getDouble("price"));
					System.out.println("Genre: "+resultSet1.getString("genre"));
					System.out.println("------------------------------");
					
			}

		}
		else {
			System.out.println("No Data Found...");
		}
		connection.close();
		
	}

	public void findByAuthorName(String author) throws Exception {
		
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT* FROM BOOK WHERE AUTHOR=?");
		preparedStatement.setString(1, author);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) {
			ResultSet resultSet1= preparedStatement.executeQuery();
			while (resultSet1.next()) {
					System.out.println("Name: "+resultSet1.getString("name"));
					System.out.println("Author: "+resultSet1.getString("author"));
					System.out.println("Price: "+resultSet1.getDouble("price"));
					System.out.println("Genre: "+resultSet1.getString("genre"));
					System.out.println("------------------------------");
					
			}

		}
		else {
			System.out.println("No Data Found...");
		}
		connection.close();
	}

	public void findByGenre(String genre) throws Exception {
		
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE GENRE=?");
		preparedStatement.setString(1, genre);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) {
			ResultSet resultSet1= preparedStatement.executeQuery();
			while (resultSet1.next()) {
					System.out.println("Name: "+resultSet1.getString("name"));
					System.out.println("Author: "+resultSet1.getString("author"));
					System.out.println("Price: "+resultSet1.getDouble("price"));
					System.out.println("Genre: "+resultSet1.getString("genre"));
					System.out.println("------------------------------");
					
			}

		}
		else {
			System.out.println("No Data Found...");
		}
		connection.close();
		
	}

	public void updateBook(Book book) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE BOOK SET NAME=?,AUTHOR=?,PRICE=?,GENRE=? WHERE ID=?");
		preparedStatement.setString(1, book.getName());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setDouble(3, book.getPrice());
		preparedStatement.setString(4, book.getGenre());
		preparedStatement.setInt(5, book.getId());
		
		int result=preparedStatement.executeUpdate();
		if(result!=0) {
			System.out.println("Book Information Updated...");
		}
		else {
			System.out.println("Book Information not Updated...");
		}
		connection.close();
		
	}

	public void deleteByGenre(String genre) throws Exception {
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM BOOK WHERE GENRE=?");
		preparedStatement.setString(1, genre);
		
		int result=preparedStatement.executeUpdate();
		if(result!=0) {
			System.out.println("Book Information Deleted...");
		}
		else {
			System.out.println("Book Information not Deleted...");
		}
		connection.close();
	}

	public void deleteByAuthor(String author) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM BOOK WHERE AUTHOR=?");
		preparedStatement.setString(1, author);
		
		int result=preparedStatement.executeUpdate();
		if(result!=0) {
			System.out.println("Book Information Deleted...");
		}
		else {
			System.out.println("Book Information not Deleted...");
		}
		connection.close();
		
	}

	public void deleteByID(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM BOOK WHERE ID=?");
		preparedStatement.setInt(1, id);
		
		int result=preparedStatement.executeUpdate();
		if(result!=0) {
			System.out.println("Book Information Deleted...");
		}
		else {
			System.out.println("Book Information not Deleted...");
		}
		connection.close();
		
	}

	public void deleteByName(String name) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM BOOK WHERE NAME=?");
		preparedStatement.setString(1, name);
		
		int result=preparedStatement.executeUpdate();
		if(result!=0) {
			System.out.println("Book Information Deleted...");
		}
		else {
			System.out.println("Book Information not Deleted...");
		}
		connection.close();
		
	}

}
