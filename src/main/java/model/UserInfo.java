package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@ToString
public class UserInfo {
    private int number;
    private String username;
    private String phone;
    private String address;
    private Timestamp createAt;
}
