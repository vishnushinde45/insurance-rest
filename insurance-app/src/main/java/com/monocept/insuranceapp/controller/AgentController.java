package com.monocept.insuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.insuranceapp.entity.Agent;
import com.monocept.insuranceapp.entity.Commision;
import com.monocept.insuranceapp.service.AgentService;
import com.monocept.insuranceapp.service.CommisionService;
import com.monocept.insuranceapp.utility.ChangePassword;
import com.monocept.insuranceapp.utility.Mail;
import com.monocept.insuranceapp.utility.WithdrawCommision;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AgentController {
 
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private CommisionService commisionService;
	
	
	@GetMapping("/agents")
	public List<Agent> getAgents(){
		List<Agent> agents = agentService.getAgents();
		return agents;
	}
	
	
	@GetMapping("/agents/{agentId}")
	public ResponseEntity<?> getAgent(@PathVariable int agentId) {
		if(agentService.getAgent(agentId)==null) {
			 return new ResponseEntity<String>("Agent Not Found..",HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<Agent>(agentService.getAgent(agentId),HttpStatus.OK);
		
	   
	}
	
	@PostMapping("/agents")
	public ResponseEntity<?> addAgent(@RequestBody Agent agent) {
		agent.setId(0);
		try {
			return new ResponseEntity<Agent>(agentService.addAgent(agent),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/agents")
	public Agent updateAgent(@RequestBody Agent agent) {
		Agent agnt=agentService.updateAgent(agent);
		return agnt;
	}
	
	@DeleteMapping("/agents/{agentId}")
	public Agent deleteAgent(@PathVariable int agentId) {
		Agent agent = agentService.deleteAgent(agentId);
		return agent;
		
	}
	
	@PostMapping("/agent/login")
	public ResponseEntity<?> login(@RequestBody Agent agent) {
		Agent result = null;
		try {
			result=agentService.login(agent);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Agent>(result,HttpStatus.OK);
	}
	
	@GetMapping("/agent/commision/{agentId}")
	public List<Commision> getCommisionByAgentId(@PathVariable int agentId){
		List<Commision> commisions=commisionService.getCommisionByAgentId(agentId);
		return commisions;
	}
	
	@GetMapping("/agent/commisions")
	public List<Commision> getAllCommisions(){
		List<Commision> listOfCommisions=commisionService.getAllCommisions();
		return listOfCommisions;
	}
	
	@PostMapping("/agents/add-agent/{employeeId}")
	public int addAgentByEmployee(@RequestBody Agent agent,@PathVariable int employeeId) {
		agent.setEmployeeId(employeeId);
		
		 Agent resultAgent=agentService.addAgent(agent);
		 return resultAgent.getId();
		 
	}
	
	@PostMapping("/agents/sendmail")
	public void sendMailToCustomer(@RequestBody Mail mailBody) {
		agentService.sendMail(mailBody);
	}
	
	@PostMapping("/agents/change-password/{agentId}")
	public void changePassword(@RequestBody ChangePassword passwordBody,@PathVariable int agentId) {
		agentService.changePassword(passwordBody,agentId);
	}
	
	@PutMapping("/agents/withdraw/{agentId}")
	public void withdrawAmount(@RequestBody WithdrawCommision withdrawBody ,@PathVariable("agentId") int agentId)
	{
		 
		agentService.withdrawAmount(withdrawBody,agentId);
	}
	
	

	
	
}
