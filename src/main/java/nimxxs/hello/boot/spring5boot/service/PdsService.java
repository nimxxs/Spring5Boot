package nimxxs.hello.boot.spring5boot.service;

import nimxxs.hello.boot.spring5boot.model.Pds;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


public interface PdsService {

    int newPds(Pds p);
    boolean newPdsAttach(MultipartFile attach, int pno);

    List<Pds> readPds(Integer cpg);

    int countPds();

    Pds readOnePds(String pno);

    String readOnePdsAttach(String pno);

    Map<String, Object> getHeaderResource(String fname);
}