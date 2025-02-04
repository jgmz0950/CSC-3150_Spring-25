package Class_01_30.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class dbForTest implements IDBInterface{
    @Override
    public HashMap<String, String> selectByIdAsMap(String tableName, int id) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        if( id == 1){
                map.put("Genre", "fantasy");
        } else if( id == 2){
            map.put("Genre", "adventure");
        } else if( id == 3){
            map.put("Genre", "mystery");
        } else if ( id == 4){
            map.put("Genre", "nonfinction");
        }
        return map;
    }

    @Override
    public void init(String dbName, String pwFile) {

    }

    @Override
    public ArrayList<String> doQueryAL(String sql) {
        return null;
    }
}
