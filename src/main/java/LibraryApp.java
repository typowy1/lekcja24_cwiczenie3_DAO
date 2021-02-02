import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Dodawanie");
            System.out.println("2. Wyszukiwanie");
            System.out.println("3. Aktualizacja");
            System.out.println("4. Usuwanie");
            System.out.println("0. Koniec");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    Save.main(new String[0]); // uruchamiamymetode z save
                    break;
                case "2":
                    Read.main(new String[0]);
                    break;
                case "3":
                    Update.main(new String[0]);
                    break;
                case "4":
                    Delete.main(new String[0]);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Błędny wybór!");
            }
        }


    }
}
