package br.com.dio;

import br.com.dio.persistence.migration.MigrationStrategy;
import br.com.dio.ui.MainMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Main.class, args);

		try(var connection = getConnection()){
			new MigrationStrategy(connection).executeMigration();
		}
		new MainMenu().execute();
	}

}
