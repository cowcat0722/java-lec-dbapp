package dao;

import model.UserInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserDAOTest {

    @Test
    public void selectAll_test(){
        // given

        // when
        UserDAO dao = new UserDAO();
        List<UserInfo> userInfo = dao.selectAll();

        System.out.println(userInfo.size());
        System.out.println(userInfo);
    }

    @Test
    public void selectByNumber_test(){
        // given
        int number = 1;

        // when
        UserDAO dao = new UserDAO();
        UserInfo userInfo = dao.selectByNumber(number);

        // then
        if(userInfo == null){
            System.out.println(number+"번으로 조회된 회원이 존재하지 않습니다.");
        }else{
            System.out.println(userInfo);
        }
    }

    @Test
    public void deleteByNumber_test(){
        // given
        int number = 4;

        // when
        UserDAO dao = new UserDAO();
        int result = dao.deleteByNumber(number);

        // then
        if(result == 1){
            System.out.println("삭제 성공");
        }else if(result == 0){
            System.out.println(number + "번을 찾을 수 없습니다.");
        }else{
            System.out.println("삭제 실패");
        }

    }


    @Test
    public void updateByNumber_test(){
        // given
        String phone = "010-7280-2575";
        int number = 2;
        String address = "부산 기장";

        // when
        UserDAO dao = new UserDAO();
        int result = dao.updateByNumber(address,phone, number);

        // then
        if(result == 1){
            System.out.println("업데이트 성공");
        }else if(result == 0){
            System.out.println(number + "번을 찾을 수 없습니다.");
        }else{
            System.out.println("업데이트 실패");
        }
    }




    @Test
    public void insert_test(){
        // given = 파라미터
        String username = "이준기";
        String phone = "010-4444-5555";
        String address = "부산 명지";

        // when = 본 코드 실행
        UserDAO dao = new UserDAO();
        int result = dao.insert(username,phone,address);

        // then = 검증
        if(result == 1){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }

}
