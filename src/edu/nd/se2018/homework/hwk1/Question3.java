package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	List<Integer> ls = Arrays.stream(numbers).boxed().collect(Collectors.toList());
    	int curLen = ls.size();
    	
    	// check each sub array length until we find a mirror
    	for(int i = 0; i < (ls.size() - curLen) + 1; i++) {
    		List<Integer> subList = ls.subList(i, i+curLen);
    		List<Integer> reversed = ls;
    		Collections.reverse(reversed);
    		
    		boolean done = true;
    		for(int j = 0; j < subList.size(); j++) {
    			if (subList.get(j) != reversed.get(j)) {
    				done = false;
    				break;
    			}
    		}
    		if (done) {
    			return curLen;
    		}
    	}
    	
		return 1;	
	}
}
