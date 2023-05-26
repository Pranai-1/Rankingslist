package com.rankings.pranai.rankingslist.ranking.t20;

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

@Controller
public class T20TeamsController {

	@Autowired
private T20TeamsRepository t20repo;
	private static int count=10;

	@RequestMapping("t20")
	public String showTestRankings(ModelMap model){
		List<T20Teams> list= t20repo.findAll(Sort.by(Sort.Direction.DESC,"rating"));
		model.addAttribute("list",list);
       return "t20rankings";
		 
	}
	@RequestMapping(value="t20update",method=RequestMethod.GET)
	public String updateRankings(@RequestParam int id,ModelMap model) {
		T20Teams team=t20repo.findById(id).get();
		model.addAttribute("team", team);
		return "updateRanks";
	}
	@RequestMapping(value="t20update",method=RequestMethod.POST)
	public String updatedRankings(T20Teams team,ModelMap model) {
		team.setUsername(getLoggedUserName());
		t20repo.save(team);
		return "redirect:t20";
	}
	@RequestMapping(value="addt20team",method=RequestMethod.GET)
	public String addTeam(ModelMap model) {
		String username=getLoggedUserName();
		T20Teams team=new T20Teams(++count,"",1,1,1,username);
		model.addAttribute("addingnewteam", team);
		return "addingTeam";
	}
	@RequestMapping(value="addt20team",method=RequestMethod.POST)
	public String addedTeam(T20Teams team,ModelMap model) {
		String username=getLoggedUserName();
		team.setUsername(username);
		t20repo.save(team);
		return "redirect:t20";
	}
	
	public String getLoggedUserName() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}

