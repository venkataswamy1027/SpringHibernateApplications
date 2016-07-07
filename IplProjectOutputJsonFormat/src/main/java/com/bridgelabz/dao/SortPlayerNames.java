package com.bridgelabz.dao;
import java.util.*;
import java.util.Comparator;
import com.bridgelabz.model.PlayerDto;
public class SortPlayerNames implements Comparator<PlayerDto>
{
	public int compare(PlayerDto o1, PlayerDto o2) {
		System.out.println("hi 12");
		/*PlayerDto p1=(PlayerDto)o1;
		PlayerDto p2=(PlayerDto)o2;*/
		return o1.name.compareTo(o2.name);
	}

}
