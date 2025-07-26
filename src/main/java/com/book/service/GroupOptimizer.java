package com.book.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.book.utility.BookConstant;

@Component
public class GroupOptimizer {

		public void optimizeGroups(List<List<Integer>> groups) {
			Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

			for (List<Integer> group : groups) {
				int size = (int) group.stream().filter(number -> number > 0).count();
				freqMap.put(size, freqMap.getOrDefault(size, 0) + 1);
			}

			int min = Math.min(freqMap.getOrDefault(BookConstant.Group_Five, 0),
					freqMap.getOrDefault(BookConstant.Group_Three, 0));
			for (int i = 0; i < min; i++) {
				freqMap.put(BookConstant.Group_Five, freqMap.get(BookConstant.Group_Five) - 1);
				freqMap.put(BookConstant.Group_Three, freqMap.get(BookConstant.Group_Three) - 1);
				freqMap.put(BookConstant.Group_Four, freqMap.getOrDefault(BookConstant.Group_Four, 0) + 2);
			}

			groups.clear();
			for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
				for (int i = 0; i < e.getValue(); i++) {
					groups.add(Collections.nCopies(e.getKey(), 1));
				}
			}
		}
	}