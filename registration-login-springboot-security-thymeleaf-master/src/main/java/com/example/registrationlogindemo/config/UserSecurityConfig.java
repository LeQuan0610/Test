//package com.example.registrationlogindemo.config;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests((authorize) ->
//                        authorize.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                                .antMatchers("/register/**").permitAll()
//                                .antMatchers("/index").permitAll()
//                                .antMatchers("/users/**").permitAll()
//                                .antMatchers("/users/edit/**").permitAll()
//                                .antMatchers("/users/delete/**").hasAuthority("ADMIN") // chỉ cho phép user có quyền ADMIN xóa user
//                                .anyRequest().authenticated()
//                ).formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/users")
//                                .permitAll()
//                ).logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .permitAll()
//                );
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").authorities("USER")
//                .and()
//                .withUser("admin").password("{noop}password").authorities("ADMIN");
//    }
//}
//
//
