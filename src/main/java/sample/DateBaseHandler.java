package sample;
import java.sql.*;

public class DateBaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" +dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }
        public void signUpUser(String firstName, String lastName, String userName,
                               String password, String location, String gender){
             String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
            Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," + Const.USER_USERNAME
            + "," + Const.USER_PASSWORD + "," + Const.USER_LOCATION + "," + Const.USER_GENDER + ")"
                     + "VALUES(?,?,?,?,?,?)";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, firstName);
                prSt.setString(2, lastName);
                prSt.setString(3, userName);
                prSt.setString(4, password);
                prSt.setString(5, location);
                prSt.setString(6, gender);
                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

}
