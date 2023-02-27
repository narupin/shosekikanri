package com.example.demo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.LoginUser;

public class LoginUserDetails implements UserDetails {

	private final LoginUser loginUser;
	private final Collection<? extends GrantedAuthority> authorities;
	
	public LoginUserDetails(LoginUser loginUser) {
		this.loginUser = loginUser;
		this.authorities = loginUser.roleList()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role))
				.toList();
	}
	
	public LoginUser getLoginUser() {
		return loginUser;
	}

	@Override	// ロールのコレクションを返す
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override	// ハッシュ化済みのパスワードを返す
	public String getPassword() {
		return loginUser.password();
	}

	@Override	// ログインで利用するユーザー名を返す
	public String getUsername() {
		return loginUser.email();
	}

	@Override	// ユーザーが期限切れでなければtrueを返す
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override	// ユーザーがロックされていなければtrueを返す
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override	// ユーザーのパスワードが期限切れでなければtrueを返す
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override	// ユーザーが有効であればtrueを返す
	public boolean isEnabled() {
		return true;
	}
	
}
