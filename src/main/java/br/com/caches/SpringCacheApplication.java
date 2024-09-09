package br.com.caches;

import java.util.logging.Logger;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringCacheApplication {
	private static final Logger LOGGER = Logger.getLogger(SpringCacheApplication.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCacheApplication.class, args);
	}
	
	/*
	 * Simulando várias requisições a um serviço
	 * */
	@Bean
	ApplicationRunner runner(ProdutoServico servico) {
		return args -> {
			LOGGER.info("Id 1: " + servico.obtemPorId(1L));
			LOGGER.info("Id 2: " + servico.obtemPorId(2L));
			LOGGER.info("Id 1: " + servico.obtemPorId(1L));
			LOGGER.info("Id 1: " + servico.obtemPorId(1L));
			LOGGER.info("Id 1: " + servico.obtemPorId(1L));
		};
	}

}





















