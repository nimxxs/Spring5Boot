package nimxxs.hello.boot.spring5boot.dao;

import nimxxs.hello.boot.spring5boot.model.Board;

import java.util.List;

public interface BoardDAO {
    int insertBoard(Board b);

    List<Board> selectBoard();

    Board selectOneBoard(String bno);
}
