public class Book {

    private int ID;
    private String title;
    private String author;
    private  int year;
    private int isbn;

    public Book() {
    }

    public Book( String title, String author, int year, int isbn) {

        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return  ID+" "+ title+" "+author+" " +year+" "+ isbn;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
