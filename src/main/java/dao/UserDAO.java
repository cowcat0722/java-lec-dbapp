package dao;

import db.DBConnection;
import model.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public int updateByNumber(String address, String phone, int number) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "update user_tb set address =?, phone = ? where number = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, address);
            pstmt.setString(2, phone);
            pstmt.setInt(3, number);
            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String username,String phone, String address){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "insert into user_tb(username, phone, address, created_at) values(?,?,?,now())";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,phone);
            pstmt.setString(3,address);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteByNumber(int number){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "delete from user_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public UserInfo selectByNumber(int number){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from user_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,number);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                UserInfo userinfo = new UserInfo(
                    rs.getInt("number"),
                    rs.getString("username"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getTimestamp("created_at")
                );
                return userinfo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserInfo> selectAll(){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from user_tb order by number desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            List<UserInfo> userInfoList = new ArrayList<>();
            while(rs.next()) {
                UserInfo userinfo = new UserInfo(
                        rs.getInt("number"),
                        rs.getString("username"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getTimestamp("created_at")
                );
                userInfoList.add(userinfo);
            }
            return userInfoList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
