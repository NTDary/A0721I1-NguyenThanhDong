package com.casestudy.secutiry;

import com.casestudy.service.user.IUserService;
import com.casestudy.service.user.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Qualifier("userService")
    @Autowired
    private UserService userService; // có sẵn của spring, có sẵn các phương thức getUsername,.....

    @Bean
    public PasswordEncoder passwordEncoder() { // nghĩa là mã hóa mật khẩu mới được lưu ( đạo đức nghề nghiệp ), vì có thể nhiều tk dùng chung 1 password nên cần mã hóa để tránh lộ tất cả mk
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { // chức nănglogin hiện thị thông tin trên menu, để các trang có thể lấy được thông tin
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
//Tat secutiry
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/**");
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/js/**","/css/**","/fonts/**").permitAll()
                .antMatchers("/customer/**","/service").hasAnyRole("MEMBER","ADMIN")
                .antMatchers("/contract/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                //formlogin
                .formLogin()
                //Đường dẫn trả về trang authentication
                .loginPage("/login").permitAll()
                //Nếu authentication thành công
                .defaultSuccessUrl("/")
                .permitAll()
                //Nếu authentication thất bại
                .failureUrl("/login?error")
                //Nếu authentication thành công nhưng vào trang không đúng role
                .and()
                // nghĩa là nếu bạn không phải admin, mà cố tình vào thì nó sẽ thông báo lỗi 403
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/").permitAll()
                .invalidateHttpSession(true)
                // xóa JSESSIONID và k luuw lại
                .deleteCookies("JSESSIONID");

    }




}
