package com.product.actuator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "bugfixes")
public class BugFixesActuator {

	private static Map<String ,List<String>> bugsFixMap = new HashMap<String,List<String>>();
	
	@PostConstruct
	public void init() {
		bugsFixMap.put("v1", Arrays.asList("Bug 1","Bug 2"));
		bugsFixMap.put("v2", Arrays.asList("Bug 3","Bug 4"));
	}
	
	@ReadOperation
	public Map<String, List<String>> getAllFixBugs(){
		return this.bugsFixMap;
	}
	
	@ReadOperation
	public List<String> getAllFixBugsByVersion(@Selector String version){
		return this.bugsFixMap.get(version);
	}
	
	@WriteOperation
	public void addFixBugs(@Selector String version,String bugFix){
		 this.bugsFixMap.put(version, Arrays.asList(bugFix.split(",")));
	}
	
	@DeleteOperation
	public void removeFixBugs(@Selector String version){
		 this.bugsFixMap.remove(version);
	}
}
