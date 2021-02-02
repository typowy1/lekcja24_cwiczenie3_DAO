import java.util.Scanner;

public class Delete {

//    LibraryDelete – usuń dowolną książkę z bazy danych.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ISBN");
        String isbn = scanner.nextLine();

        BookDao bookDao = new BookDao();
        bookDao.deleteByIsbn(isbn); //metoda usówa po isbn, i musimy to wrzucić w obiekt
        System.out.println("Usunięto"); // wyświeltli informacje o tym jak usunieto
    }
}
