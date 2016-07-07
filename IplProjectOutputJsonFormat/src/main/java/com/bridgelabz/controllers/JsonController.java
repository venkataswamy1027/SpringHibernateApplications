package com.bridgelabz.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.bridgelabz.dao.JsonControllerDaoImpl;
import com.bridgelabz.dao.JsonDao;
import com.bridgelabz.model.PlayerDto;
import com.bridgelabz.model.TeamDto;
@SuppressWarnings("unused")
@RestController
@EnableWebMvc
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
	//--------display the Delhi DareDevils team list-------- 
	@RequestMapping(value="ddteamview", method = RequestMethod.GET,produces = "application/json")
	public String DDTeamList() throws IOException
	{
		ArrayList teamlist=new ArrayList();
		   teamlist= play.delhiDareDevilsTeamList();
		   ObjectMapper mapper = new ObjectMapper();
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamlist);
	}
	/*------display the DDplayer list ------*/
	@RequestMapping(value="ddplayerview",method = RequestMethod.GET,produces = "application/json")
	public String DelhiDareDevilsPlayersList()throws IOException
	{
		ArrayList playerlist=new ArrayList();
		playerlist=play.delhiDareDevilsPlayerList();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playerlist);
	}
	/*--------display the Gujrat Lions team list--------*/ 
	@RequestMapping(value="glteamview",method = RequestMethod.GET,produces = "application/json")
	public String gujratTeamList()throws IOException
	{
			ArrayList teamlist=new ArrayList();
		   teamlist= play.gujratTeam();
		   ObjectMapper mapper = new ObjectMapper();
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamlist);
	}
	/*------ display the Gujrat Lion PlayerList-------*/
	@RequestMapping(value="glplayerview",method = RequestMethod.GET,produces = "application/json")
	public String gujratPlayerList()throws IOException
	{
		ArrayList playerlist=new ArrayList();
		playerlist=play.gujratPlayerList();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playerlist);
	}
	/*--------display the punjab team list--------*/ 
	@RequestMapping(value="kxipteamview",method = RequestMethod.GET,produces = "application/json")
	public String kpTeamList() throws IOException
	{
		System.out.println("a1");
		ArrayList teamlist=new ArrayList();
		teamlist= play.punjabTeam();
		System.out.println("a2");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("a3");
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamlist);
	}
	/*------ display the punjab  PlayerList-------*/
	@RequestMapping(value="kxiplayerview",method = RequestMethod.GET,produces = "application/json")
	public String kpPlayerList()throws IOException
	{
		System.out.println("a4");
		ArrayList playerlist=new ArrayList();
		playerlist=play.punjabPlayerList();
		System.out.println("a5");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("a6");
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playerlist);
		
	}
	/*--------display the KKR team list--------*/
	@RequestMapping(value="kkrteamview",method = RequestMethod.GET,produces = "application/json")
	public String kkrTeamList()throws IOException
	{
			ArrayList teamlist=new ArrayList();
		   teamlist= play.kkrTeam();
		   ObjectMapper mapper = new ObjectMapper();
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamlist);
	}
	/*------ display the KKr  PlayerList-------*/
	@RequestMapping(value="kkrplayerview",method = RequestMethod.GET,produces = "application/json")
	public String kkrPlayerList()throws IOException 
	{
		ArrayList playerlist=new ArrayList();
		playerlist=play.kkrPlayerList();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playerlist);
	}
	/*--------display the Mumbai indians team list--------*/
	@RequestMapping(value="mumbaiteamview",method = RequestMethod.GET,produces = "application/json")
	public String mumbaiTeamList()throws IOException
	{
		   ArrayList teamlist=new ArrayList();
		   teamlist= play.mumbaiIndiansTeam();
		   ObjectMapper mapper = new ObjectMapper();
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamlist);
	}
	/*------ display the mumbai indians PlayerList-------*/
	@RequestMapping(value="mumbaiplayerview",method = RequestMethod.GET,produces = "application/json")
	public String mumbaiPlayerList()throws IOException  
	{
		ArrayList playerlist=new ArrayList();
		playerlist=play.mumbaiPlayerList();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playerlist);
	}
	/*--------display the Rising pune team list--------*/
	@RequestMapping(value="puneteamview",method = RequestMethod.GET,produces = "application/json")
	public String puneTeamList()throws IOException  
	{
		 ArrayList teamlist=new ArrayList();
		   teamlist= play.risingPuneTeam();
		   ObjectMapper mapper = new ObjectMapper();
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamlist);
	}
	/*------ display the rising pune PlayerList-------*/
	@RequestMapping(value="puneplayerview",method = RequestMethod.GET,produces = "application/json")
	public String punePlayerList() throws IOException 
	{
		ArrayList playerlist=new ArrayList();
		playerlist=play.risingPunePlayerList();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playerlist);
	}
	/*--------display the royal challenges team list--------*/
	@RequestMapping(value="rcbteamview",method = RequestMethod.GET,produces = "application/json")
	public String rcbTeamList()throws IOException 
	{
		   ArrayList teamlist=new ArrayList();
		   teamlist= play.royalChallengesTeam();
		   ObjectMapper mapper = new ObjectMapper();
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamlist);
	}
	/*------ display the royal challenges PlayerList-------*/
	@RequestMapping(value="rcbplayerview",method = RequestMethod.GET,produces = "application/json")
	public String rcbPlayerList() throws IOException 
	{
		ArrayList playerlist=new ArrayList();
		playerlist=play.royalChallengesPlayerList();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playerlist);
	}
	/*--------display the sunrise hydrabad team list--------*/
	@RequestMapping(value="sunriseteamview",method = RequestMethod.GET,produces = "application/json")
	public String sunriseTeamList()  throws IOException 
	{
		   ArrayList teamlist=new ArrayList();
		   teamlist= play.sunriseHydrabadTeam();
		   ObjectMapper mapper = new ObjectMapper();
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamlist);
		
	}
	/*------ display the sunrise hydrabad PlayerList-------*/
	@RequestMapping(value="sunriseplayerview",method = RequestMethod.GET,produces = "application/json")
	public String sunrisesPlayerList()throws IOException  
	{
		ArrayList playerlist=new ArrayList();
		playerlist=play.sunriseHydrabadPlayerList();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playerlist);
	}
	
}
