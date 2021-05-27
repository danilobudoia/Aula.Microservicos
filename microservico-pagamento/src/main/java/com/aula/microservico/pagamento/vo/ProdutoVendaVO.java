package com.aula.microservico.pagamento.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.aula.microservico.pagamento.entity.ProdutoVenda;

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
public class ProdutoVendaVO implements Serializable {

	private static final long serialVersionUID = 5153707696597365781L;

	private Long id;
	private Long idProduto;
	private Integer quantidade;

	public static ProdutoVendaVO create(ProdutoVenda produtoVenda) {
		return new ModelMapper().map(produtoVenda, ProdutoVendaVO.class);
	}


}
