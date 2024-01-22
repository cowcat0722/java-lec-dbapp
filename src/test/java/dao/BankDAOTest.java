package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankDAOTest {

    @Test
    public void selectAll_test(){
        // given

        // when
        BankDAO dao = new BankDAO();
        List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());
        System.out.println(accountList);
    }

    @Test
    public void selectByNumber_test(){
        // given
        int number = 4;

        // when
        BankDAO dao = new BankDAO();
        Account account = dao.selectByNumber(number);

        // then
        if(account == null){
            System.out.println(number+"로 조회된 값이 없습니다.");
        }else{
            System.out.println(account);
//            System.out.println(account.getNumber());
//            System.out.println(account.getPassword());
//            System.out.println(account.getBalance());
//            System.out.println(account.getCreatedAt());
        }
    }

    @Test
    public void deleteByNumber_test(){
        // given = 파라미터
        int number = 2;

        // when = 본코드 실행
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNumber(number);

        // then = 검증
        if(result == 1){
            System.out.println("삭제 성공");
        }else if(result == 0){
            System.out.println(number +"번호를 찾을 수 없습니다.");
        }else {
            System.out.println("삭제 실패");
        }
    }

    @Test
    public void insert_test(){
        // given
        String password = "1234";
        int balance = 630000;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.insert(password, balance);

        // then
        if(result == 1){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }

    }

    @Test
    public void updateByNumber_test(){
        // given
        int balance = 0;
        int number = 3;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.updateByNumber(balance,number);

        // then
        if(result == 1){
            System.out.println("업데이트 성공");
        }else if(result == 0){
            System.out.println(number+"번호를 찾을 수 없습니다.");
        }else{
            System.out.println("업데이트 실패");
        }
    }
}
