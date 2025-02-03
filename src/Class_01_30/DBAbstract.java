package Class_01_30;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DBAbstract {
    private Connection connection;   // The DB Connections
    private int numQueries;
    private String DBName;    // name of DB to connect to
    private String PWFilePath;  // File that contains the PW and USer
    private String PassW;
    private String UserId;
    public DBAbstract(String DBName, String PWFilePath ){
        this.DBName = DBName;
        this.PWFilePath = PWFilePath;
        this.setPW( PWFilePath );
        System.out.printf("Pw='%s' and user='%s'",  PassW,  UserId );
        // Now have this.passw Set and this.userid set
        this.setConnect();
        System.out.println(System.getProperty("java.class.path"));
    }

    private void setConnect(){
        // Establish a connection
        try {
            String dbInfo = "jdbc:mysql://" + this.DBName;
            System.out.printf( "dbInfo=%s, user=%s PW=%s", dbInfo, this.UserId, this.PassW );
            System.out.println(System.getProperty("java.class.path"));
            connection = DriverManager.getConnection
                    ( dbInfo, this.UserId, this.PassW );

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("\n CONNECTED FAILED ");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Database connected");
    }
    public ResultSet doQuery( String SQL ) {
        // Create a statement
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            System.out.printf("SQL=%s", SQL);
            resultSet = statement.executeQuery(SQL);
        } catch (Exception e){
            System.out.printf("\n SQL Statement failed: %s", SQL);
            System.out.printf("\n exception: %s", e.toString());
        }
        return resultSet;
    }
    public  ArrayList<String> doQueryAL(String sql) {
        ArrayList<String> retData = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            // Try to execute the provided SQL
            Statement statement = connection.createStatement();
            // Execute a statement
            resultSet = statement.executeQuery( sql );
        } catch (Exception e ) {
            System.out.printf("\n SQL Statement failed: %s", sql);
            System.out.printf("\n exception: %s", e.toString());
        }
        // Iterate through the result and print the student names
        try {
            // Try to get the results
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                String columnValue = "";
                String results = "";
                String cma = "";
                for (int i = 1; i <= columnsNumber; i++) {
                    if ( i>1) cma=";";
                    columnValue += cma + resultSet.getString(i);
                }
                retData.add( columnValue);
            }
        } catch ( Exception e ) {
            System.out.printf("\n Result set failed: %s", sql);
            System.out.printf("\n exception: %s", e.toString());
        }
        return retData;
    }

    public  void setPW( String fName ) {
        //String fName = "pw.txt";
        System.out.println(System.getProperty( fName ));
        File file = new File( fName );
        try {
            Scanner scnr = new Scanner(file);
            int lineNumber = 1;

            this.UserId = scnr.nextLine();
            this.PassW = scnr.nextLine();
            //while(scnr.hasNextLine()){
            // line = scnr.nextLine();
            //    System.out.println("line " + lineNumber + " :" + line);
            //    lineNumber++;
            // }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public int updateColumn(String tableName, String columnName, Object value, int id) throws SQLException {
        String query = "UPDATE " + tableName + " SET " + columnName + " = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, value);
            statement.setInt(2, id);
            return statement.executeUpdate(); // Returns the number of rows affected
        }
    }
    public HashMap<String, String> selectByIdAsMap(String tableName, int id) throws SQLException {
        HashMap<String, String> resultMap = new HashMap<>();
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        System.out.printf("\nSQLL=%s", query);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    System.out.printf("\n-------cc:%s", columnCount);
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        String value = resultSet.getString(columnName);
                        resultMap.put(columnName, value);
                    }
                }
            }
        }

        return resultMap;
    }
}
