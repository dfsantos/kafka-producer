package br.com.unicred.kafkaproducer;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/mensagens")
public class MensagemController {

    private final ProdutorMensagem produtorMensagem;

    public MensagemController(ProdutorMensagem produtorMensagem) {
        this.produtorMensagem = produtorMensagem;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public String post(@RequestHeader("topico") final String topico, @RequestBody final String mensagem) {
        produtorMensagem.publicar(topico, mensagem);
        return "Mensagem [" + mensagem + "] publicada no tópico [" + topico + "]";
    }

}
