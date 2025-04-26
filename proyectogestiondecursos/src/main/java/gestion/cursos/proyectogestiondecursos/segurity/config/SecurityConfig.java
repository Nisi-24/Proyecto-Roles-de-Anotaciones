package gestion.cursos.proyectogestiondecursos.segurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
        // Deshabilitadp CSRF y configurado como stateless
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults()) 
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = passwordEncoder(); // para la codificacion de la contraseña
        List<UserDetails> userDetailsList = new ArrayList<>();
    
        userDetailsList.add(User.withUsername("admin")
                .password(encoder.encode("1234"))
                .roles("ADMIN")
                .authorities("READ_CURSOS", "WRITE_CURSOS", "READ_DOCENTES", "WRITE_DOCENTES")
                .build());
    
        userDetailsList.add(User.withUsername("docente")
                .password(encoder.encode("1234"))
                .roles("DOCENTE")
                .authorities("READ_DOCENTES", "READ_CURSOS")
                .build());
    
        userDetailsList.add(User.withUsername("estudiante")
                .password(encoder.encode("1234"))
                .roles("ESTUDIANTE")
                .authorities("READ_CURSOS")
                .build());
    
        return new InMemoryUserDetailsManager(userDetailsList);
    }
    


    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }

}
