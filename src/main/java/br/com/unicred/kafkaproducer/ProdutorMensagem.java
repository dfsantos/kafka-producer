package br.com.unicred.kafkaproducer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProdutorMensagem {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProdutorMensagem(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publicar(final String topico, final String mensagem) {
        kafkaTemplate.send(topico, mensagem);
    }

}
