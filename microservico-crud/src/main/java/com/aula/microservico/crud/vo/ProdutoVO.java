package com.aula.microservico.crud.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import com.aula.microservico.crud.entity.Produto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class ProdutoVO implements Serializable {

	private static final long serialVersionUID = -1388546002798742424L;

	private Long id;
	private String nome;
	private String descricao;
	private Integer estoque;
	private BigDecimal preco;

	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}

}
