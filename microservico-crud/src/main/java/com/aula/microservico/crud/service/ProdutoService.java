package com.aula.microservico.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.microservico.crud.entity.Produto;
import com.aula.microservico.crud.exception.NotFoundException;
import com.aula.microservico.crud.message.ProdutoSendMessage;
import com.aula.microservico.crud.repository.ProdutoRepository;
import com.aula.microservico.crud.vo.ProdutoVO;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ProdutoSendMessage produtoSendMessage;

	public ProdutoVO save(ProdutoVO produtoVO) {
		ProdutoVO p = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
		produtoSendMessage.sendMessage(p);
		return p;
	}

	public Page<ProdutoVO> findAll(Pageable pageable) {
		return produtoRepository.findAll(pageable).map(this::convertToProdutoVO);
	}
	
	private ProdutoVO convertToProdutoVO(Produto produto) {
		return ProdutoVO.create(produto);
	}

	public ProdutoVO findById(Long id) {
		return ProdutoVO.create(produtoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado")));
	}

	public ProdutoVO update(ProdutoVO produtoVO) {
		final Optional<Produto> opt = produtoRepository.findById(produtoVO.getId());
		if (!opt.isPresent()) {
			new NotFoundException("Não encontrado");
		}
		return ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
	}

	public void delete(Long id) {
		final Optional<Produto> opt = produtoRepository.findById(id);
		if (!opt.isPresent()) {
			new NotFoundException("Não encontrado");
		}
		produtoRepository.deleteById(id);
	}

}
