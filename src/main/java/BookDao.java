import java.sql.*;

public class BookDao {
    //klasa będąca pośrednikiem pomiędzy bazą a kodem java

    //dodanie obiekyu do bazy
    public void insert(Book book) {

        Connection connection = connect(); //zainicjalizowalismy metode connect

        PreparedStatement preparedStatement = null;//rządanie do bazy
        try {
            String sql = "INSERT INTO books(title, author, year, isbn) VALUES (?, ?, ?, ?)";//query sql
            preparedStatement = connection.prepareStatement(sql);
            //wstawiamy wartości
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getYear());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.executeUpdate(); //powoduje zmiany w bazie danych

        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }

    public Book findByIsbn(String isbn) {
        Connection connection = connect(); //zainicjalizowalismy metode connect

        PreparedStatement preparedStatement = null;//rządanie do bazy
        try {
            String sql = "SELECT * FROM books WHERE isbn = ?"; //query sql
            preparedStatement = connection.prepareStatement(sql);
            //wstawiamy wartości
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery(); //tworzy zapytanie do bazy i zwraca

            if (resultSet.next()) // jeśli istnieje to przesówam na pierwsze miejsce
            {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int year = resultSet.getInt("year");
                String isbnFromDb = resultSet.getString("isbn");
                // tworze book
                Book book = new Book(id, title, author, year, isbn);
                return book; // zwracamy szukany obiekt
            }
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
        return null;
    }

    public void deleteByIsbn(String isbn) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM books WHERE isbn = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, isbn);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }


    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //tworzenie połączenia z bazą
    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // czytanie sterownika
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC&characterEncoding=utf8"; // można tez do adersu żeby nie używać ssla szyfrowania
        try {
            return DriverManager.getConnection(url, "root", "zioom1"); //połączenie
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Book book) {
        Connection connection = connect(); //zainicjalizowalismy metode connect

        PreparedStatement preparedStatement = null; //rządanie do bazy
        try {
            String sql = "UPDATE books SET title = ?, author = ?, year = ?, isbn = ? WHERE id = ?"; //query sql
            preparedStatement = connection.prepareStatement(sql);
            //wstawiamy wartości
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getYear());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setLong(5, book.getId());
            preparedStatement.executeUpdate(); //powoduje zmiany w bazie danych

        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
            e.printStackTrace();
        }

        closeConnection(connection);
    }

}
