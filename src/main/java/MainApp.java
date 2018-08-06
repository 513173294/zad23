import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
    public static void run() throws SQLException {
        BookDao dao = new BookDao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("wybierz akcje: (podaj cyfre)\n1 : dodaj,\n2 : odczyt,\n3 : aktualizuj,\n4 : usun");
        int decision = scanner.nextInt();
        switch (decision) {
            case (1):
                AkcjeBazyDanych.dodajDoBazy(dao);
                break;
            case (2):
                AkcjeBazyDanych.wyswietlPozycje(dao);
                break;
            case (3):
                AkcjeBazyDanych.aktualizujPozycje(dao);
                break;
            case (4):
                AkcjeBazyDanych.usunZBazyDanych(dao);
                break;

        }
        System.out.println("\nCo dalej?(znowu cfra)\n1 : powrot\n2 : koniec ");
        Main.choice = scanner.nextInt();


    }
}

