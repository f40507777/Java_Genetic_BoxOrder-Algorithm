package demo;

import java.util.ArrayList;
import java.util.Arrays;

public class GA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GA_Box Box=new GA_Box();
		ArrayList<Integer> gold = new ArrayList<Integer>();
		for(int i=0;i<50;i++){
			gold.add(Box.Random());
		}
		System.out.println(gold);
		
		
	}

}
