package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Users;
import com.example.demo.Service.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	UsersService Service;

	@PostMapping("/addDetails")
	public Users addInfo(@RequestBody Users st) {
		return Service.SaveDetails(st);
	}

	@GetMapping("/showDetails")
	public List<Users> fetchDetails() {
		return Service.getDetails();
	}

	@PutMapping("/updateDetails")
	public Users updateInfo(@RequestBody Users st1) {
		return Service.updateDetails(st1);
	}

	@PostMapping("/signin")
	private String Login(@RequestBody Map<String, String> Loginx) {
		String email = Loginx.get("email");
		String password = Loginx.get("password");
		String result = Service.Loginx(email, password);
		return result;
	}

	@PostMapping("/signup")
	public String Signup(@RequestBody Users userx) {
		return Service.SignUpx(userx);
	}
//@DeleteMapping("/deleteDetails/{id}")
//public String deleteInfo(@PathVariable("id") int id)
//{
//	Service.deleteDetails(id);
//	return "Deleted details";
//}

}