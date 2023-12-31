package nimxxs.hello.boot.spring5boot.board;

import nimxxs.hello.boot.spring5boot.dao.BoardDAO;
import nimxxs.hello.boot.spring5boot.dao.BoardDAOImpl;
import nimxxs.hello.boot.spring5boot.model.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(BoardDAOImpl.class)
public class BoardDAOUnitTest {

    @Autowired private BoardDAO bdao;

    @Test
    @DisplayName("BoardDAO select Test")
    void selectBoard() {
        int cpg = 1;
        int stnum = (cpg - 1) * 25;

       List<Board> results = bdao.selectBoard(stnum);
       assertNotNull(results);
    }

    @Test
    @DisplayName("BoardDAO selectOne Test")
    void selectOneBoard() {
        String bno = "804";

        Board result = bdao.selectOneBoard(bno);
        assertNotNull(result);
    }
    @Test
    @DisplayName("BoardDAO insert Test")
    @Transactional
    void insertBoard() {
        Board b = new Board();
        b.setUserid("abc123"); b.setTitle("테스트");
        b.setContents("테스트"); b.setIpaddr("127.0.0.1");

        int result = bdao.insertBoard(b);
        assertEquals(result,1);
    }
    @Test
    @DisplayName("BoardDAO countPage Test")
    void countPage() {
        int result = bdao.selectCountBoard();

        assertNotNull(result);
    }
    @Test
    @DisplayName("BoardDAO findBoard Test")
    void findBoard() {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype","titcont");
        params.put("findkey","빵빵");
        params.put("stnum",0);

        List<Board> results = bdao.selectFindBoard(params);

        assertNotNull(results);
    }
    @Test
    @DisplayName("BoardDAO countfindBoard Test")
    void countfindBoard() {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype","titcont");
        params.put("findkey","빵빵");

        int result = bdao.countFindBoard(params);

        assertNotNull(result);
    }


}
