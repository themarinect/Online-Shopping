/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class UserModel extends ConnectionDataBase {

    public UserModel() {
    }

    public User checkUser(String userName, String password) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Select * From Users Where userName=? And Password=?");
            pst.setString(1, userName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            User user =null;
            if (rs.next()) {
                user=new User();
                user.setUserID(user.getUserID());
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
            }
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public boolean checkUser1(String userName, String password) {
        try {
            makeConnection();
            PreparedStatement pst = cn.prepareStatement("Select * From Users Where userName=? And Password=?");
            pst.setString(1, userName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
