package com.rankings.pranai.rankingslist.ranking.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TestTeamsController {

	@Autowired
private TestTeamsRepository testrepo;
	private static int count=10;
	
	@RequestMapping("rankings")
	public String showRankings(ModelMap model){
       return "rankingslist";
		 
	}

	@RequestMapping("test")
	public String showTestRankings(ModelMap model){
		List<TestTeams> list= testrepo.findAll(Sort.by(Sort.Direction.DESC,"rating"));
		model.addAttribute("list",list);
       return "testrankings";
		 
	}
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateRankings(@RequestParam int id,ModelMap model) {
		TestTeams team=testrepo.findById(id).get();
		model.addAttribute("team", team);
		return "updateRanks";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updatedRankings(TestTeams team,ModelMap model) {
		team.setUsername(getLoggedUserName());
		testrepo.save(team);
		return "redirect:test";
	}
	@RequestMapping(value="addteam",method=RequestMethod.GET)
	public String addTeam(ModelMap model) {
		String username=getLoggedUserName();
		TestTeams team=new TestTeams(++count,"",1,1,1,username);
		model.addAttribute("addingnewteam", team);
		return "addingTeam";
	}
	@RequestMapping(value="addteam",method=RequestMethod.POST)
	public String addedTeam(TestTeams team,ModelMap model) {
		String username=getLoggedUserName();
		team.setUsername(username);
		testrepo.save(team);
		return "redirect:test";
	}
	
	public String getLoggedUserName() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
