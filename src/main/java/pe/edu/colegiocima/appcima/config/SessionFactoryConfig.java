package pe.edu.colegiocima.appcima.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class SessionFactoryConfig {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JpaVendorAdapter jpaVendorAdapter;
	
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setPersistenceUnitName("default");
		emf.afterPropertiesSet();
		return emf.getObject();
	}
}
