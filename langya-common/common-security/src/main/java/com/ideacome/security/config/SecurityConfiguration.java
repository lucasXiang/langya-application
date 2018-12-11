package com.ideacome.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ideacome.security.service.UserDetailSecurityService;
import com.ideacome.security.vo.MD5PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailSecurityService userDetailSecurityService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailSecurityService).passwordEncoder(getEncryPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/langya/**").authenticated()
			.anyRequest().permitAll()
			.and()
			.formLogin().loginPage("/auth/loginRemind")//前端提供登陆页面地址
			.loginProcessingUrl("/auth/form")//指定登陆的请求地址
			.permitAll()
			.and()
			.logout().logoutUrl("/auth/logout").permitAll()
			.and()
			.csrf().disable();
	}
	
	@Bean("passwordEncoder")
	public PasswordEncoder getEncryPasswordEncoder(){
		return new MD5PasswordEncoder();
	}
	
}
