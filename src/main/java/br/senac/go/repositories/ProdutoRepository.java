package br.senac.go.repositories;

import br.senac.go.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    //List<Pessoa> findPessoaByNomeAndAndDataInicioOrDataFimAndContatos();
    List<Produto> findProdutoByNomeLikeIgnoreCase(String nome);
}
