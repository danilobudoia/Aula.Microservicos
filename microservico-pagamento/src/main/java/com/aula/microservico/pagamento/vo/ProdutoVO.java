package com.aula.microservico.pagamento.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.aula.microservico.pagamento.entity.Produto;

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

	private static final long serialVersionUID = 9154864177522773130L;

	private Long id;
	private Integer estoque;

	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}

}
