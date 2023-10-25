package library_manegement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManegementSystemUI {
	private LibrarySystem librarySystem = new LibrarySystem();

	public void start() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1) Add Book In Library");
			System.out.println("2) Get All Bookes Present in Library");
			System.out.println("3) Find Book By Id");
			System.out.println("4) Submit Book By Id");
			System.out.println("5) Exit the Library");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: {
				System.out.println("Enter the Book name");
				String book_name = sc.nextLine();
				System.out.println("Enter The Author Name");
				String author_name = sc.nextLine();
				System.out.println("Enter Price Of the Book");
				int cost = sc.nextInt();
				System.out.println("Enter the Numbers Of Books");
				int numberOfBooks = sc.nextInt();
				sc.nextLine();

				Library library = librarySystem.saveBook(book_name, author_name, cost, numberOfBooks);
				System.out.println("Book Added SuccessFully By Id Number :" + library.getbook_id());
				System.out.println("------------------------------------------------");

			}
				break;
			case 2: {
				System.out.println("All Books Presnt");
				for (Library library : librarySystem.getAllBooksList()) {
					System.out.println(library.getbook_id()+"   "+library.getBook_name() + " - " + library.getAuthor_name() + " - "
							+ library.getCost() + " - " + library.getNumberOfBooks());
				}
				System.out.println("-----------------------------------------------");

			}
				break;
			case 3: {
				System.out.println("Enter Book Id to be Found");
				int book_id = sc.nextInt();
				sc.nextLine();

				if (librarySystem.getBookById(book_id) != null) {
					Library library= librarySystem.getBookById(book_id);
						System.out.println(library.getBook_name() + " - " + library.getAuthor_name() + " - "
								+ library.getCost() + " - " + library.getNumberOfBooks());
					
				
			}}
				break;

			case 4: {
				System.out.println("Enter the Book Id To be Submited");
				int book_id = sc.nextInt();
				sc.nextLine();
				if (librarySystem.BookSubmitedById(book_id)) {
					System.out.println("Book SUbmited Successfully....");
				} else {
					System.out.println("Book not submited");
				}

			}
				break;

			case 5: {
				System.out.println("Thankyou for Your Apperarence");
				return;

			}

			default:

				throw new IllegalArgumentException("Please Enter Valid Input"+choice);

			}
		}
	}

	public static void main(String[] args) {
		LibraryManegementSystemUI systemUI = new LibraryManegementSystemUI();
		systemUI.start();

	}

}

class Library {
	private int book_id;
	private String book_name;
	private String author_name;
	private int cost;
	private int numberOfBooks;

	public Library(int book_id, String book_name, String author_name, int cost, int numberOfBooks) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.author_name = author_name;
		this.cost = cost;
		this.numberOfBooks = numberOfBooks;
	}

	public int getbook_id() {
		return book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public int getCost() {
		return cost;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

}

class LibrarySystem {

	List<Library> libraries = new ArrayList<>();
	int nextId = 1;

	public Library saveBook(String book_name, String author_name, int cost, int numberOfBooks) {
		Library library = new Library(nextId++, book_name, author_name, cost, numberOfBooks);
		libraries.add(library);
		return library;
	}

	public List<Library> getAllBooksList() {
		return libraries;
	}

	public Library getBookById(int id) {
		for (Library library : libraries) {
			if (library.getbook_id() == id) {
				return library;
			}
		}
		return null;

	}

	public boolean BookSubmitedById(int id) {
		Library library = getBookById(id);
		if (library != null) {
			libraries.remove(id);
			return true;
		}
		return false;

	}

}
