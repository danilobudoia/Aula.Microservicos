package com.aula.microservico.pagamento.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.aula.microservico.pagamento.entity.Produto;
import com.aula.microservico.pagamento.repository.ProdutoRepository;
import com.aula.microservico.pagamento.vo.ProdutoVO;

@Component
public class ProdutoReceiveMessage {

	@Autowired
	private ProdutoRepository produtoRespository;
	
	@RabbitListener(queues = "${pagamento.rabbitmq.queue}")
	public void receive(@Payload ProdutoVO produtoVO) {
		System.out.println("recebi " + produtoVO.getId());
		produtoRespository.save(Produto.create(produtoVO));
	}
	
}
