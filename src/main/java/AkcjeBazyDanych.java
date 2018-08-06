

import java.sql.SQLException;
import java.util.Scanner;

public class AkcjeBazyDanych {

    public static void dodajDoBazy(BookDao dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj tytul");
        String title = scanner.nextLine();
        System.out.println("podaj autora");
        String author = scanner.nextLine();
        System.out.println("podaj rok");
        int year = scanner.nextInt();
        System.out.println("podaj nr ISBN");
        int isbn = scanner.nextInt();

        Book book = new Book(title, author, year, isbn);
        dao.add(book);
        scanner.close();
    }

    public static void usunZBazyDanych(BookDao dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("poda ID pozycji która chcesz usunac");
        int idDoUsuniecia = scanner.nextInt();
        dao.delete(idDoUsuniecia);
        scanner.close();
    }




    public static void aktualizujPozycje(BookDao dao) {
        Book book=new Book();
         dao.update(book);


    }
public static  void  wyswietlPozycje(BookDao dao) throws SQLException {
        Book book =new Book();
        dao.read(book);
}

}
