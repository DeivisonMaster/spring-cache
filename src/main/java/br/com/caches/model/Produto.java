package br.com.caches.model;

import java.io.Serializable;

public record Produto(Long id, String nome, String descricao) implements Serializable {

}
