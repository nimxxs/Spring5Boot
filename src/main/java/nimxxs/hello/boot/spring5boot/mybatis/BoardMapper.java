package nimxxs.hello.boot.spring5boot.mybatis;

import nimxxs.hello.boot.spring5boot.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insertBoard(Board b);

    List<Board> selectBoard(int stnum);

    Board selectOneBoard(String bno);  // 글번호만 넘기면 되기 때문에 굳이 Board b를 다 받아볼 필요 없다. 그래서 bno만 받아오기
}
