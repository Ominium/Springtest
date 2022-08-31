package kopo.poly.cotroller;
import kopo.poly.dto.UserDTO;
import kopo.poly.service.IUserService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class userController {
    @Resource(name = "UserService")
    private IUserService UserService;

    @RequestMapping(value = "getInsertUser")
    public String getInsertUser(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " . getInsertUserStart !!");
        List<UserDTO> userList = UserService.getUserList();
        if(userList == null){
            userList = new ArrayList<>();
        }

        model.addAttribute("userList",userList);
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        String user_pwd = CmmUtil.nvl(request.getParameter("user_pwd"));
        String user_email = CmmUtil.nvl(request.getParameter("user_email"));
        String user_name = CmmUtil.nvl(request.getParameter("user_name"));


        UserDTO pDTO = new UserDTO();
        pDTO.setUser_id(user_id);
        pDTO.setUser_pwd(user_pwd);
        pDTO.setUser_email(user_email);
        pDTO.setUser_name(user_name);
        String msg;
        String url = "/getNoticeList";

        int res = 0;
        try {
            res = UserService.InsertUserInfo(pDTO);
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
    @GetMapping(value = "Signup")

    public String indexPage() throws Exception{
        log.info(this.getClass().getName() + ".indexPage Start!!");
        log.info(this.getClass().getName() + ".indexPage End!!");
        return "Signup";
    }
}
