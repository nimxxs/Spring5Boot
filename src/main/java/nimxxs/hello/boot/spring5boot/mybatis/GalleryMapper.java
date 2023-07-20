package nimxxs.hello.boot.spring5boot.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryMapper {

    int insertGallery(Gallery g);

    int insertGalAttach(GalAttach ga);

    List<Gallery> selectGallery(int stnum);

    Gallery selectOneGallery(String gno);

    int selectCountGallery();

    GalAttach selectOneGalleryAttach(String gno);

    /*int insertComment(PdsComment pc);
    List<PdsComment> selectPdsComment(String pno);

    int insertPdsComment(PdsComment pc);

    int insertPdsReply(PdsComment pc);


//    int updateViewPds(String bno);
//
//    List<Pds> selectFindPds(Map<String, Object> params);
//
//    int countFindPds(Map<String, Object> params);



   /* List<Pds> selectPds(int stnum);
    Pds selectOnePds(String bno);  // 글번호만 넘기면 되기 때문에 굳이 Pds b를 다 받아볼 필요 없다. 그래서 bno만 받아오기
    int updateViewPds(String bno);
    int selectCountPds();
    List<Pds> selectFindPds(Map<String, Object> params);
    int countFindPds(Map<String, Object> params);*/
}
