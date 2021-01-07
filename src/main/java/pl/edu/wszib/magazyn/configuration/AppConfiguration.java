package pl.edu.wszib.magazyn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@ComponentScan("pl.edu.wszib.magazyn")
public class AppConfiguration {

    @Bean
    public Connection connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/magazyn", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
