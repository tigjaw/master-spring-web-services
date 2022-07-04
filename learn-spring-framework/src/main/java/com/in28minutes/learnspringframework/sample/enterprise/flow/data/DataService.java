package com.in28minutes.learnspringframework.sample.enterprise.flow.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataService {
	// getting data
	
	public List<Integer> retrieveData() {
		return Arrays.asList(12,34,56,34,65,23);
	}
}