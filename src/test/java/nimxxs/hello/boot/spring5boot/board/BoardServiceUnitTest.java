package nimxxs.hello.boot.spring5boot.board;

import nimxxs.hello.boot.spring5boot.dao.BoardDAOImpl;
import nimxxs.hello.boot.spring5boot.dao.MemberDAOImpl;
import nimxxs.hello.boot.spring5boot.model.Board;
import nimxxs.hello.boot.spring5boot.model.Member;
import nimxxs.hello.boot.spring5boot.service.BoardService;
import nimxxs.hello.boot.spring5boot.service.BoardServiceImpl;
import nimxxs.hello.boot.spring5boot.service.MemberService;
import nimxxs.hello.boot.spring5boot.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({BoardServiceImpl.class, BoardDAOImpl.class})
public class BoardServiceUnitTest {
    @Autowired private BoardService bsrv;

    @Test
    @DisplayName("BoardService read Test")
    void readBoard() {
        List<Board> results = bsrv.readBoard();

        // System.out.println(results);
        assertNotNull(results);
    }


}