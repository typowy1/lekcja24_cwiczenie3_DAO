import java.util.Scanner;

public class Read {
    //LibraryRead – wczytaj od użytkownika numer isbn książki i wczytaj na tej podstawie książkę z bazy danych oraz
    // wyświetl informacje o niej w konsoli.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ISBN");
        String isbn = scanner.nextLine();

        BookDao bookDao = new BookDao();
        Book book = bookDao.findByIsbn(isbn); //metoda szuka po isbn, i musimy to wrzucić w obiekt
        System.out.println(book); // wyświeltli informacje o ksązce, potrzebna jest metoda toString
    }
}
