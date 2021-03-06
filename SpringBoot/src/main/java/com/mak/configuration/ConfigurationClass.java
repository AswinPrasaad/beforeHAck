package com.mak.configuration;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackages={"com.mak.controller","com.mak.service, com.mak.model, com.mak"}) 
//@EntityScan(basePackages={""}) 
@EnableJpaRepositories(basePackages={"com.mak.dao"})
@EnableWebSecurity
public class ConfigurationClass extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;

	/*@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("admin").password("admin").roles("admin");
		System.out.println("configure");
		auth.jdbcAuthentication().dataSource(dataSource()).
		 passwordEncoder(passwordEncoder())
        .usersByUsernameQuery("select user_name, password,enabled from users where user_name=?")
        .authoritiesByUsernameQuery(
                "select u.user_name as username, r.roles as role from users u INNER JOIN roles r ON r.users = u.user_id where user_name = ?");
	}*/
	 @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 System.out.println("configure");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		
		System.out.println("Config");
		 http
         .authorizeRequests()
             .antMatchers("/showRegistration","/saveRegistrationForm","/login").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login").defaultSuccessUrl("/home", true)
             .permitAll()
             .and()
             .logout().invalidateHttpSession(true)
             .deleteCookies("JSESSIONID")
             .permitAll();
		 
		 http.csrf().disable();
	}
	@Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }
   /*@Bean 
   public DataSource dataSource(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");   //  this is depretected com.mysql.cj.jdbc.Driver
      dataSource.setUrl("jdbc:mysql://localhost:3306/Boot");
      dataSource.setUsername("root");
      dataSource.setPassword("root");
      return dataSource;
   }*/
	
}
