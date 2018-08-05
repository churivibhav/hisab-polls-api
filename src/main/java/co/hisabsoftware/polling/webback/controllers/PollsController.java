package co.hisabsoftware.polling.webback.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.hisabsoftware.polling.webback.models.Poll;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/polls")
public class PollsController {
	@GetMapping
	public String hello(){
		return "hello spring";
	}
	
	@PostMapping
	public Poll Ass(@RequestBody String name){
		return new Poll(1, name);
	}
}
