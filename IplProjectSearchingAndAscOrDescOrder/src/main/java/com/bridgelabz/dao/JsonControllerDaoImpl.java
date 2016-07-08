package com.bridgelabz.dao;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.model.PlayerDto;
import com.bridgelabz.model.TeamDto;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
@Repository("dd")
public class JsonControllerDaoImpl implements JsonDao {
	@Autowired
	SessionFactory sessionFactory;
	/*delhiDareDevils team function */
	public ArrayList<TeamDto> delhiDareDevilsTeamList() {
			ArrayList<TeamDto> array1 = new ArrayList<TeamDto>();
			JSONParser parser = new JSONParser();

			try {
				//read json file data  from local repository
				FileReader fileread = new FileReader(
						"/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLTeam/DelhiDareDevilsTeam.json");

				Object obj = parser.parse(fileread);
				JSONArray array = (JSONArray) obj;

				for (int i = 0; i < array.size(); i++) {
					JSONObject jsonObject = (JSONObject) array.get(i);
					String name = jsonObject.get("Name").toString();
					System.out.println("json  name"+name);
					JSONArray jsonArray = (JSONArray) jsonObject.get("DDTeamList");

					for (int j = 0; j < jsonArray.size(); j++) {
						System.out.println("inner for ");
						TeamDto DDplayer = new TeamDto();
						JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
						DDplayer.setName(jsonObjectArray.get("team_name").toString());
						DDplayer.setCouch(jsonObjectArray.get("team_coach").toString());
						DDplayer.setCaptain(jsonObjectArray.get("team_captain").toString());
						DDplayer.setVeneue(jsonObjectArray.get("team_home_venue").toString());
						DDplayer.setOwner(jsonObjectArray.get("team_owner").toString());
						array1.add(DDplayer);
						try
						{
				 			Session session = sessionFactory.openSession();
				 			Transaction tx = session.beginTransaction();
			                session.save(DDplayer);
			                tx.commit();
			                session.close();
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					Iterator<TeamDto> itr = array1.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		return array1;
	}
	/*------delhiDareDevils player function------*/
	public ArrayList<PlayerDto>delhiDareDevilsPlayerList() {
		System.out.println("delhi list while be display shortly");
		ArrayList<PlayerDto>array1=new ArrayList<PlayerDto>();
        JSONParser parser= new JSONParser();
        System.out.println("hi123");

        try {
        	
        	FileReader fileread=new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLPlayer/DelhiDareDevilsPlayer.json");
        	Object obj=parser.parse(fileread);
        	JSONArray array =(JSONArray)obj;
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				String name=jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get("DelhiDereDevilsPlayerList");
				
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerDto player=new PlayerDto();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					 array1.add(player);
					 try
						{
				 			Session session = sessionFactory.openSession();
				 			Transaction tx = session.beginTransaction();
			                session.save(player);
			                tx.commit();
			                session.close();
						}catch(Exception e)
						{
							e.printStackTrace();
						}
				}
				Iterator< PlayerDto> itr=array1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					
				}
        	}
        }
        	catch (Exception e) {
        		System.out.println("error");
        	}
		return array1;
	
	}
	/*Gujrat Lions team function */ 
	public ArrayList<TeamDto> gujratTeam() {
		ArrayList<TeamDto> array1 = new ArrayList<TeamDto>();
		JSONParser parser = new JSONParser();
		try {
			//read jsonfile data  from local repository
			FileReader fileread = new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLTeam/GujratTeam.json");

			Object obj = parser.parse(fileread);
			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				String name = jsonObject.get("Name").toString();
				System.out.println("json  name"+name);
				JSONArray jsonArray = (JSONArray) jsonObject.get("GujratPlayerList");

				for (int j = 0; j < jsonArray.size(); j++) {
					System.out.println("inner for ");
					TeamDto DDplayer = new TeamDto();
					JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
					DDplayer.setName(jsonObjectArray.get("team_name").toString());
					DDplayer.setCouch(jsonObjectArray.get("team_coach").toString());
					DDplayer.setCaptain(jsonObjectArray.get("team_captain").toString());
					DDplayer.setVeneue(jsonObjectArray.get("team_home_venue").toString());
					DDplayer.setOwner(jsonObjectArray.get("team_owner").toString());
					array1.add(DDplayer);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(DDplayer);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator<TeamDto> itr = array1.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return array1;
	}
	/*------gujrat player function------*/
	public ArrayList gujratPlayerList() {
System.out.println("gujarat list while be display shortly");
		ArrayList<PlayerDto> array1=new ArrayList<PlayerDto>();
        JSONParser parser= new JSONParser();
        
        try {
        	
        	FileReader fileread=new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLPlayer/GujratLionPlayer.json");
        	
        	Object obj=parser.parse(fileread);
        	JSONArray array =(JSONArray)obj;
        	
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				String name=jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get("GujratPlayerList");
				
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerDto player=new PlayerDto();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					 array1.add(player);
					 try
						{
				 			Session session = sessionFactory.openSession();
				 			Transaction tx = session.beginTransaction();
			                session.save(player);
			                tx.commit();
			                session.close();
						}catch(Exception e)
						{
							e.printStackTrace();
						}
				}
				Iterator< PlayerDto> itr=array1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					
				}
        	}
        }
        	catch (Exception e) {
        		System.out.println("error");
        	}
		return array1;
	
	}
	/*Punjab team function */
	public ArrayList punjabTeam() {
		ArrayList<TeamDto> array1 = new ArrayList<TeamDto>();
		JSONParser parser = new JSONParser();

		try {

			FileReader fileread = new FileReader(
					"/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLTeam/PunjabTeam.json");

			Object obj = parser.parse(fileread);
			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				String name = jsonObject.get("Name").toString();
				System.out.println("json  name"+name);
				JSONArray jsonArray = (JSONArray) jsonObject.get("PunjabPlayerList");
				for (int j = 0; j < jsonArray.size(); j++) {
					System.out.println("inner for ");
					TeamDto DDplayer = new TeamDto();
					JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
					DDplayer.setName(jsonObjectArray.get("team_name").toString());
					DDplayer.setCouch(jsonObjectArray.get("team_coach").toString());
					DDplayer.setCaptain(jsonObjectArray.get("team_captain").toString());
					DDplayer.setVeneue(jsonObjectArray.get("team_home_venue").toString());
					DDplayer.setOwner(jsonObjectArray.get("team_owner").toString());
					array1.add(DDplayer);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(DDplayer);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator<TeamDto> itr = array1.iterator();
				while (itr.hasNext()) {
					System.out.println(" in while");
					System.out.println(itr.next());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return array1;
	}
	/*------punjab player function------*/
	public ArrayList punjabPlayerList() {
System.out.println("punjab list while be display shortly");
		
		ArrayList<PlayerDto> array1=new ArrayList<PlayerDto>();
        JSONParser parser= new JSONParser();
        
        try {
        	
        	FileReader fileread=new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLPlayer/punjabPlayer.json");
        	
        	Object obj=parser.parse(fileread);
        	JSONArray array =(JSONArray)obj;
        	
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				String name=jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get("PunjabPlayerList");
				
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerDto player=new PlayerDto();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					 array1.add(player);
					 try
						{
				 			Session session = sessionFactory.openSession();
				 			Transaction tx = session.beginTransaction();
			                session.save(player);
			                tx.commit();
			                session.close();
						}catch(Exception e)
						{
							e.printStackTrace();
						}
				}
				Iterator< PlayerDto> itr=array1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					
				}
        	}
        }
        	catch (Exception e) {
        		System.out.println("error");
        	}
		return array1;
	
	}
	/*Kolkatta (KKR) team function */
	public ArrayList kkrTeam() {
		ArrayList<TeamDto> array1 = new ArrayList<TeamDto>();
		JSONParser parser = new JSONParser();

		try {

			FileReader fileread = new FileReader(
					"/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLTeam/KKRTeam.json");

			Object obj = parser.parse(fileread);
			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				String name = jsonObject.get("Name").toString();
				System.out.println("json  name"+name);
				JSONArray jsonArray = (JSONArray) jsonObject.get("KKRPlayerList");

				for (int j = 0; j < jsonArray.size(); j++) {
					System.out.println("inner for ");
					TeamDto DDplayer = new TeamDto();
					JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
					DDplayer.setName(jsonObjectArray.get("team_name").toString());
					DDplayer.setCouch(jsonObjectArray.get("team_coach").toString());
					DDplayer.setCaptain(jsonObjectArray.get("team_captain").toString());
					DDplayer.setVeneue(jsonObjectArray.get("team_home_venue").toString());
					DDplayer.setOwner(jsonObjectArray.get("team_owner").toString());
					array1.add(DDplayer);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(DDplayer);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator<TeamDto> itr = array1.iterator();
				while (itr.hasNext()) {
					
					System.out.println(itr.next());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return array1;
	}
	/*------KKR player function------*/
	public ArrayList kkrPlayerList() {
System.out.println("kolkatta list while be display shortly");
		
		ArrayList<PlayerDto> array1=new ArrayList<PlayerDto>();
        JSONParser parser= new JSONParser();
        
        try {
        	
        	FileReader fileread=new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLPlayer/KKRPlayer.json");
        	
        	Object obj=parser.parse(fileread);
        	JSONArray array =(JSONArray)obj;
        	
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				String name=jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get("KKRPlayer");
				
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerDto player=new PlayerDto();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					array1.add(player);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(player);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator< PlayerDto> itr=array1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					
				}
        	}
        }
        	catch (Exception e) {
        		System.out.println("error");
        	}
		return array1;
	
	}
	/*MumbaiIndians team function */
	public ArrayList mumbaiIndiansTeam() {
		ArrayList<TeamDto> array1 = new ArrayList<TeamDto>();
		JSONParser parser = new JSONParser();

		try {

			FileReader fileread = new FileReader(
					"/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLTeam/MumbaiIndians.json");

			Object obj = parser.parse(fileread);
			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				String name = jsonObject.get("Name").toString();
				System.out.println("json  name"+name);
				JSONArray jsonArray = (JSONArray) jsonObject.get("MumbaiPlayerList");

				for (int j = 0; j < jsonArray.size(); j++) {
					System.out.println("inner for ");
					TeamDto DDplayer = new TeamDto();
					JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
					DDplayer.setName(jsonObjectArray.get("team_name").toString());
					DDplayer.setCouch(jsonObjectArray.get("team_coach").toString());
					DDplayer.setCaptain(jsonObjectArray.get("team_captain").toString());
					DDplayer.setVeneue(jsonObjectArray.get("team_home_venue").toString());
					DDplayer.setOwner(jsonObjectArray.get("team_owner").toString());
					array1.add(DDplayer);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(DDplayer);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator<TeamDto> itr = array1.iterator();
				while (itr.hasNext()) {
				
					System.out.println(itr.next());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return array1;
	}
	/*------MumbaiIndians player function------*/
	public ArrayList mumbaiPlayerList() {
System.out.println("mumbai list while be display shortly");
		
		ArrayList<PlayerDto> array1=new ArrayList<PlayerDto>();
        JSONParser parser= new JSONParser();
        
        try {
        	
        	FileReader fileread=new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLPlayer/MumbaiPlayer.json");
        	
        	Object obj=parser.parse(fileread);
        	JSONArray array =(JSONArray)obj;
        	
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				String name=jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get("MumbaiPlayerList");
				
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerDto player=new PlayerDto();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					array1.add(player);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(player);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator< PlayerDto> itr=array1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					
				}
        	}
        }
        	catch (Exception e) {
        		System.out.println("error");
        	}
		return array1;
	
	}
/* rising Pune team function*/
	public ArrayList risingPuneTeam() {
		ArrayList<TeamDto> array1 = new ArrayList<TeamDto>();
		JSONParser parser = new JSONParser();

		try {

			FileReader fileread = new FileReader(
					"/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLTeam/RisingPune.json");

			Object obj = parser.parse(fileread);
			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				String name = jsonObject.get("Name").toString();
				System.out.println("json  name"+name);
				JSONArray jsonArray = (JSONArray) jsonObject.get("PunePlayerList");

				for (int j = 0; j < jsonArray.size(); j++) {
					System.out.println("inner for ");
					TeamDto DDplayer = new TeamDto();
					JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
					DDplayer.setName(jsonObjectArray.get("team_name").toString());
					DDplayer.setCouch(jsonObjectArray.get("team_coach").toString());
					DDplayer.setCaptain(jsonObjectArray.get("team_captain").toString());
					DDplayer.setVeneue(jsonObjectArray.get("team_home_venue").toString());
					DDplayer.setOwner(jsonObjectArray.get("team_owner").toString());
					array1.add(DDplayer);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(DDplayer);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator<TeamDto> itr = array1.iterator();
				while (itr.hasNext()) {
					
					System.out.println(itr.next());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return array1;
	}
	/*------rising pune player function------*/
	public ArrayList risingPunePlayerList() {
System.out.println("pune list while be display shortly");
		
		ArrayList<PlayerDto> array1=new ArrayList<PlayerDto>();
        JSONParser parser= new JSONParser();
        
        try {
        	
        	FileReader fileread=new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLPlayer/RisingPunePlayer.json");
        	
        	Object obj=parser.parse(fileread);
        	JSONArray array =(JSONArray)obj;
        	
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				String name=jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get("PunePlayerList");
				
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerDto player=new PlayerDto();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					array1.add(player);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(player);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator< PlayerDto> itr=array1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					
				}
        	}
        }
        	catch (Exception e) {
        		System.out.println("error");
        	}
		return array1;
		}
	/* RCB team function */
	public ArrayList royalChallengesTeam() {
		ArrayList<TeamDto> array1 = new ArrayList<TeamDto>();
		JSONParser parser = new JSONParser();

		try {

			FileReader fileread = new FileReader(
					"/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLTeam/RoyalChallenges.json");

			Object obj = parser.parse(fileread);
			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				String name = jsonObject.get("Name").toString();
				System.out.println("json  name"+name);
				JSONArray jsonArray = (JSONArray) jsonObject.get("RoyalChallengeList");

				for (int j = 0; j < jsonArray.size(); j++) {
					System.out.println("inner for ");
					TeamDto DDplayer = new TeamDto();
					JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
					DDplayer.setName(jsonObjectArray.get("team_name").toString());
					DDplayer.setCouch(jsonObjectArray.get("team_coach").toString());
					DDplayer.setCaptain(jsonObjectArray.get("team_captain").toString());
					DDplayer.setVeneue(jsonObjectArray.get("team_home_venue").toString());
					DDplayer.setOwner(jsonObjectArray.get("team_owner").toString());
					array1.add(DDplayer);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(DDplayer);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator<TeamDto> itr = array1.iterator();
				while (itr.hasNext()) {
					System.out.println(" in while");
					System.out.println(itr.next());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return array1;
	}
	/*------royal challenge player function------*/
	public ArrayList royalChallengesPlayerList() {
System.out.println("rcb list while be display shortly");
		
		ArrayList<PlayerDto> array1=new ArrayList<PlayerDto>();
        JSONParser parser= new JSONParser();
        
        try {
        	
        	FileReader fileread=new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLPlayer/RoyalChallenges.json");
        	
        	Object obj=parser.parse(fileread);
        	JSONArray array =(JSONArray)obj;
        	
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				String name=jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get("RoyalChallengePlayerList");
				
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerDto player=new PlayerDto();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					array1.add(player);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(player);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator< PlayerDto> itr=array1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					
				}
        	}
        }
        	catch (Exception e) {
        		System.out.println("error");
        	}
		return array1;
	
	}
	/*Sunrise Hydrabad Team function */
	public ArrayList sunriseHydrabadTeam() {
		

		ArrayList<TeamDto> array1 = new ArrayList<TeamDto>();
		JSONParser parser = new JSONParser();

		try {

			FileReader fileread = new FileReader(
					"/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLTeam/SunriseHydrabad.json");

			Object obj = parser.parse(fileread);
			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				String name = jsonObject.get("Name").toString();
				System.out.println("json  name"+name);
				JSONArray jsonArray = (JSONArray) jsonObject.get("SunrisersHyderabadList");

				for (int j = 0; j < jsonArray.size(); j++) {
					System.out.println("inner for ");
					TeamDto DDplayer = new TeamDto();
					JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
					DDplayer.setName(jsonObjectArray.get("team_name").toString());
					DDplayer.setCouch(jsonObjectArray.get("team_coach").toString());
					DDplayer.setCaptain(jsonObjectArray.get("team_captain").toString());
					DDplayer.setVeneue(jsonObjectArray.get("team_home_venue").toString());
					DDplayer.setOwner(jsonObjectArray.get("team_owner").toString());
					array1.add(DDplayer);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(DDplayer);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator<TeamDto> itr = array1.iterator();
				while (itr.hasNext()) {
					
					System.out.println(itr.next());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return array1;
	}
	/*------Sunrise hydrabad player function------*/
	public ArrayList sunriseHydrabadPlayerList() {
System.out.println("hyd list while be display shortly");
		
		ArrayList<PlayerDto> array1=new ArrayList<PlayerDto>();
        JSONParser parser= new JSONParser();
        
        try {
        	
        	FileReader fileread=new FileReader("/home/bridgeit/Desktop/IplProjectASCorDESCOrderWithJsp/src/main/jsonfile/IPLPlayer/SunriseHydrabad.json");
        	
        	Object obj=parser.parse(fileread);
        	JSONArray array =(JSONArray)obj;
        	
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				String name=jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get("SunRiseHydrabadPlayerList");
				
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerDto player=new PlayerDto();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					array1.add(player);
					try
					{
			 			Session session = sessionFactory.openSession();
			 			Transaction tx = session.beginTransaction();
		                session.save(player);
		                tx.commit();
		                session.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				Iterator< PlayerDto> itr=array1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					
				}
        	}
        }
        	catch (Exception e) {
        		System.out.println("error");
        	}
		return array1;
	
	}
	/*converting json string data to date format of data */
	public Date stringToDate(String abc){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		try {
			return formatter.parse(abc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/* sort player information in ascending or descending order */
	public ArrayList sort_Player_Info( String sort_field,String sort_order) {
		System.out.println("ccc1");
		System.out.println(sort_field);
		System.out.println(sort_order);
		PlayerDto player=new PlayerDto();
		Session session = sessionFactory.openSession();
		boolean listFound = false;
		String SQL_QUERY ="from PlayerDto ORDER BY "+sort_field+" "+sort_order;
		Query query = session.createQuery(SQL_QUERY);
		/*query.setParameter(0,sort_field);
		query.setParameter(1,sort_order);*/
		System.out.println("sort Query executing :"+query);
		 List list = query.list();
			System.out.println("sort list is :"+list);
			System.out.println("bbb1");
			if ((list != null) && (list.size() > 0)) 
			{
				System.out.println("bbb2");
				listFound= true;
			}
			System.out.println("bbb3");
			session.close();
			System.out.println("bbb4");
			return (ArrayList) list;
	}
	/*search information implementation */
	public ArrayList search_Info(String search_field,String search_item){
		PlayerDto player=new PlayerDto();
		Session session = sessionFactory.openSession();
		boolean listFound = false;
		if((search_field==null)&&(search_item==null))
		{
			return null;
		}
		else
		{
		String SQL_QUERY =" from PlayerDto as o where o."+search_field+" LIKE "+"'%"+search_item+"%'";
		Query query = session.createQuery(SQL_QUERY);
		System.out.println(" search Query executing :"+query);
        List list = query.list();
		System.out.println("list is :"+list);
		System.out.println("sss");
		if ((list != null) && (list.size() > 0)) 
		{
			
			listFound= true;
			System.out.println(listFound);
		}
		System.out.println("sss1");
		session.close();
		System.out.println("sss2");
		return (ArrayList) list;
	}
	}
}