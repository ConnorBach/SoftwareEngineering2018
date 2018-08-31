package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		List<Integer> ls = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		Set<Integer> hs = new HashSet<>(ls);
		
		int sum = 0;
		Iterator<Integer> it = hs.iterator();
		while (it.hasNext()) {
			sum += it.next().intValue();
		}
		return sum;	
	}
}
