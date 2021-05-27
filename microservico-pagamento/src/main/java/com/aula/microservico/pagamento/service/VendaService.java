package com.aula.microservico.pagamento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.microservico.pagamento.entity.ProdutoVenda;
import com.aula.microservico.pagamento.entity.Venda;
import com.aula.microservico.pagamento.exception.NotFoundException;
import com.aula.microservico.pagamento.repository.ProdutoVendaRepository;
import com.aula.microservico.pagamento.repository.VendaRepository;
import com.aula.microservico.pagamento.vo.VendaVO;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private ProdutoVendaRepository produtoVendaRepository;
	
	public VendaVO save(VendaVO vendaVO) {
		Venda venda = vendaRepository.save(Venda.create(vendaVO));
		
		List<ProdutoVenda> produtos = new ArrayList<>();
		vendaVO.getProdutos().forEach(p -> {
			ProdutoVenda pv = ProdutoVenda.create(p);
			pv.setVenda(venda);
			produtos.add(produtoVendaRepository.save(pv));
		});
		venda.setProdutos(produtos);
		
		return VendaVO.create(venda);
	}
	
	public VendaVO findById(Long id) {
		return VendaVO.create(vendaRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não Encontrado")));
	}

}
