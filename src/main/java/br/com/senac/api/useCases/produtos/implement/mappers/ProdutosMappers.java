package br.com.senac.api.useCases.produtos.implement.mappers;

import br.com.senac.api.entitys.Produtos;
import br.com.senac.api.useCases.produtos.domains.ProdutosResponseDom;

public class ProdutosMappers {
    public static ProdutosResponseDom produtosParaProdutosResponseDom(Produtos in){
        ProdutosResponseDom out = new ProdutosResponseDom();
        out.setId(in.getId());
        out.setCodigoProduto(in.getCodigoProduto());
        out.setDescricao(in.getDescricao());
        out.setNome(in.getNome());
        out.setImagemPequena(in.getImagemPequena());
        out.setImagemGrande(in.getImagemGrande());
        out.setCreatedAt(in.getCreatedAt());
        out.setPreco(!in.getPrecos().isEmpty() ? in.getPrecos().get(0).getPreco() : 0.0);

        return out;
    }
}
