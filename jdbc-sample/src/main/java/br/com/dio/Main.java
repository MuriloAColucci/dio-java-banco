package br.com.dio;

import br.com.dio.persistence.ConnectionUtil;
import br.com.dio.persistence.entity.EmployeeDAO;
import br.com.dio.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.OffsetDateTime;

@SpringBootApplication
public class Main {

	private final static EmployeeDAO employeeDAO = new EmployeeDAO();

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		var flyway = Flyway.configure()
				.dataSource("jdbc:mysql://localhost/jdbc-sample", "root", "root")
				.defaultSchema("jdbc-sample")
				.load();
		flyway.migrate();

//		var insert = new EmployeeEntity();
//		insert.setName("Miguel");
//		insert.setSalary(new BigDecimal("2800"));
//		insert.setBirthday(OffsetDateTime.now().minusYears(18));
//		System.out.println(insert);
//		employeeDAO.insert(insert);
//		System.out.println(insert);

//		employeeDAO.findAll().forEach(System.out::println);

//		System.out.println(employeeDAO.findById(3));

//		var update = new EmployeeEntity();
//		update.setId(insert.getId());
//		update.setName("Gabriel");
//		update.setSalary(new BigDecimal(5500));
//		update.setBirthday(OffsetDateTime.now().minusYears(18).minusDays(3));
//		employeeDAO.update(update);

//		employeeDAO.delete(8);
	}

}
