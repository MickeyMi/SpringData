package pro.mickey.spring.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pro.mickey.spring.data.repository.UserRepository;
import pro.mickey.spring.data.repository.entity.User;

@RestController
@RequestMapping("/data")
public class TestController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("get")
	private String get() {
		int count = userRepository.findAll().size();

		return count + "__";
	}

	@GetMapping("get2")
	private User get2() {
		userRepository.update(123l, 100);
		return userRepository.findOne(123l);
	}

	@GetMapping("get3")
	private String get3() {
		User user = new User();
		user.setAge(123);
		userRepository.save(user);
		return "asd";
	}
}
