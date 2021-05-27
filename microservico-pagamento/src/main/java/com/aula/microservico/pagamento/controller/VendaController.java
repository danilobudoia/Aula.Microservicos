package com.aula.microservico.pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.microservico.pagamento.service.VendaService;
import com.aula.microservico.pagamento.vo.VendaVO;

@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;

	@GetMapping("/{id}")
	public VendaVO findById(@PathVariable Long id) {
		return vendaService.findById(id);
	}
	
	@PostMapping
	public VendaVO save(@RequestBody VendaVO vendaVO) {
		return vendaService.save(vendaVO);
	}
	
}
