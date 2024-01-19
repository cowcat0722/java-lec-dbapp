import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BankApp {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        try {
            String insert ="insert into account_tb(password,balance,created_at) values(?,?,now())";
            String update ="update account_tb set balance = balance + ? where number = ?";
            String delete ="delete from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(delete); // 버퍼
//            pstmt.setString(1,"1234");// parameterIndex : 물음표의 순서(1부터 시작함)
            pstmt.setInt(1,1);

            int num = pstmt.executeUpdate(); // flush
            System.out.println(num); // 영향받은 행의 수 리턴 오류는 -1
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
