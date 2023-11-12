package br.edu.unicesumar.crud.model.repository;

import br.edu.unicesumar.crud.model.domain.Pessoa;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

//    @Query(nativeQuery = true,
//            value = " select id from ES_PESSOA where doc like '%:search%' ")
//    Long pesquisaNativa(String search);

//    @Query(value = " select p.id from Pessoa p where p.documento like '%:search%' ")
//    Long pesquisaComHql(String search);

//    Long findByDocLike(String search);

    Pessoa findByDocumentoEquals(String search);

}