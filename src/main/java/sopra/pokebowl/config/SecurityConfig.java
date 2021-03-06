package sopra.pokebowl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import sopra.pokebowl.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

		@Autowired
		private CustomUserDetailService userDetailsService;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
		}

		// definir les pages securisees
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
					.authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous();
			http.headers().frameOptions().disable();// à vérifier

			http.authorizeRequests().antMatchers("/**").permitAll();
//			http.authorizeRequests().antMatchers("/**").authenticated().and()
//					.httpBasic();
		}

		@Bean(name = "passwordEncoder")
		public PasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
	
}
