package ma.emsi.gestionAdherents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ma.emsi.gestionAdherents.model.Adherent;
import ma.emsi.gestionAdherents.service.AdherentsService;

@SpringBootApplication
//@ComponentScan({"ma.emsi.gestionAdherents.controller"})
////@EntityScan("com.delivery.domain")
//@EnableJpaRepositories("ma.emsi.gestionAdherents.repository")
public class GestionAdherentsApplication  extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private AdherentsService service;
	public static void main(String[] args) {
		SpringApplication.run(GestionAdherentsApplication.class, args);
		System.out.println("Application démarrée");

	}

	@Override
	public void run(String... args) throws Exception
	{
		Adherent adh3 = new Adherent("adh3","adh3","adh3","adh3","adh3","adh3","adh3","adh3","adh3","adh3","adh3","adh3","adh3","adh3","adh3");
		Adherent adh2 = new Adherent("adh2","adh2","adh2","adh2","adh2","adh2","adh2","adh2","adh2","adh2","adh2","adh2","adh2","adh2","adh2");
		Adherent adh1 = new Adherent("adh1","adh1","adh1","adh1","adh1","adh1","adh1","adh1","adh1","adh1","adh1","adh1","adh1","adh1","adh1");

		service.save(adh3);
		service.save(adh2);
		service.save(adh1);

	}

}
