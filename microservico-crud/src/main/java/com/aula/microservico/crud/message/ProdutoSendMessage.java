package com.aula.microservico.crud.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aula.microservico.crud.vo.ProdutoVO;

@Component
public class ProdutoSendMessage {

	@Value("${crud.rabbitmq.exchange}")
	private String exchange;
	@Value("${crud.rabbitmq.routingkey}")
	private String routingkey;

	@Autowired
	public RabbitTemplate rabbitTemplate;

	public void sendMessage(ProdutoVO produtoVO) {
		rabbitTemplate.convertAndSend(exchange, routingkey, produtoVO);
	}

}
