package de.mobilityhacks.ydda.youdontdrivealone;
import java.util.ArrayList;
import java.util.List;

public class RankingList {
	ArrayList<Person> unsorted = new ArrayList<Person>();
	ArrayList<Person> sorted = new ArrayList<Person>();

	ArrayList<Person> sortList() {
		Person[] tosort = new Person[unsorted.size()];
		for(int k = 0; k < tosort.length; k++) {
			tosort[k] = unsorted.get(k);
		}
		for(int i = 0; i < tosort.length; i++) {
			for (int j = 0; j < tosort.length; j++) {
				if (((i+j) < tosort.length) && (tosort[i].getAbsoluteXP() < tosort[i+j].getAbsoluteXP())) {
					Person temp = tosort[i];
					tosort[i] = tosort[i+j];
					tosort[i+j] = temp;
				}
			}
		}
		
		for(int l = 0; l < tosort.length; l++){
			sorted.add(tosort[l]);
		}
		return sorted;
	}
}