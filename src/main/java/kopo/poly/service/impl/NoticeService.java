package kopo.poly.service.impl;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.persistance.mapper.INoticeMapper;
import kopo.poly.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("NoticeService")
@Repository
public class NoticeService implements INoticeService {

    private final INoticeMapper noticeMapper;

    @Autowired
    public NoticeService(INoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }

    @Override
    public List<NoticeDTO> getNoticeList() throws  Exception {
        log.info(this.getClass().getName() + "InsertNoticeInfo Start!!");
        List<NoticeDTO> rList = noticeMapper.getNoticeList();
        log.info(this.getClass().getName() + "InsertNoticeInfo End!!");
        return rList;
    }

    @Override
    public NoticeDTO getNoticeDetail(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + "getNoticeDetail Start!!");
        NoticeDTO rDTO = noticeMapper.getNoticeDetail(pDTO);
        log.info(this.getClass().getName() +"getNoticeDetail End!" );
        return rDTO;
    }

    @Override
    public int InsertNoticeInfo(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName()+ "InsertNoticeInfo start !");
        int res  = noticeMapper.InsertNoticeInfo(pDTO);
        log.info(this.getClass().getName() + "InsertNoticeInfo end !");
        return res;
    }
    @Override
    public int NoticeDelete(NoticeDTO nDTO) throws Exception {
        log.info(this.getClass().getName() + " NoticeDelete Start");

        int res = noticeMapper.NoticeDelete(nDTO);
        log.info(this.getClass().getName() + " NoticeDelete End");
//        INoticeMapper.NoticeDelete(notice_seq);
        return res;
    }

    @Override
    public int NoticeChange(NoticeDTO cDTO) throws Exception{
        log.info(this.getClass().getName() + " NoticeChange Start");
        int res = noticeMapper.NoticeChange(cDTO);
        log.info(this.getClass().getName() + " NoticeChange End");
        return res;
    }

}
