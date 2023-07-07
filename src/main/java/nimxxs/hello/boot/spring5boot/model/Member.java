package nimxxs.hello.boot.spring5boot.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private String mno;
    private String userid;
    private String password;
    private String name;
    private String email;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String phone;
    private String regdate;
}
