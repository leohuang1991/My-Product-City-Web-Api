package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Message1;
import com.example.model.Product1;
import com.example.repository.Product1Repository;

@RestController
public class ProductController {

	@Autowired
	Product1Repository prep;
	
	
	
	
	@PostMapping(path="/buyproduct"
			,consumes="application/json;charset=UTF-8"
			,produces="application/json;charset=UTF-8" )
	public ResponseEntity<Message1> buy1(@RequestBody List<Product1> p) {
		Product1 p2=null;
		Message1 message=new Message1(); 
		ResponseEntity<Message1> response=null;
		if(p.size()!=0&&p!=null) {
			for (int i = 0; i < p.size(); i++) {
				
				if(p.get(i).getUsername().equals("")==true) {
					message.setCode(400);
					message.setMessage("出單失敗!!未登入!!");
					response=ResponseEntity.badRequest().body(message);
					//break;
					return response;
				}
				p2=prep.save(p.get(i));
				
			}
		}
		
		
				//是否更新到客戶資料
				if(p2!=null) {
					message.setCode(200);
					message.setMessage("出單成功");
					response=ResponseEntity.ok(message);
					
				}else {
					message.setCode(400);
					message.setMessage("出單失敗!!");
					response=ResponseEntity.badRequest().body(message);
				}
				
		return response;
		
		
	}
	
	@GetMapping(path="/{name}/payment"
			,produces="application/json;charset=UTF-8"
			)
	public ResponseEntity<List<Product1>> payment(@PathVariable("name") String name1) {
		List<Product1> list= prep.findByusername(name1);
		ResponseEntity<List<Product1>> response=null;
		response=ResponseEntity.ok(list);
		return response;
	}
	
	@PutMapping(path="/payment2/{id}"
			,consumes="application/json;charset=UTF-8"
			,produces="application/json;charset=UTF-8" )
	public ResponseEntity<Message1> payment2(@RequestBody Product1 p,@PathVariable("id") String name1){
		Integer p2=null;
		Message1 message=new Message1(); 
		ResponseEntity<Message1> response=null;
		List<Product1> list= prep.findByusername(name1);
		//int a=list.get(0).getId();
		//System.out.println(a);
		for (int i = 0; i < list.size(); i++) {
			Product1 p3=list.get(i);
			p3.setIssold(1);
			prep.save(p3);
			p2=list.get(0).getIssold();
		}
		if(p2==1) {
			message.setCode(200);
			message.setMessage("付錢成功");
			response=ResponseEntity.ok(message);
			
		}else {
			message.setCode(400);
			message.setMessage("付錢失敗!!");
			response=ResponseEntity.badRequest().body(message);
		}
		
			return response;
	}
}
