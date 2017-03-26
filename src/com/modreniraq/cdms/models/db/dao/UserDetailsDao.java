package com.modreniraq.cdms.models.db.dao;

import com.modreniraq.cdms.models.db.type.UsersType;
import com.modreniraq.cdms.models.db.vo.UserDetailsVo;
import com.modreniraq.cdms.models.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class UserDetailsDao extends Dao implements DaoList<UserDetailsVo> {

    private static UserDetailsDao userDetailsDao;

    private UserDetailsDao() {

    }

    public static UserDetailsDao getInstance() {
        if (userDetailsDao == null) {
            userDetailsDao = new UserDetailsDao();
        }
        return userDetailsDao;

    }

    @Override
    public ObservableList<UserDetailsVo> loadAll() throws Exception {
             Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserDetailsVo usersDetailsVo = null;
        UsersVo usersVo = null;
        ObservableList<UserDetailsVo> Users =FXCollections.observableArrayList();
        try {
            con = getConnection();

            String sql = "SELECT users.ID,users.USER_NAME,users.PASSWORD,users.USER_TYPE ,"
                    + "users_details.FIRST_NAME,users_details.FATHER_NAME,users_details.MOBILE,users_details.IMAGE,users_details.SPECIALIZATION"
                    + " FROM users INNER JOIN users_details ON users_details.USER_ID=users.ID ";
            ps = con.prepareStatement(sql);
           // ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                usersVo = new UsersVo();
                usersVo.setId(rs.getInt("ID"));
                usersVo.setUserName(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));
                UsersType usersType = UsersType.getUsersTypeById(rs.getInt("USER_TYPE"));
                usersVo.setUsersType(usersType);
                
                usersDetailsVo = new UserDetailsVo();
                usersDetailsVo.setFirstName(rs.getString("FIRST_NAME"));
                usersDetailsVo.setFatherName(rs.getString("FATHER_NAME"));
                usersDetailsVo.setMobile(rs.getString("MOBILE"));
                // usersDetailsVo.setImage(rs.getBytes("IMAGE"));
                usersDetailsVo.setSpecialization(rs.getString("SPECIALIZATION"));
                usersDetailsVo.setUsersVo(usersVo);
                Users.add(usersDetailsVo);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            ps.close();
            rs.close();
            CloseConnection(con);
        }

        return Users;
        
    }

    @Override
    public int insert(UserDetailsVo udv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int isInsert = 0;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String usersql = "INSERT INTO users(ID,USER_NAME,PASSWORD,USER_TYPE)VALUES(?,?,?,?)";
            ps = con.prepareStatement(usersql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.setString(2, udv.getUsersVo().getUserName());
            ps.setString(3, udv.getUsersVo().getPassword());
            ps.setInt(4, udv.getUsersVo().getUsersType().getId());
            ps.executeUpdate();
            String userDetailsSql = "INSERT INTO users_details(USER_ID,FIRST_NAME,FATHER_NAME,MOBILE,SPECIALIZATION) VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(userDetailsSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.setString(2, udv.getFirstName());
            ps.setString(3, udv.getFatherName());
            ps.setString(4, udv.getMobile());
            //   ps.setBytes(5, udv.getImage());
            ps.setString(5, udv.getSpecialization());
            ps.executeUpdate();
            con.commit();
            isInsert = 1;

        } catch (Exception e) {
            con.rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ps.close();
            CloseConnection(con);
        }
        return isInsert;

    }

    @Override
    public int update(UserDetailsVo udv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int isUpdate = 0;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String usersql = "UPDATE users SET USER_NAME=?,PASSWORD=?,USER_TYPE=? WHERE ID=?";
            ps = con.prepareStatement(usersql);
            ps.setString(1, udv.getUsersVo().getUserName());
            ps.setString(2, udv.getUsersVo().getPassword());
            ps.setInt(3, udv.getUsersVo().getUsersType().getId());
            ps.setInt(4, udv.getUsersVo().getId());
            ps.executeUpdate();
            String userDetailsSql = "UPDATE users_details SET FIRST_NAME=?,FATHER_NAME=?,MOBILE=?,SPECIALIZATION=? WHERE USER_ID=?";
            ps = con.prepareStatement(userDetailsSql);
            ps.setString(1, udv.getFirstName());
            ps.setString(2, udv.getFatherName());
            ps.setString(3, udv.getMobile());
            // ps.setBytes(4, udv.getImage());
            ps.setString(4, udv.getSpecialization());
            ps.setInt(5, udv.getUsersVo().getId());
            ps.executeUpdate();
            con.commit();
            isUpdate = 1;

        } catch (Exception e) {
            con.rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ps.close();
            CloseConnection(con);
        }
        return isUpdate;
    }

    @Override
    public int delete(UserDetailsVo udv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int isDelete = 0;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String userDetailsSql = "DELETE FROM users_details WHERE USER_ID=?";
            ps = con.prepareStatement(userDetailsSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.executeUpdate();

            String usersql = "DELETE FROM users WHERE ID=?";
            ps = con.prepareStatement(usersql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.executeUpdate();

            con.commit();
            isDelete = 1;

        } catch (Exception e) {
            con.rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ps.close();
            CloseConnection(con);
        }
        return isDelete;
    }

   
    public UserDetailsVo getData2() throws Exception {

          Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserDetailsVo usersDetailsVo = null;
        UsersVo usersVo = null;

        try {
            con = getConnection();

            String sql = "SELECT users.ID,users.USER_NAME,users.PASSWORD,users.USER_TYPE ,"
                    + "users_details.FIRST_NAME,users_details.FATHER_NAME,users_details.MOBILE,users_details.IMAGE,users_details.SPECIALIZATION"
                    + " FROM users INNER JOIN users_details ON users_details.USER_ID=users.ID ";
            ps = con.prepareStatement(sql);
           // ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                usersVo = new UsersVo();
                usersVo.setId(rs.getInt("ID"));
                usersVo.setUserName(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));
                UsersType usersType = UsersType.getUsersTypeById(rs.getInt("USER_TYPE"));
                usersVo.setUsersType(usersType);

                usersDetailsVo = new UserDetailsVo();
                usersDetailsVo.setFirstName(rs.getString("FIRST_NAME"));
                usersDetailsVo.setFatherName(rs.getString("FATHER_NAME"));
                usersDetailsVo.setMobile(rs.getString("MOBILE"));
                // usersDetailsVo.setImage(rs.getBytes("IMAGE"));
                usersDetailsVo.setSpecialization(rs.getString("SPECIALIZATION"));
                usersDetailsVo.setUsersVo(usersVo);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            ps.close();
            rs.close();
            CloseConnection(con);
        }

        return usersDetailsVo;
    }

    @Override
    public UserDetailsVo getDataById(int id) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserDetailsVo usersDetailsVo = null;
        UsersVo usersVo = null;

        try {
            con = getConnection();

            String sql = "SELECT users.ID,users.USER_NAME,users.PASSWORD,users.USER_TYPE ,"
                    + "users_details.FIRST_NAME,users_details.FATHER_NAME,users_details.MOBILE,users_details.IMAGE,users_details.SPECIALIZATION"
                    + " FROM users INNER JOIN users_details ON users_details.USER_ID=users.ID WHERE users.ID=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                usersVo = new UsersVo();
                usersVo.setId(rs.getInt("ID"));
                usersVo.setUserName(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));
                UsersType usersType = UsersType.getUsersTypeById(rs.getInt("USER_TYPE"));
                usersVo.setUsersType(usersType);

                usersDetailsVo = new UserDetailsVo();
                usersDetailsVo.setFirstName(rs.getString("FIRST_NAME"));
                usersDetailsVo.setFatherName(rs.getString("FATHER_NAME"));
                usersDetailsVo.setMobile(rs.getString("MOBILE"));
                // usersDetailsVo.setImage(rs.getBytes("IMAGE"));
                usersDetailsVo.setSpecialization(rs.getString("SPECIALIZATION"));
                usersDetailsVo.setUsersVo(usersVo);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            ps.close();
            rs.close();
            CloseConnection(con);
        }

        return usersDetailsVo;
    }

    @Override
    public UserDetailsVo getData(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
