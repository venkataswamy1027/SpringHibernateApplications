package com.bridgelabz.controllers;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bridgelabz.dao.JsonControllerDaoImpl;
import com.bridgelabz.dao.JsonDao;
import com.bridgelabz.model.PlayerDto;
import com.bridgelabz.model.TeamDto;
@Controller("abc")
public class JsonController 
{
		//the @Autowired annotation tells Spring where an injection needs to occur.
		@Autowired
		private JsonDao play;
		/* here matching with respective url pattern and open their respective view pages*/ 
		@RequestMapping(value="/ipl.html", method = RequestMethod.GET)
		public ModelAndView iplHome() 
		{
			Map<String, Object> model = new HashMap<String, Object>();
			return new ModelAndView("iplhome",model);
		}
		@RequestMapping(value="/sort", method = RequestMethod.GET)
		public ModelAndView searchbyname(@RequestParam(value="sort_field", required=true) String sort_field,@RequestParam(value="sort_order", required=true) String sort_order) 
		{
			System.out.println("aaa1");
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println("aaa2");
			System.out.println(sort_field);
			System.out.println(sort_order);
			model.put("playerlist", play.sort_Player_Info(sort_field,sort_order));
			System.out.println("aaa3");
			return new ModelAndView("asc_desc",model);
			
		}
		//--------display the Delhi DareDevils team list-------- 
		@RequestMapping("ddteamview")
		public String DDPlayerList(Model model) {
			model.addAttribute("playerdto", new TeamDto());
			Model result = model.addAttribute("ddteam",play.delhiDareDevilsTeamList());
			return "ddTeamPlayer";
		}
		/*------display the DDplayer list demo------*/
		@RequestMapping("ddplayerview")
		public String playerList(Model model) {
			model.addAttribute("playerdto", new PlayerDto());
			Model result = model.addAttribute("playerlist",play.delhiDareDevilsPlayerList());
			return "playerlist";
		}
		/*--------display the Gujrat Lions team list-------- */
		@RequestMapping("glteamview")
		public String gujratTeamList(Model model) {
			model.addAttribute("playerdto", new TeamDto());
			Model result = model.addAttribute("ddteam", this.play.gujratTeam());
			return "ddTeamPlayer";
		}
		/*------ display the Gujrat Lion PlayerList-------*/
		@RequestMapping("glplayerview")
		public String gujratPlayerList(Model model) {
			model.addAttribute("playerdto", new PlayerDto());
			Model result = model.addAttribute("playerlist", this.play.gujratPlayerList());
			return "playerlist";
		}
		/*--------display the punjab team list-------- */
		@RequestMapping("kxipteamview")
		public String kpTeamList(Model model) {
			model.addAttribute("playerdto", new TeamDto());
			Model result = model.addAttribute("ddteam", this.play.punjabTeam());
			return "ddTeamPlayer";
		}
		/*------ display the KP  PlayerList-------*/
		@RequestMapping("kxiplayerview")
		public String punjabPlayerList(Model model) {
			model.addAttribute("playerdto", new PlayerDto());
			Model result = model.addAttribute("playerlist", this.play.punjabPlayerList());
			return "playerlist";
		}
		
		/*--------display the KKR team list--------*/
		@RequestMapping("kkrteamview")
		public String kkrTeamList(Model model) {
			model.addAttribute("playerdto", new TeamDto());
			Model result = model.addAttribute("ddteam", this.play.kkrTeam());
			return "ddTeamPlayer";
		}
		/*------ display the KKr  PlayerList-------*/
		@RequestMapping("kkrplayerview")
		public String kkrPlayerList(Model model) {
			model.addAttribute("playerdto", new PlayerDto());
			Model result = model.addAttribute("playerlist", this.play.kkrPlayerList());
			return "playerlist";
		}
		/*--------display the Mumbai indians team list--------*/
		@RequestMapping("mumbaiteamview")
		public String mumbaiTeamList(Model model) {
			model.addAttribute("playerdto", new TeamDto());
			Model result = model.addAttribute("ddteam", this.play.mumbaiIndiansTeam());
			return "ddTeamPlayer";
		}
		/*------ display the mumbai indians PlayerList-------*/
		@RequestMapping("mumbaiplayerview")
		public String mumbaiPlayerList(Model model) {
			model.addAttribute("playerdto", new PlayerDto());
			Model result = model.addAttribute("playerlist", this.play.mumbaiPlayerList());
			return "playerlist";
		}
		/*--------display the Rising pune team list--------*/
		@RequestMapping("puneteamview")
		public String puneTeamList(Model model) {
			model.addAttribute("playerdto", new TeamDto());
			Model result = model.addAttribute("ddteam", this.play.risingPuneTeam());
			return "ddTeamPlayer";
		}
		/*------ display the rising pune PlayerList-------*/
		@RequestMapping("puneplayerview")
		public String punePlayerList(Model model) {
			model.addAttribute("playerdto", new PlayerDto());
			Model result = model.addAttribute("playerlist", this.play.risingPunePlayerList());
			return "playerlist";
		}
		/*--------display the royal challenges team list--------*/
		@RequestMapping("rcbteamview")
		public String rcbTeamList(Model model) {
			model.addAttribute("playerdto", new TeamDto());
			Model result = model.addAttribute("ddteam", this.play.royalChallengesTeam());
			return "ddTeamPlayer";
		}
		/*------ display the royal challenges PlayerList-------*/
		@RequestMapping("rcbplayerview")
		public String rcbPlayerList(Model model) {
			model.addAttribute("playerdto", new PlayerDto());
			Model result = model.addAttribute("playerlist", this.play.royalChallengesPlayerList());
			return "playerlist";
		}
		/*--------display the sunrise hydrabad team list--------*/
		@RequestMapping("sunriseteamview")
		public String sunriseTeamList(Model model) {
			model.addAttribute("playerdto", new TeamDto());
			Model result = model.addAttribute("ddteam", this.play.sunriseHydrabadTeam());
			return "ddTeamPlayer";
		}
		/*------ display the sunrise hydrabad PlayerList-------*/
		@RequestMapping("sunriseplayerview")
		public String sunrisesPlayerList(Model model) {
			model.addAttribute("playerdto", new PlayerDto());
			Model result = model.addAttribute("playerlist", this.play.sunriseHydrabadPlayerList());
			System.out.println(result);
			return "playerlist";
		}
	}
	