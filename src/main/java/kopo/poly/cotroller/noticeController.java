package kopo.poly.cotroller;
import kopo.poly.dto.NoticeDTO;
import kopo.poly.service.INoticeService;
import kopo.poly.service.impl.NoticeService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class noticeController {

    @Resource(name = "NoticeService")
    private INoticeService NoticeService;

    @RequestMapping(value = "NoticeDetail")
    public String NoticeDetail(HttpServletRequest request,Model model) throws Exception{
        log.info(this.getClass().getName() + " .NoticeDetail start!!");
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setNotice_seq(notice_seq);
        log.info("notice_seq : " + notice_seq);
        NoticeDTO rDTO = NoticeService.getNoticeDetail(pDTO);
        if(rDTO == null){
            model.addAttribute("msg","존재하지 않는 게시물입니다.");
            model.addAttribute("url","getNoticeList");
            return "Redirect";
        }
        model.addAttribute("rDTO",rDTO);
        log.info(this.getClass().getName() + ".NoticeDetail End!!");
        return "NoticeDetail";

    }
    @RequestMapping(value = "getInsertNotice")
    public String getInsertNotice(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .getNoticeData Start !!");
        List<NoticeDTO> rList = NoticeService.getNoticeList();
        if(rList == null){
            rList = new ArrayList<>();
        }
        model.addAttribute("rList",rList);
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("reg_id : "+reg_id);
        log.info("title : "+ title );
        log.info("content : "+contents);

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setTitle(title);
        pDTO.setContents(contents);
        pDTO.setReg_id(reg_id);

        String msg;
        String url = "/getNoticeList";

        int res = 0;
        try {
            res = NoticeService.InsertNoticeInfo(pDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }



        if(res > 0){
            msg = "등록이 성공하셨습니다.";
        }else{
            msg = "등록에 실패하셨습니다.";
        }
        model.addAttribute("msg",msg);
        model.addAttribute("url",url);

        log.info(this.getClass().getName() + " .getNoticeData End !!");
        return "Redirect";
    }
    @GetMapping(value = "index")
    public String indexPage() throws Exception{
        log.info(this.getClass().getName() + ".indexPage Start!!");
        log.info(this.getClass().getName() + ".indexPage End!!");
        return "index";
    }
    @GetMapping(value = "noticeInfo")
    public String noticeInfo() throws Exception{
        log.info(this.getClass().getName() + ".noticeInfo Start!!");
        log.info(this.getClass().getName() + ".noticeInfo End!!");
        return "form";
    }
    @PostMapping(value = "getNoticeData")
    public String getNoticeData (HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName()+ ".getNoticeData Start!!");
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        log.info("title : " + title);
        log.info("content : "+contents);
        log.info("reg_id : "+reg_id);
        model.addAttribute("title",title);
        model.addAttribute("contents",contents);
        model.addAttribute("reg_id",reg_id);
        log.info(this.getClass().getName()+" .getNoticeData End !!");
        return "getNoticeData";
    }
    @RequestMapping(value="getNoticeList")
    public String getNoticeList(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + ".getNoticeList Start!!");

        List<NoticeDTO> rList = NoticeService.getNoticeList();
        log.info(String.valueOf(rList.size()));
        if(rList == null){
            rList = new ArrayList<>();
        }
        model.addAttribute("rList",rList);

        log.info(this.getClass().getName() + " .getNoticeList End!!");
        return "NoticeList";
    }
    @RequestMapping(value = "NoticeDelete")
    public String NoticeDelete(HttpServletRequest request,Model model) throws Exception{
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        NoticeDTO nDTO = new NoticeDTO();
        nDTO.setNotice_seq(notice_seq);
        int res = NoticeService.NoticeDelete(nDTO);
        log.info("res : " + res);
        String msg;
        String url;

        if(res ==1){
            msg = "삭제 성공 !!";
            url = "getNoticeList";
        }else{
            msg = "삭제 실패 !!";
            url = "NoticeDetail?no="+ notice_seq;
        }
        model.addAttribute("msg",msg);
        model.addAttribute("url",url);
        return "Redirect";
    }
    @RequestMapping(value = "NoticeChange")
    public String NoticeChange(HttpServletRequest request, Model model) throws Exception{
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));
        NoticeDTO cDTO = new NoticeDTO();

        cDTO.setNotice_seq(notice_seq);
        cDTO.setTitle(title);
        cDTO.setContents(contents);

        int res = NoticeService.NoticeChange(cDTO);

        String msg;
        String url;

        if(res == 1){
            msg = " 수정을 시작합니다 !!";
            url = "NoticeChange";
        }else{
            msg = "수정을 시작하지 못했습니다 !!";
            url = "NoticeDetail?no="+notice_seq;
        }
        model.addAttribute("msg",msg);
        model.addAttribute("url",url);

        return "Redirect";
    }
}
