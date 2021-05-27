package com.aula.microservico.pagamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.aula.microservico.pagamento.vo.ProdutoVendaVO;

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

@Entity
@Table(name = "produto_venda")
public class ProdutoVenda implements Serializable {

	private static final long serialVersionUID = -3252723093043830016L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venda")
	private Venda venda;
	@Column(name = "id_produto")
	private Long idProduto;
	@Column(name = "quantidade")
	private Integer quantidade;

	public static ProdutoVenda create(ProdutoVendaVO produtoVendaVO) {
		return new ModelMapper().map(produtoVendaVO, ProdutoVenda.class);
	}

}
