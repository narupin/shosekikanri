package com.example.demo;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginUser;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	private final LoginUserRepository repository;
	
	public LoginUserDetailsService(LoginUserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<LoginUser> userOp = repository.findByEmail(email);
		return userOp.map(user -> new LoginUserDetails(user))
				.orElseThrow(() -> new UsernameNotFoundException("not found"));
	}
}
