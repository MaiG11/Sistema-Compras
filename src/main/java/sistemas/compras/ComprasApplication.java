package sistemas.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComprasApplication.class, args);
		System.out.println("Sistema Iniciado!");
		System.out.println("Acesse: http://localhost:8080");
	}

}
