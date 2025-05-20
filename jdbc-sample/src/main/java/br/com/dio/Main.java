package br.com.dio;

import br.com.dio.persistence.EmployeeAuditDAO;
import br.com.dio.persistence.EmployeeDAO;
import br.com.dio.persistence.EmployeeParamDAO;
import br.com.dio.persistence.entity.EmployeeEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Locale;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

@SpringBootApplication
public class Main {

	private final static EmployeeDAO employeeDAO = new EmployeeDAO();
	private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
	private final static EmployeeParamDAO employeeParamDAO = new EmployeeParamDAO();

	private final static Faker faker = new Faker(Locale.of("pt", "BR"));

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

		var entities = Stream.generate(() -> {
            var employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40, 20)), LocalTime.MIN, UTC));
            return employee;
        }).limit(10000).toList();

		employeeParamDAO.insert(entities);
	}

}
