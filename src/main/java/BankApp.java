import dao.BankDAO;
import model.Account;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 식별자 요청

        // GET, DELETE 는 HEAD만 있으면 됨(BODY가 없다), 쿼리 생성가능
        // http://bank.com/account GET -> select * from account_tb
        // http://bank.com/account/1 GET -> select * from account_tb where number = 1;
        // http://bank.com/account/1 DELETE -> delete from account_tb where number = 1;

        // PUT, POST는 BODY 데이터가 필요함.
        // http://bank.com/account/1 PUT
        // http://bank.com/account POST

        System.out.println("메서드를 입력하세요");
        String method = sc.nextLine();
        System.out.println("주소를 입력하세요");
        String action = sc.nextLine();

        String body = "";

        BankDAO bankDAO = new BankDAO();

        if (method.equals("GET")){
            String[] st1 = action.split("/");
            int number = Integer.parseInt(st1[2]);

            if(action.equals("/account")){
                List<Account> accountList = bankDAO.selectAll();
                System.out.println(accountList);
            }else if(st1.length == 3 && st1[0].isEmpty() && st1[1].equals("account")){
                bankDAO.selectByNumber(number);
                Account account = bankDAO.selectByNumber(number);
                System.out.println(account);
            }

        } else if (method.equals("POST")) {
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            // password=1234&balance=1000

            String[] st1 = body.split("&");
            String password = st1[0].split("=")[1];
            int balance = Integer.parseInt(st1[1].split("=")[1]);
            if(action.equals("/account")){
                bankDAO.insert(password,balance);
            }

        } else if (method.equals("PUT")) {
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            // balance=1000&number=1

            String[] st1 = body.split("&");
            int balance = Integer.parseInt(st1[0].split("=")[1]);
            int number = Integer.parseInt(st1[1].split("=")[1]);
            if(action.equals("/account")){
                bankDAO.updateByNumber(balance,number);
            }

        } else if (method.equals("DELETE")){
            String[] st1 = action.split("/");
            int number = Integer.parseInt(st1[2]);

            if(st1.length == 3 && st1[0].isEmpty() && st1[1].equals("account")) {
                bankDAO.deleteByNumber(number);
            }
        }
    }
}
