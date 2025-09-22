package kr.ac.kopo.wsk.springbootj_dbctest.Controller;

import kr.ac.kopo.wsk.springbootj_dbctest.domain.Player;
import kr.ac.kopo.wsk.springbootj_dbctest.domain.Team;
import kr.ac.kopo.wsk.springbootj_dbctest.repository.PlayerRepository;
import kr.ac.kopo.wsk.springbootj_dbctest.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exam07")
public class Example07Controller {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public Example07Controller(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public String requestInsert(Model model) {
        Team team = new Team();
        team.setName("team01");
        teamRepository.save(team);

        Player player = new Player();
        player.setName("김플리");
        player.setTeam(team);
        playerRepository.save(player);

        List<Player> players = playerRepository.findAll();
        List<Team> teams = teamRepository.findAll();


        model.addAttribute("teams", teams);
        model.addAttribute("players", players);

        return "viewPage07";
    }
}
