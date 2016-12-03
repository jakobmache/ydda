package de.mobilityhacks.ydda.youdontdrivealone;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		RankingList a = new RankingList();
		Person p1 = new Person();
		p1.absoluteXP = 2;
		Person p2 = new Person();
		p2.absoluteXP = 5;
		Person p3 = new Person();
		p3.absoluteXP = 9;
		Person p4 = new Person();
		p4.absoluteXP = 3;
		ArrayList<Person> b = new ArrayList<Person>();
		b.add(p1);
		b.add(p2);
		b.add(p3);
		b.add(p4);
		a.unsorted = b;
		ArrayList<Person> sort = a.sortList();
		
		System.out.println(sort.get(0).absoluteXP);
		System.out.println(sort.get(1).absoluteXP);
		System.out.println(sort.get(2).absoluteXP);
		System.out.println(sort.get(3).absoluteXP);
	}
}
