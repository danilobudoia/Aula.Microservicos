package com.aula.microservico.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aula.microservico.crud.service.ProdutoService;
import com.aula.microservico.crud.vo.ProdutoVO;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{id}")
	public ProdutoVO findById(@PathVariable Long id) {
		return produtoService.findById(id);
	}

	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "asc") String direction) {
		Pageable pageable = PageRequest.of(page, limit,
				Sort.by(direction.equalsIgnoreCase("desc") ? Direction.DESC : Direction.ASC, "nome"));
		return new ResponseEntity<>(produtoService.findAll(pageable), HttpStatus.OK);
	}

	@PostMapping
	public ProdutoVO save(@RequestBody ProdutoVO produtoVO) {
		return produtoService.save(produtoVO);
	}

	@PutMapping
	public ProdutoVO update(@RequestBody ProdutoVO produtoVO) {
		return produtoService.update(produtoVO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@RequestBody Long id) {
		return ResponseEntity.ok().build();
	}

}
