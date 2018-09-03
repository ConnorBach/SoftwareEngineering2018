package edu.nd.se2018.homework.hwk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	List<Integer> ls = Arrays.stream(numbers).boxed().collect(Collectors.toList());
    	int curLen = ls.size();
    	int maxLen = 0;
    	System.out.println(ls);
    	
    	// generate sub sequences, updating max len as we go
    	// can use bitmasks to generate sub sequences
    	List<Integer> bitmasks = new ArrayList<Integer>();
    	for (int i = 0; i < curLen; i++) {
    		bitmasks.add(1<<i);
    	}
    	
    	for (int i = 0; i < (1 << curLen); i++) {
    		// generate subsequence
    		List<Integer> subseq = new ArrayList<Integer>();
    		for (int j = 0; j < curLen; j++) {
    			if ((bitmasks.get(j) & i) != 0) {
        			subseq.add(ls.get(j));
    			}
    		}
    		    		
    		// check if the reversed subsequence is also in the list, update max len
    		List<Integer> revSubseq = new ArrayList<>(subseq);
    		Collections.reverse(revSubseq);
    		int check = Collections.indexOfSubList(ls, subseq);
    		int checkRev = Collections.indexOfSubList(ls, revSubseq);
    		if (subseq.size() > maxLen && check != -1 && checkRev != -1) {
    			maxLen = subseq.size();
    		}
    	}
    	
		return maxLen;	
	}
}
