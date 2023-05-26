package com.rankings.pranai.rankingslist.ranking.odi;

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
public class OdiTeamsController {

	@Autowired
private OdiTeamsRepository odirepo;
	private static int count=10;
	
	
	@RequestMapping("odi")
	public String showTestRankings(ModelMap model){
		List<OdiTeams> list= odirepo.findAll(Sort.by(Sort.Direction.DESC,"rating"));
		model.addAttribute("list",list);
       return "odirankings";
		 
	}
	@RequestMapping(value="odiupdate",method=RequestMethod.GET)
	public String updateRankings(@RequestParam int id,ModelMap model) {
		OdiTeams team=odirepo.findById(id).get();
		model.addAttribute("team", team);
		return "updateRanks";
	}
	@RequestMapping(value="odiupdate",method=RequestMethod.POST)
	public String updatedRankings(OdiTeams team,ModelMap model) {
		team.setUsername(getLoggedUserName());
		odirepo.save(team);
		return "redirect:odi";
	}
	@RequestMapping(value="addoditeam",method=RequestMethod.GET)
	public String addTeam(ModelMap model) {
		String username=getLoggedUserName();
		OdiTeams team=new OdiTeams(++count,"",1,1,1,username);
		model.addAttribute("addingnewteam", team);
		return "addingTeam";
	}
	@RequestMapping(value="addoditeam",method=RequestMethod.POST)
	public String addedTeam(OdiTeams team,ModelMap model) {
		String username=getLoggedUserName();
		team.setUsername(username);
		odirepo.save(team);
		return "redirect:odi";
	}
	
	public String getLoggedUserName() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}

