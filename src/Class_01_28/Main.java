package Class_01_28;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String DB_LOC = "45.55.136.114:3306/csc3610";
    private static final String DB_URL = "jdbc:mysql://" + DB_LOC;
    private static final String DB_USER = "csc3610";
    private static final String DB_PASSWORD = "csc3610";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book ID (1–4):");
        String idInput = scanner.nextLine();
        // Validate input
        if (!idInput.matches("\\d+")) {
            System.out.println("Please enter a valid number.");
            return;
        }
        int id = Integer.parseInt(idInput);
        if (id < 1 || id > 4) {
            System.out.println("Please enter an ID between 1 and 4.");
            return;
        }
        // Query the database!
        String sql = "SELECT id, title, author, year, sale, language, genre FROM BestSellingBooks WHERE id = " + id;
        Connection connection;   //
        System.out.println(System.getProperty("java.class.path"));
        try {
            System.out.printf( "dbInfo=%s, user=%s PW=%s", DB_URL, DB_USER, DB_PASSWORD );
            connection = DriverManager.getConnection
                    ( DB_URL, DB_USER, DB_PASSWORD);
            try {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                // Process the result
                if (resultSet.next()) {
                    int bookId = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    int year = resultSet.getInt("year");
                    double sale = resultSet.getDouble("sale");
                    String language = resultSet.getString("language");
                    String genre = resultSet.getString("genre");

                    System.out.println("Book Details:");
                    System.out.println("ID: " + bookId);
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Year: " + year);
                    System.out.println("Sale: " + sale);
                    System.out.println("Language: " + language);
                    System.out.println("Genre: " + genre);
                } else {
                    System.out.println("No book found with ID: " + id);
                }

            } catch (SQLException e) {
                System.out.println("An error occurred while accessing the database: " + e.getMessage());
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("\n CONNECTED FAILED ");
            e.printStackTrace();
            System.exit(1);
        }


    }

}
