package pl.przymuslogisz.moviecat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .antMatcher("/**").authorizeRequests()
                .antMatchers(HttpMethod.GET,  new String[]{"/api/movie", "/api/movie/*"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();

    }
}
