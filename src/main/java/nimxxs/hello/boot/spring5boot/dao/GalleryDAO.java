package nimxxs.hello.boot.spring5boot.dao;

import nimxxs.hello.boot.spring5boot.model.GalAttach;
import nimxxs.hello.boot.spring5boot.model.Gallery;

import java.util.List;

public interface GalleryDAO {
    List<Gallery> selectGallery(int stnum);

    int insertGalAttach(GalAttach ga);

    int insertGallery(Gallery g);

    Gallery selectOneGallery(String gno);
}
