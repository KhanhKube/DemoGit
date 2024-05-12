/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class UserDAO extends DBContext {

    public User checkUser(String user, String pass) {
        String sql = "select * from Users where Username = ? and Password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(user, pass);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
    public User getUserByName(String user){
        String sql = "select * from Users where Username = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new User(user, rs.getString("Password"));
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }
    public void insertUser(User u){
        String sql = "select * from Users values(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUser());
            st.setString(2, u.getPass());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
