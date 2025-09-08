package kr.ac.kopo.wsk.springbootj_dbctest.Controller;

import kr.ac.kopo.wsk.springbootj_dbctest.domain.Member;
import kr.ac.kopo.wsk.springbootj_dbctest.repository.MemberRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exam02")
public class Example02Controller {
    @Autowired
    MemberRepository02 repository;

    @GetMapping
    public String viewHomepage(Model model) {
        Iterable<Member> memberList = repository.findAll(); //select*from member
        model.addAttribute("memberList", memberList);
        return "viewpage02";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "viewpage02_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member) {
        repository.save(member);

        return "redirect:/exam02";
    }

    @GetMapping("/edit/{id}")
    public String editMethod(@PathVariable (name ="id") int id, Model model) {
        //select*from member where id=1
        Optional<Member>member=repository.findById(id);
        model.addAttribute("member", member);
        return "viewpage02_edit";
    }

    @PostMapping("/update")
    public String updateMethod(@ModelAttribute("member") Member member) {
        //update member set name='유현주',age=29,email='hyunju@naver.com' where id=1
        repository.save(member);
        return "redirect:/exam02";
    }

     @GetMapping("/delete/{id}")
    public String deleteMethod(@PathVariable (name ="id") int id) {
        repository.deleteById(id);
        return "redirect:/exam02";
     }
}

