package Class_01_30.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class BookService {
    final String PW_FILE = "pw.txt";
    final String DB_NAME = "45.55.136.114/csc3610";
//    DBAbstract dbAbstract = new DBAbstract();
    IDBInterface dbAbstract;
    final String TABLE_NAME = "BestSellingBooks";
    public BookService( IDBInterface dbAbstract) {
        this.dbAbstract = dbAbstract;
        dbAbstract.init(  DB_NAME, PW_FILE );
    }
    public int getBookCheckOutDays(int id) {
            String sql = "select id, genre" +
                    " from books where id = " + id;
        System.out.printf("\nSQL=%s", sql);
            int checkOutDays = -1;
            try {
                HashMap<String, String> results = dbAbstract.selectByIdAsMap(TABLE_NAME, id);
                System.out.printf("\n Back from select id as ");
                    System.out.println(results);
                    String genre = results.get("Genre");
                    if (genre == null) {
                        checkOutDays = -1;
                    }
                    if ( genre.equalsIgnoreCase("fantasy") || genre.equalsIgnoreCase("mystery")) {
                            checkOutDays = 30;
                    } else if (genre.equalsIgnoreCase("adventure") || genre.equalsIgnoreCase("thriller")) {
                        checkOutDays = 35;
                    } else if ( genre.equalsIgnoreCase("nonfiction")) {
                        checkOutDays = 40;
                    } else {
                        checkOutDays = 25;
                    }
            } catch ( SQLException e ){
                e.printStackTrace();
            }
            return checkOutDays;
    }
    public double getTotalSalesByGenre(String genre) throws NumberFormatException {
        double totalSales = 0.0;
        String sql = String.format("SELECT SUM(sale) as sale FROM BestSellingBooks WHERE genre='%s'", genre);
        try {
            ArrayList<String> results = dbAbstract.doQueryAL(sql);
            if (!results.isEmpty() && results.get(0) != null) {
                totalSales = Double.parseDouble(results.get(0));
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid number format in database results", e);
        }
        return totalSales;
    }
}
