package br.com.senac.api.useCases.produtos.implement.repositorys;

import br.com.senac.api.entitys.Produtos;
import br.com.senac.api.entitys.enums.CategoriasEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    List<Produtos> findByCategoria(CategoriasEnum categoria);
    List<Produtos> findByNomeContainingIgnoreCase(String nome);
}
