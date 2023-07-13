package nimxxs.hello.boot.spring5boot.controller;

import lombok.RequiredArgsConstructor;
import nimxxs.hello.boot.spring5boot.model.Board;
import nimxxs.hello.boot.spring5boot.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final BoardService bsrv;

    Logger logger = LogManager.getLogger(BoardController.class);
    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {       // 모델 객체를 받아옴
        logger.info("board/list 호출!!");

        m.addAttribute("bds", bsrv.readBoard(cpg));
        m.addAttribute("cpg", cpg);                     // 현재 페이지
        int cntpg = bsrv.countBoard();
        m.addAttribute("cntpg", cntpg);     // 총 페이지
        m.addAttribute("stpg", ((cpg-1)/10) * 10 +1);

        // 만일, 현재 페이지가 총 페이지수 보다 크다면
        // 1페이지로 강제 이동
        if (cpg > cntpg)
            return "redirect:/board/list/1";

        return "/board/list";
    }
    @GetMapping("/view/{bno}")
    public String view(Model m, @PathVariable String bno) {
        logger.info("board/view 호출!!");

        m.addAttribute("bd", bsrv.readOneBoard(bno));

        return "/board/view";
    }

    @GetMapping("/write")
    public String write() {
        logger.info("board/write 호출!!");

        return "/board/write";
    }
    @PostMapping("/write")
    public String writeok(Board b) {
        logger.info("board/writeok 호출!!");
        String returnPage = "redirect:/board/fail";

        if (bsrv.saveBoard(b))
            returnPage = "redirect:/board/list/1";

        return returnPage;
    }



}
