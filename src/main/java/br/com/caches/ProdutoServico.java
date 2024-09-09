package br.com.caches;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.caches.model.Produto;

@Service
public class ProdutoServico {
	private static final Logger LOGGER = Logger.getLogger(ProdutoServico.class.getName());
	
	private Map<Long, Produto> mapa = new HashMap<Long, Produto>(){
		{
			put(1L, new Produto(1L, "Notebook", "Macbook Pro"));
			put(2L, new Produto(2L, "Notebook", "XPS Pro"));
			put(3L, new Produto(3L, "Notebook", "Alienware"));
			put(4L, new Produto(4L, "Notebook", "Zenbook"));
			put(5L, new Produto(4L, "Notebook", "ThinkPad"));
		}
	};
	
	@Cacheable("produtos")
	public Produto obtemPorId(Long id) {
		LOGGER.info("Buscando Produtos...");
		simulaLenditao();
		
		return mapa.get(id);
	}

	private void simulaLenditao() {
		try {
			Thread.sleep(1000L);
			
		} catch (InterruptedException e) {
			throw new IllegalArgumentException();
		}
	}
	
}	
























