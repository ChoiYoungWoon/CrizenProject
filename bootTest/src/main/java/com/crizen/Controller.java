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
@RequestMapping(value="/api")
@Api(description="swagtest")
public class Controller {
	
	@Autowired
	private UserRepository userDao;
	
	@RequestMapping(value="/index")
    public @ResponseBody String index() {
        return "Hello Spring Boot~";
    }

	@RequestMapping(value = "/user" , method=RequestMethod.POST)
	@ApiOperation(value="사용자 등록" , notes = "사용자를 등록합니다.")
	public @ResponseBody User add(@RequestParam User user) {
		User userData = userDao.save(user);
		
		return userData;
	}
	
	@RequestMapping(value="/userList" , method=RequestMethod.GET)
	@ApiOperation(value="사용자" , notes="사용자 정보를 가져옵니다")
	public @ResponseBody List<User> userList() {
			
		return (List<User>) userDao.findAll();
	}
	
	
	@RequestMapping(value="/user" , method=RequestMethod.PUT)
	@ApiOperation(value="사용자변경" , notes="사용자를 변경합니다")
	public @ResponseBody User userUpdate(@RequestParam User user) {
			User userUpdate = userDao.save(user);
		return userUpdate;
	}
	
	@RequestMapping(value="/user" , method=RequestMethod.DELETE)
	@ApiOperation(value="사용자삭제" , notes="사용자를 삭제합니다")
	public String userDelete(@PathVariable long id) {
		userDao.delete(id);
		return "redirect:/userList";
	}
}
