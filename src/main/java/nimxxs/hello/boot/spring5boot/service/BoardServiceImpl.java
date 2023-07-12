package nimxxs.hello.boot.spring5boot.service;

import lombok.RequiredArgsConstructor;
import nimxxs.hello.boot.spring5boot.dao.BoardDAO;
import nimxxs.hello.boot.spring5boot.model.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    final BoardDAO bdao;

    @Override
    public boolean saveBoard(Board b) {
        return false;
    }

    @Override
    public List<Board> readBoard(Integer cpg) {        // 값 받아서 넘기기만 하면됨
        int stnum = (cpg - 1) * 25;

        return bdao.selectBoard(stnum);
    }

    @Override
    public Board readOneBoard(String bno) {
        return bdao.selectOneBoard(bno);
    }
}
