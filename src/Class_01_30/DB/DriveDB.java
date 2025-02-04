package Class_01_30.DB;

import java.util.ArrayList;

public class DriveDB {
    public static void main(String[] args) {
        IDBInterface dbAbstract = new DBAbstract();
        BookService bs = new BookService( dbAbstract );
        int ID = 1;
        int checkOutDays = bs.getBookCheckOutDays( ID);
        System.out.printf("Book id: %d CheckOut Days:%s;\n", ID, checkOutDays);

         ID = 15;
        checkOutDays = bs.getBookCheckOutDays( ID);
        System.out.printf("Book id: %d CheckOut Days:%s;\n", ID, checkOutDays);
        double totalSales = bs.getTotalSalesByGenre("Fantasy");
        System.out.printf("Total sales by genre: %.2f\n", totalSales);
    }
    private static void showTheRows(ArrayList<String> rows) {
        for( String row : rows ){
            System.out.printf("\n Row:%s", row );
        }
    }
}
