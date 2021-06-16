package pl.przymuslogisz.moviecat.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .antMatcher("/**").authorizeRequests()
                .antMatchers(new String[]{"/api/movie", "/api/movie/**"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();

    }
}
