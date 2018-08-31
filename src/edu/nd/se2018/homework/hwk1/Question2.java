package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		// Build list of stop words and input words
		List<String> sw = Arrays.stream(stopwords.split(" ")).collect(Collectors.toList());
		Set<String> stopWords = new HashSet<>(sw);
		
		List<String> inputWords = Arrays.stream(input.split(" ")).collect(Collectors.toList());
		Map<String, Integer> wc = new HashMap<>();
		
		// build word counts excluding stop words
		for (String word : inputWords) {
			if(!stopWords.contains(word)) {
				if(wc.containsKey(word)) {
					wc.put(word, wc.get(word) + 1);
				} else {
					wc.put(word, 1);
				}
			}
		}
		
		// get max count
		int max = 0;
		int numCnts = 0;
		String ans = "";
		
		for (Map.Entry<String, Integer> e : wc.entrySet()) {
			String key = e.getKey();
			Integer val = e.getValue();
			
			if (val > max) {
				max = val;
				ans = key;
				numCnts = 1;
			} else if (val == max) {
				numCnts++;
			}
		}
		
		// if there is one winner, return it
		if (numCnts == 1) {
			return ans;
		} else {
			return null;
		}		
	}
}
