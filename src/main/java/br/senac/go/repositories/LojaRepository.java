package br.senac.go.repositories;

import br.senac.go.domain.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {

    //List<Pessoa> findPessoaByNomeAndAndDataInicioOrDataFimAndContatos();
    List<Loja> findLojaByNomeLikeIgnoreCase(String nome);
}
