package nimxxs.hello.boot.spring5boot.board;

import nimxxs.hello.boot.spring5boot.model.Board;
import nimxxs.hello.boot.spring5boot.mybatis.BoardMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardMapperUnitTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("BoardMapper select Test")
    void selectBoard() {
        int cpg = 1;
        int stnum = (cpg - 1) * 25;

        List<Board> results = boardMapper.selectBoard(stnum);

        System.out.println(results);
        assertNotNull(results);
    }
    @Test
    @DisplayName("BoardMapper selectOne Test")
    void selectOneBoard() {
        String bno = "804";

        Board result = boardMapper.selectOneBoard(bno);

        assertNotNull(result);
    }
    @Test
    @DisplayName("BoardMapper insert Test")
    @Transactional
    void insertBoard() {
        Board b = new Board();
        b.setUserid("abc123"); b.setTitle("테스트");
        b.setContents("테스트"); b.setIpaddr("127.0.0.1");

        int result = boardMapper.insertBoard(b);
        assertEquals(result,1);
    }
    @Test
    @DisplayName("BoardMapper update Test")
    @Transactional
    void updateBoard() {
        String bno = "1047";

        int result = boardMapper.updateViewBoard(bno);
        assertEquals(result,1);
    }
    @Test
    @DisplayName("BoardMapper countPage Test")
    void countPage() {
        int result = boardMapper.selectCountBoard();

        assertNotNull(result);
    }
    @Test
    @DisplayName("BoardMapper findBoard Test")
    void findBoard() {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype","titcont");
        params.put("findkey","빵빵");
        params.put("stnum",0);

        List<Board> results = boardMapper.selectFindBoard(params);

        assertNotNull(results);
    }
    @Test
    @DisplayName("BoardMapper countfindBoard Test")
    void countfindBoard() {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype","title");
        params.put("findkey","빵빵");

        int result = boardMapper.countFindBoard(params);

        assertNotNull(result);
    }
}
