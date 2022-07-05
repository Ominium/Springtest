package kopo.poly.cotroller;
import kopo.poly.dto.NoticeDTO;
import kopo.poly.service.INoticeService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class NoticeController {

    @Resource(name = "NoticeService")
    private INoticeService noticeService;
    @RequestMapping(value = "getInsertNotice")
    public String getInsertNotice(HttpServletRequest request, Model model){
        log.info(this.getClass().getName() + " .getNoticeData Start !!");
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

        int res = 0;
        try {
            res = noticeService.InsertNoticeInfo(pDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String msg;
        String url = "/getNoticeList";

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

        List<NoticeDTO> rList = noticeService.getNoticeList();
        log.info(String.valueOf(rList.size()));
        if(rList == null){
            rList = new ArrayList<>();
        }
        model.addAttribute("rList",rList);

        log.info(this.getClass().getName() + " .getNoticeList End!!");
        return "NoticeList";
    }
}
