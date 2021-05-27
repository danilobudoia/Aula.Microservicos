package com.aula.microservico.pagamento.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.aula.microservico.pagamento.entity.Venda;

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
public class VendaVO implements Serializable {

	private static final long serialVersionUID = 3637631246876511283L;

	private Long id;
	private LocalDateTime data;
	private String descricao;
	private List<ProdutoVendaVO> produtos;
	private BigDecimal valorTotal;

	public static VendaVO create(Venda venda) {
		return new ModelMapper().map(venda, VendaVO.class);
	}

}
