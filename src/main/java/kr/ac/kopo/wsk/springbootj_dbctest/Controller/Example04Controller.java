package kr.ac.kopo.wsk.springbootj_dbctest.Controller;

import kr.ac.kopo.wsk.springbootj_dbctest.domain.Member;
import kr.ac.kopo.wsk.springbootj_dbctest.repository.MemberRepository04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//EntityManager Test를 위한 Controller
@Controller
@RequestMapping("/exam04")
public class Example04Controller {
    @Autowired
    MemberRepository04 repository;

    @GetMapping
    public String viewHomepage(Model model) {
        Iterable<Member> memberList = repository.selectMethod();
        model.addAttribute("memberList", memberList);
        return "viewpage04";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        model.addAttribute("member", new Member());
        return "viewpage04_new";
    }

    @PostMapping("/insert")
    public String insertMethod(Member member) {
    repository.insertMethod(member);
    return "redirect:/exam04";
    }

    @GetMapping("/edit/{id}")
    public String editMethod(Model model, @PathVariable("id") int id) {
        Member member = repository.selectMethod(id);
        model.addAttribute("member", member);
        return "viewPage04_edit";
    }

    @PostMapping("/update")
    public String updateMethod(Member member) {
        repository.updateMethod(member);
        return "redirect:/exam04";
    }

    @GetMapping("/delete")
    public String deleteMethod(@PathVariable("id") int id) {
        repository.deleteMethod(id);
        return "redirect:/exam04";
    }
}
