package nimxxs.hello.boot.spring5boot.mybatis;

import nimxxs.hello.boot.spring5boot.model.Pds;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PdsMapper {
    int insertPds(Pds b);

    int lastPdsPno();

   /* List<Pds> selectPds(int stnum);
    Pds selectOnePds(String bno);  // 글번호만 넘기면 되기 때문에 굳이 Pds b를 다 받아볼 필요 없다. 그래서 bno만 받아오기
    int updateViewPds(String bno);
    int selectCountPds();
    List<Pds> selectFindPds(Map<String, Object> params);
    int countFindPds(Map<String, Object> params);*/
}
