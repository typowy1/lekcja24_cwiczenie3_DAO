import java.util.Scanner;

public class Save {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł");
        String title = scanner.nextLine();

        System.out.println("Podaj autora");
        String author = scanner.nextLine();

        System.out.println("Podaj rok wydania");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj ISBN");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, year, isbn);
        BookDao bookDao = new BookDao();
        bookDao.insert(book); //metoda insert dodaje obiekt do bazy danych
    }
}
