package cn.org.sibd.EpidemicPreventionAndControl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * http 安全配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 管理控制台请求路径的拦截配置
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                // 放行所有路径的请求
                .antMatchers("/**")
                .permitAll()

                // 登陆相关的配置
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin")

                // 退出登录相关的配置
                .and()
                .logout()
                .logoutSuccessUrl("/admin")

                // 添加 csrf 功能，并排除 h2-console 相关的路径
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")

                // 兼容 h2-console
                .and()
                .headers()
                .frameOptions()
                .sameOrigin();
    }

    /**
     * 用户认证配置
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 基于内存的用户认证配置
                .inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}password")
                .roles("ADMIN");
    }
}
