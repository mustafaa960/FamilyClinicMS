package com.modreniraq.cdms.models.db.dao;

import com.modreniraq.cdms.models.db.type.UsersType;
import com.modreniraq.cdms.models.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UsersDao extends Dao implements DaoList<UsersVo> {

    private static UsersDao usersDao;

    private UsersDao() {

    }

    public static UsersDao getInstance() {
        if (usersDao == null) {
            return usersDao = new UsersDao();
        }
        return usersDao;
    }

    @Override
    public List<UsersVo> loadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(UsersVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(UsersVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(UsersVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsersVo getData(UsersVo uv) throws Exception {

          Connection con = null;
        UsersVo usersVo = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM users WHERE USER_NAME='" + uv.getUserName() + "' AND PASSWORD='" + uv.getPassword() + "'";
            PreparedStatement ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usersVo = new UsersVo();
                usersVo.setId(rs.getInt("ID"));
                usersVo.setUserName(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));
                UsersType usersType = UsersType.getUsersTypeById(rs.getInt("USER_TYPE"));
                usersVo.setUsersType(usersType);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            CloseConnection(con);
        }
        return usersVo;
    }

    @Override
    public UsersVo getDataById(int id) throws Exception {

        Connection con = null;
        UsersVo usersVo = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM users WHERE ID=?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                usersVo = new UsersVo();
                usersVo.setId(rs.getInt("ID"));
                usersVo.setUserName(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));

                UsersType usersType = UsersType.getUsersTypeById(rs.getInt("USER_TYPE"));
                usersVo.setUsersType(usersType);

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            CloseConnection(con);
        }
        return usersVo;
    }

}
