package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Users;
import com.example.demo.Repository.UsersRepo;

@Service
public class UsersService {
	@Autowired
	UsersRepo Repo;

	public List<Users> getDetails()
	{
		return Repo.findAll();
	}
	public 	Users SaveDetails(Users e)
	{
		return Repo.save(e);
	}
	public Users updateDetails(Users e1)
	{
		return Repo.saveAndFlush(e1);
	}
	//User Login
		public String Loginx(String email, String password) {
			Users userx = Repo.findByEmail(email);
			if (userx == null) {
				return "Invalid Email !";
			} else {
				if (userx.getPassword().equals(password)) {
					return "Login Successful !";
				} else {
					return "Invalid Password";
				}
			}
		}
		
		public String SignUpx(Users userx) {
			String email = userx.getEmail();
			Users userxAuth = Repo.findByEmail(email);
			if (userxAuth == null) {
				Repo.save(userx);
				return "Signup Successful !";
			} else {
				if (userxAuth.getEmail().equals(email)) {
					return "Email Already Exists";
				} else {
					return "Invalid Email";
				}
			}
		}
//    public void deleteDetails(int id)
//    {
//    	return Repo.deleteById(id);
//    }
}