import dao.UserDAO;

import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("조회할 회원번호를 입력해주세요: ");
        int number = sc.nextInt();

        UserDAO dao = new UserDAO();
        dao.selectByNumber(number);

    }
}
