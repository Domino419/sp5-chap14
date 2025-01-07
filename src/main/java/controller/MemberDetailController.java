package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;

@Controller
public class MemberDetailController {

    private static final Log log = LogFactory.getLog(RegisterController.class);

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @GetMapping("/members/{id}")
    public String Detail(@PathVariable("id") Long memId, Model model){
        Member member = memberDao.selectById(memId);
        log.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::: MemberDetailController#Detail() ::::" + member.getId());

        if(member == null){
            throw new MemberNotFoundException() ;
        }
        model.addAttribute("member", member);
        return "member/memberDetail";
    }

}
