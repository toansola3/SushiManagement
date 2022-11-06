/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author NgocHao
 */
public class RegistrationDAO {

    private static final String SQL_LOGIN = "SELECT userId, fullName, password, roleID, status FROM tblUsers WHERE userID=? and password =?";
    private static final String SQL_REMOVE = "UPDATE tblUsers SET status=0  WHERE userID=? ";
    private static final String SQL_UPDATE = "UPDATE tblUsers SET fullName =? WHERE userID= ?";
    private static final String SQL_SEARCH = "SELECT userId, fullName, password, roleID, status FROM tblUsers WHERE fullName LIKE ? ";
    private static final String SELECT_SUSHI = "SELECT id, name, image, shortDes, detailDes,price FROM Sushi ";
    private static final String COUNT_SUSHI = "SELECT count(id) From Menu";
    private static final String MENU_SUSHI = " SELECT id, name, price, shortDes ,detailDes "
            + "FROM (SELECT ROW_NUMBER() over (order by id asc) as rowPage ,* FROM Sushi ) as tableX "
            + "WHERE rowPage between ?*3-2 and ?*3  ";

    public UsersDTO getUser(String userId, String password) throws SQLException, NamingException {
        UsersDTO users = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pst = con.prepareStatement(SQL_LOGIN);
                pst.setString(1, userId);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getNString("fullName");
                    String roleId = rs.getNString("roleId");
                    boolean status = rs.getBoolean("status");
                    users = new UsersDTO(userId, fullName, password, roleId, status);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return users;
    }

    public List<UsersDTO> listUser(String search) throws SQLException, NamingException {
        List<UsersDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pst = con.prepareStatement(SQL_SEARCH);
                pst.setString(1, "%" + search + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String userID = rs.getNString("userId");
                    String fullName = rs.getNString("fullName");
//                    String password = rs.getNString("password");
                    String password = "* * * * *";
                    String roleId = rs.getNString("roleId");
                    boolean status = rs.getBoolean("status");
                    list.add(new UsersDTO(userID, fullName, password, roleId, status));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<SuShiDTO> sushiList() throws SQLException, NamingException {
        List<SuShiDTO> list = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                list = new ArrayList();
                pst = con.prepareStatement(SELECT_SUSHI);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String image = rs.getNString("image");
                    String shortDes = rs.getString("shortDes");
                    String detailDes = rs.getString("detailDes");
                    double price = rs.getDouble("price");
                    list.add(new SuShiDTO(id, name, image, shortDes, detailDes, price));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public int getCountSushi() throws SQLException, NamingException {
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pst = con.prepareStatement(COUNT_SUSHI);
                rs = pst.executeQuery();
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return count;
    }

    public List<SushiMenuDTO> getMenuSushi(int page) throws SQLException, NamingException {
        List<SushiMenuDTO> list = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                list = new ArrayList<>();
                pst = con.prepareStatement(MENU_SUSHI);
                pst.setInt(1, page);
                pst.setInt(2, page);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getNString("name");
                    double price = rs.getDouble("price");
                    String shortDes = rs.getString("shortDes");
                    String detailDes = rs.getString("detailDes");
                    list.add(new SushiMenuDTO(id, name, price, shortDes, detailDes));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean removeUser(String userId) throws NamingException, SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pst = con.prepareStatement(SQL_REMOVE);
                pst.setString(1, userId);
                check = pst.executeUpdate() > 0;
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean updateUser(String fullName, String userID) throws NamingException, SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pst = con.prepareStatement(SQL_UPDATE);
                pst.setString(1, fullName);
                pst.setString(2, userID);
                check = pst.executeUpdate() > 0;
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
}
