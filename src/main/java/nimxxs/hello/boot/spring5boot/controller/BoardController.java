package nimxxs.hello.boot.spring5boot.controller;

import lombok.RequiredArgsConstructor;
import nimxxs.hello.boot.spring5boot.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final BoardService bsrv;

    Logger logger = LogManager.getLogger(BoardController.class);
    @GetMapping("/list")
    public String list(Model m) {       // 모델 객체를 받아옴
        logger.info("board/list 호출!!");

        m.addAttribute("bds", bsrv.readBoard());

        return "board/list";
    }


}
