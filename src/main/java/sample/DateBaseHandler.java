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
        public void signUpUser(User user){
        //создаем команду для   MySQL insert
             String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
            Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," + Const.USER_USERNAME
            + "," + Const.USER_PASSWORD + "," + Const.USER_LOCATION + "," + Const.USER_GENDER + ")"
                     + "VALUES(?,?,?,?,?,?)";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, user.getFirstName());
                prSt.setString(2, user.getLastName());
                prSt.setString(3, user.getUserName());
                prSt.setString(4, user.getPassword());
                prSt.setString(5, user.getLocation());
                prSt.setString(6, user.getGender());
                prSt.executeUpdate();       //добавляет в бд
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_USERNAME + " =? AND " + Const.USER_PASSWORD + " =? ";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1, user.getUserName());
                prSt.setString(2, user.getPassword());
                resSet = prSt.executeQuery();        //вытягивает из бд
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return resSet;
        }

}
