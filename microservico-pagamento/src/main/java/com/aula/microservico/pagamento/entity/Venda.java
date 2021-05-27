package com.aula.microservico.pagamento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.aula.microservico.pagamento.vo.VendaVO;

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
@Table(name = "venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 7050018735629812477L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data", nullable = false)
	private LocalDateTime data;
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = { CascadeType.REFRESH })
	private List<ProdutoVenda> produtos;
	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;

	public static Venda create(VendaVO vendaVO) {
		return new ModelMapper().map(vendaVO, Venda.class);
	}
	
}
