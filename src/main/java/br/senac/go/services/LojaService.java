package br.senac.go.services;

import br.senac.go.domain.Loja;
import br.senac.go.generics.IService;
import br.senac.go.repositories.LojaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class LojaService implements IService<Loja, Integer> {

    /**
     * @Autowired fazer a injeção de dependênciada classe
     */
    @Autowired
    private LojaRepository lojaRepository;

    @Override
    @Transactional
    public Loja create(Loja entity) {

        log.info("Método PessoaService.create invocado");
        log.debug("Valores informados PessoaService.create {}", entity);

        return this.lojaRepository.save(entity);
    }

    @Override
    public Loja readById(Integer id) throws Exception {
        log.info("Método PessoaService.readById invocado");
        log.debug("Valores informados PessoaService.readById {}", id);

        Loja pessoa = this.lojaRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em PessoaService.readById são {}", pessoa);
        return pessoa;
    }

    @Override
    public Loja read(Loja entity) throws Exception {

        log.info("Método PessoaService.read invocado");
        log.debug("Valores informados PessoaService.read {}", entity);

        Example<Loja> pessoaAprocurar = Example.of(entity);
        Loja pessoa = this.lojaRepository
                .findOne(pessoaAprocurar)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em PessoaService.read são {}", pessoa);

        return pessoa;
    }

    @Override
    @Transactional
    public Loja updatePatch(Loja entity, Integer id) throws Exception {
        log.info("Método PessoaService.updatePatch invocado");
        log.debug("Valores informados PessoaService.updatePatch {} {}", entity, id);

        /*//Exemplo 1 para persistir dados sem utilizar mapper(automático)
        //Encontrar o registro - Neste contexto o objeto pessoaEncontrado tem vínculo
        //com o hibernate.Logo ele é um objeto ATACHADO;
        Pessoa pessoaEncontrada = this.readById(id);
        //Atualiza os registros
        pessoaEncontrada.setNome(entity.getNome());
        pessoaEncontrada.setDataInicio(entity.getDataInicio());
        pessoaEncontrada.setDataFim(entity.getDataFim());
        pessoaEncontrada.setContatos(entity.getContatos());

        //Persistir no banco de dados
        this.pessoaRepository.save(pessoaEncontrada);


        //Exemplo 2, é possível fazer o gravar o objeto no banco, porém temos um erro.
        //O erro está relacionado a confiança no usuário, onde o usuário obrigatoriamente
        //precisda informar um ID que já esteja no banco de dados
        //Caso seja um novo 'id', será criado um novo registro. Não haverá uma atualização.
        entity.setId(id);
        this.pessoaRepository.save(entity);
        */

        /**
         *  Exemplo 3, para evitar a situação do exemplo 2, precisamos seguir os seguintes passos:
         *  1. Fazer uma pesquisa para verificar se o ID existe
         *  2. Se existir, fazer a atualização.
         */

       boolean registroEncontrado = this.lojaRepository.findById(id).isPresent();
        Loja pessoaAtualizada;

       if(registroEncontrado) {
           entity.setId(id);
           pessoaAtualizada = this.lojaRepository.save(entity);
       }
       else {
           log.error("Error: PessoaService.updatePatch ao atualizar registro: {} {}",
                   entity, id);
           throw new Exception("Erro ao atualizar regitro");
       }


        log.debug("Valores atualizados em PessoaService.updatePatch são {}", pessoaAtualizada);

        return pessoaAtualizada;
    }

    @Override
    @Transactional
    public Loja updatePut(Loja entity, Integer id) {
        log.info("Método PessoaService.updatePatch invocado");
        log.debug("Valores informados PessoaService.updatePatch {} {}", entity, id);

        log.debug("Valores recuperados em PessoaService.read são {}", entity);

        return null;
    }

    @Override
    @Transactional
    public Loja deleteById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public Loja delete(Loja entity) {
        return null;
    }
}
