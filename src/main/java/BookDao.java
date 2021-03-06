import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookDao {

    private static final String URL = "jdbc:mysql://localhost:3306/library?characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    private Connection connection;

    public BookDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Book book)throws InputMismatchException {
        final String query = "INSERT INTO library.books SET title = ?, author = ?, year = ?, isbn = ?";

        try {
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setString(2, book.getAuthor());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setInt(4, book.getIsbn());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }catch (InputMismatchException e){
            System.out.println("Wrong type");
            e.printStackTrace();
        }
    }

    public String read(Book book) throws SQLException{
        final String sql = "select ID, title, author, year,isbn from library.books where id = ?";
        System.out.println("podaj id ksiazki ktora chcesz wyswietlić");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                book.setID(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setYear(result.getInt(4));
                book.setIsbn(result.getInt(5));
                System.out.println(book.toString());
                return book.toString();
            }
        } catch (SQLException e) {
            System.out.println("Could not get employee");
        }
        return "nie znaleziono pozycji o podanym ID";
    }

    public void update(Book book) {
        Scanner scanner = new Scanner(System.in);

        final String sql = "update library.books set title=?, author=?, year=?, isbn = ? where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            System.out.println("podaj ID ksiazki do edycji");
            prepStmt.setInt(5, scanner.nextInt());
            scanner.nextLine();
            System.out.println("podaj tytul: ");
            prepStmt.setString(1, scanner.nextLine());
            System.out.println("podaj autora");
            prepStmt.setString(2, scanner.nextLine());
            System.out.println("podaj rok wydania");
            prepStmt.setInt(3, scanner.nextInt());
            System.out.println("podaj nr ISBN");
            prepStmt.setInt(4, scanner.nextInt());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update record");
            e.printStackTrace();
        }catch (InputMismatchException e){
            System.out.println("Wrong type");
        }
    }

    public void delete(int id) {
        final String sql = "delete from library.books where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete row");
        }
    }
}

