package netgloo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /**
   * Enable authentication with three in-memory users: UserA, UserB and UserC.
   *
   * Spring Security will provide a default login form where insert username
   * and password.
   */
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
  throws Exception {
    auth
      // Defines three users with their passwords and roles
      .inMemoryAuthentication()
      .withUser("usera").password(PasswordEncoder().encode("usera")).roles("USER")
      .and()
      .withUser("userb").password(PasswordEncoder().encode("userb")).roles("USER")
      .and()
      .withUser("userc").password(PasswordEncoder().encode("userc")).roles("USER");
    
  }
  
  /**
   * Disable CSRF protection (to simplify this demo) and enable the default
   * login form.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      // Disable CSRF protection
      .csrf().disable()
      // Set default configurations from Spring Security
      .authorizeRequests()
        .anyRequest().authenticated()
        .and()
      .formLogin()
        .and()
      .httpBasic();
    return;
  }
  
    @Bean
	PasswordEncoder PasswordEncoder() {
		return new  BCryptPasswordEncoder();
	}
	

} // class WebSecurityConfig