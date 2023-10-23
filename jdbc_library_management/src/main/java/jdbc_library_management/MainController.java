package jdbc_library_management;

import java.util.Scanner;

public class MainController {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		User user = new User();
		Book book = new Book();
		UserCrud crud = new UserCrud();
		BookCrud bookCrud=new BookCrud();

		System.out.println("Library Managment System\nWhat do you want?\n1. Sign Up\n2. Login");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter the Name:");
			String name = scanner.next();
			System.out.println("Enter the Email:");
			String email = scanner.next();
			System.out.println("Enter the Phone:");
			long phone = scanner.nextLong();
			System.out.println("Enter the Password:");
			String password = scanner.next();

			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setPhone(phone);
			crud.signUp(user);
			break;
		}

		case 2: {
			System.out.println("Enter the Email:");
			String email = scanner.next();
			System.out.println("Enter the Password:");
			String password = scanner.next();

			user.setEmail(email);
			user.setPassword(password);

			Boolean result = crud.login(user);
			if (result) {
				System.out.println("Login Success...");
				boolean flag=true;
				while(flag) {
					System.out.println("What do you want\n1.  Add Book\n2.  Show All Book Details\n3.  Find Book by ID\n4.  Find Book by Name\n5.  Find Book by Author Name");
					System.out.println("6.  Find Book by Genre\n7.  Update Book by ID\n8.  Delete Book by Genre\n9.  Delete Book by Author Name\n10. Delete Book by ID\n11. Delete Book by Name");
					int key=scanner.nextInt();
					switch (key) {
					case 1:{
						System.out.println("Enter the book id");
						int id=scanner.nextInt();
						System.out.println("Enter the Book Name:");
						String name = scanner.next();
						System.out.println("Enter the Author Name:");
						String author = scanner.next();
						System.out.println("Enter the Price:");
						double price = scanner.nextDouble();
						System.out.println("Enter the Genre:");
						String genre = scanner.next();
						
						book.setId(id);
						book.setName(name);
						book.setAuthor(author);
						book.setPrice(price);
						book.setGenre(genre);
						
						bookCrud.addBook(book);
						
						break;
					}
					case 2:{
						bookCrud.showBookAll(book);
						break;
					}
					case 3:{
						System.out.println("Enter the Book ID:");
						int id = scanner.nextInt();
						
						book.setId(id);
						
						bookCrud.findByID(id);
						break;
					}
					case 4:{
						System.out.println("Enter the Book Name:");
						String name = scanner.next();
						
						book.setName(name);
						bookCrud.findByName(name);
						break;
					}
					case 5:{
						System.out.println("Enter the Author Name:");
						String author = scanner.next();
						
						book.setAuthor(author);
						bookCrud.findByAuthorName(author);;
						break;
					}
					case 6:{
						System.out.println("Enter the Genre:");
						String genre = scanner.next();
						
						book.setGenre(genre);
						bookCrud.findByGenre(genre);
						break;
					}
					case 7:{
						System.out.println("Enter the Book ID:");
						int id=scanner.nextInt();
						System.out.println("Enter the Book Name:");
						String name = scanner.next();
						System.out.println("Enter the Author Name:");
						String author = scanner.next();
						System.out.println("Enter the Price:");
						double price = scanner.nextDouble();
						System.out.println("Enter the Genre:");
						String genre = scanner.next();
						
						book.setId(id);
						book.setName(name);
						book.setAuthor(author);
						book.setGenre(genre);
						book.setPrice(price);
						
						bookCrud.updateBook(book);
						break;
					}
					case 8:{
						System.out.println("Enter the Genre:");
						String genre = scanner.next();
						
						book.setGenre(genre);
						bookCrud.deleteByGenre(genre);
						break;
					}
					case 9:{
						System.out.println("Enter the Author Name:");
						String author = scanner.next();
						
						book.setAuthor(author);
						bookCrud.deleteByAuthor(author);
						break;
					}
					case 10:{
						System.out.println("Enter the Book ID:");
						int id=scanner.nextInt();
						book.setId(id);
						
						bookCrud.deleteByID(id);
						break;
					}
					case 11:{
						System.out.println("Enter the Book Name:");
						String name = scanner.next();
						
						book.setName(name);
						
						bookCrud.deleteByName(name);
						break;
					}
					default:
						System.out.println("Wrong Input!!");
						break;
					}
					System.out.println("Do you want continue\n1. Yes\n2. No");
					int key2=scanner.nextInt();
					if(key2==2) {
						flag=false;
					}
				}
				System.out.println("Thank You :)");
			} 
			else {
				System.out.println("Login Faild...");
			}
			break;
		}

		default:
			break;
		}
	}

}
