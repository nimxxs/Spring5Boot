package nimxxs.hello.boot.spring5boot.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Gallery {
    private String gno;
    private String title;
    private String userid;
    private String regdate;
    private String thumbs;
    private String views;
    private String contents;
    private String ipaddr;

    private PdsAttach ga;

};
