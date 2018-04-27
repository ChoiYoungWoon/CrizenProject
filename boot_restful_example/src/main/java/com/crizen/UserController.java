package com.crizen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	UserRepository userDao;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ApiOperation(value = "메인페이지", notes = "메인페이지입니다")
	public @ResponseBody String index() {
		return "Hello Spring Boot~";
	}

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	@ApiOperation(value = "사용자리스트", notes = "사용자 정보입니다")
	public @ResponseBody List<User> userList() {

		return (List<User>) userDao.findAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ApiOperation(value = "사용자 등록", notes = "사용자를 등록합니다.")
	public @ResponseBody User add(@RequestParam String User) {
		User userID = new User();
		userID.setIdUser(User);
		return userDao.save(userID);

	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	@ApiOperation(value="사용자 수정", notes="사용자 수정합니다")
	public @ResponseBody User update(@PathVariable long id , @RequestParam String user) {
		
		User userData = new User();
		userData.setSeq(id);
		userData.setIdUser(user);
		return userDao.save(userData);
		
	}
	
	@RequestMapping(value="/user/{id}" , method=RequestMethod.DELETE)
	@ApiOperation(value="사용자 삭제", notes="사용자 삭제입니다")
	public @ResponseBody void delete(@PathVariable long id) {
		userDao.deleteById(id);
	}
	
	

}
