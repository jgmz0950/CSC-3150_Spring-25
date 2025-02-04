package Class_01_30.DB;
public class Book {
    private int id;
    private String title;
    private double sales;
    private String author;
    private String genre;
    private int year;
    public int getCheckOutDays() {
        return checkOutDays;
    }
    public void setCheckOutDays(int checkOutDays) {
        this.checkOutDays = checkOutDays;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    private int checkOutDays;
    public Book(int id, String title, double sales, String author, String genre, int year) {
        this.id = id;
        this.title = title;
        this.sales = sales;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.checkOutDays = 0;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getSales() {
        return sales;
    }
    public void setSales(int sales) {
        this.sales = sales;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sales=" + sales +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
