package Class_01_30.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IDBInterface {
    public HashMap<String, String> selectByIdAsMap(String tableName,
                                                   int id) throws SQLException;
    void init ( String dbName, String pwFile );
    ArrayList<String> doQueryAL(String sql);
}
