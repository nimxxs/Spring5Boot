package nimxxs.hello.boot.spring5boot.controller;

import lombok.RequiredArgsConstructor;
import nimxxs.hello.boot.spring5boot.service.GalleryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
@RequiredArgsConstructor
public class GalleryController {

    final GalleryService gsrv;

    Logger logger = LogManager.getLogger(GalleryController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {
        logger.info("gallery/list 호출!!");

        m.addAttribute("gal", gsrv.readGallery(cpg));
        m.addAttribute("cpg", cpg);     // 현재 페이지
        m.addAttribute("cntpg",  gsrv.countGallery());     // 총 페이지수
        m.addAttribute("stpg",  ((cpg-1) / 10) * 10 + 1);     // 시작 페이지

        if (cpg > (int)m.getAttribute("cntpg"))
            return "redirect:/gallery/list/1";


        return "/gallery/list";
    }
}
