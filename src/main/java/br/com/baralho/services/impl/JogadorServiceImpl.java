 import br.com.baralho.model.Jogador;
import br.com.baralho.repository.JogadorRepository;
import br.com.baralho.responses.ResponseJogador;
import br.com.baralho.services.JogadorService;
import br.com.baralho.utils.StringUtils;
import br.com.baralho.validates.JogadorValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

private JogadorRepository jogadorRepository;

@Slf4j
@Service
public static class JogadorServiceImpl implements JogadorService {

    private JogadorRepository jogadorRepository;

    @Override
    public ResponseJogador createJogador(Jogador jogador) {

        log.info("Criando um novo jogador");

        ResponseJogador responseJogador = new ResponseJogador();
        String errorsMsg = JogadorValidate.createValidate(jogador);

        if(StringUtils.isNotNullAndNotEmpty(errorsMsg)) {
            log.error(errorsMsg);
            responseJogador.setErrorsMsg(errorsMsg);
            responseJogador.setJogador(jogador);
        } else {
            try {
                jogadorRepository.save(jogador);
                responseJogador.setSuccessMsg("Novo Jogador criado com sucesso");
                log.info("Novo cliente criado com sucesso");
            } catch (Exception e) {
                log.error(e.getMessage());
                responseJogador.setErrorsMsg(e.getMessage());
            }

        }
        return responseJogador;
    }

}

public void main() {
}








