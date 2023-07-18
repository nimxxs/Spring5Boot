package nimxxs.hello.boot.spring5boot.service;

import lombok.RequiredArgsConstructor;
import nimxxs.hello.boot.spring5boot.dao.PdsDAO;
import nimxxs.hello.boot.spring5boot.model.Pds;
import nimxxs.hello.boot.spring5boot.model.PdsAttach;
import nimxxs.hello.boot.spring5boot.utils.PdsUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service("psrv")
@RequiredArgsConstructor
public class PdsServiceImpl implements PdsService{
    final PdsDAO pdao;
    final PdsUtils pdsUtils;

    @Override
    public int newPds(Pds p) {

        return pdao.insertPds(p);
    }

    @Override
    public boolean newPdsAttach(MultipartFile attach, int pno) {

        // 첨부한 파일을 지정한 위치에 저장후 파일정보 리턴
        PdsAttach pa = pdsUtils.processUpload(attach);
        pa.setPno(pno + "");

        // 보내는 값이 숫자라서 문자화 시킴

        // 첨부파일 정보를 디비에 저장 (파일 정보가 넘어왔음)
        int pacnt = pdao.insertPdsAttach(pa);


        // 삼항연산자 사용 (변수 따로 선언할 필요없음)
        return (pacnt > 0)? true : false;
    }

    @Override
    public List<Pds> readPds(Integer cpg) {
        int stnum = (cpg -1) *25;

        return pdao.selectPds(stnum);
    }

    @Override
    public int countPds() {

        return pdao.selectCountPds();
    }

    @Override
    public Pds readOnePds(String pno) {

        return pdao.selectOnePds(pno);
    }
}