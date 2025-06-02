package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Message1;
import com.example.model.User1;
import com.example.repository.User1Repository;

/**
 * 
 */
@RestController
public class AccountController {

	public boolean t=false;
	public User1Repository ur1;
	public float f;
	public AccountController(User1Repository ur0,float f2) {
		ur1=ur0;
		f=f2;
		System.out.println(f);
	}
	
	/**
	 * 
	 * @param user 
	 * @return
	 */
	@PostMapping(path="/register"
			,consumes="application/json;charset=UTF-8"
			,produces="application/json;charset=UTF-8" )
	public ResponseEntity<Message1> RegisterUser(@RequestBody User1 user) {
		System.out.println(t+"");
		//User1 us1=new User1();
		
		//us1.setUsername("John");
		//us1.setPassword("12345");
		//ur1.save(user);
		//ur1.deleteById(1302);ur1.deleteById(1352);ur1.deleteById(1402);
		//ur1.deleteById(1452);ur1.deleteById(1502);ur1.deleteById(1552);
		//ur1.deleteById(1252);
		List<User1> list =ur1.findAll();
		
		for (int i = 0; i < list.size(); i++) {
			t=false;
			System.out.println(i+" : "+list.get(i).getUsername()+"\n");
			//System.out.println(list.get(i).getUsername()==user.getUsername()+" : =="+"\n");
			//System.out.println(list.get(i).getUsername().equals(user.getUsername())+" : equals"+"\n");
			if(list.get(i).getUsername().equals(user.getUsername())==true) {
				System.out.println("失敗");
				break;
			}else {
				if(i==list.size()-1) {
					t=true;
					System.out.println("成功");
				}
			}
		}
		User1 b=null;
		if(t==true) {
			b=ur1.save(user);
		}
		Message1 message=new Message1(); 
		ResponseEntity<Message1> response=null;
		
		
				//是否更新到客戶資料
				if(b!=null&&t==true) {
					message.setCode(200);
					message.setMessage("客戶資料加入成功");
					response=ResponseEntity.ok(message);
					
				}else {
					message.setCode(400);
					message.setMessage("客戶資料加入失敗!!");
					response=ResponseEntity.badRequest().body(message);
				}
				t=false;
		return response;
	}
	
	@PostMapping(path="/login"
			,consumes="application/json;charset=UTF-8"
			,produces="application/json;charset=UTF-8" )
	public ResponseEntity<Message1> LoginUser(@RequestBody User1 user) {
		System.out.println(t+"");
		t=false;
		List<User1> list =ur1.findAll();
		for (int i = 0; i < list.size(); i++) {
			t=false;
			System.out.println(i+" : "+list.get(i).getUsername()+"\n");
			if(list.get(i).getUsername().equals(user.getUsername())==true&&
					list.get(i).getPassword().equals(user.getPassword())==true) {
				System.out.println("成功");
				t=true;
				break;
			}else {
				if(i==list.size()-1) {
					
					System.out.println("失敗");
				}
			}
		}
		Message1 message=new Message1(); 
		ResponseEntity<Message1> response=null;
		
		
				//是否更新到客戶資料
				if(t==true) {
					message.setCode(200);
					message.setMessage("客戶登入成功");
					response=ResponseEntity.ok(message);
					
				}else {
					message.setCode(400);
					message.setMessage("客戶登入失敗!!");
					response=ResponseEntity.badRequest().body(message);
				}
				t=false;
		return response;
	}
}
