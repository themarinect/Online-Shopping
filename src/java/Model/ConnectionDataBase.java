package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDataBase {

    protected Connection cn;

    public ConnectionDataBase() {
    }

    protected void makeConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://SERVER_LAB2\\SQLEXPRESS:1026;databaseName=ShoppingOnline;user=sa;password=1234$";
            cn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    protected void releaseConnection() throws SQLException {
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getResultset(String sql) {
        try {

            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
