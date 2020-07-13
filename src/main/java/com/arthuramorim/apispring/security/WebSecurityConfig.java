package com.arthuramorim.apispring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticationUser implementsUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                //lista os endpoints e o metodo para eles
                .antMatchers(HttpMethod.GET,"/products","/")
                //permite que esses endpoints possam ser acessados por qualquer usuario
                .permitAll()
                .antMatchers(HttpMethod.POST,"/users")
                .permitAll()
                //define que todas as outras requisições precisam ser autenticadas
                .anyRequest().authenticated()
                //libera a pagina de login para todos os usuarios
                .and().formLogin().permitAll()
                //acessa a pagina /logout que a sessao sai
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(implementsUserDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    public void configure(WebSecurity web){
        //remove a necessidade de autenticar quando uma pagina estatica é chamada
        web.ignoring().antMatchers("/materialize/**","/style/**");
    }


}