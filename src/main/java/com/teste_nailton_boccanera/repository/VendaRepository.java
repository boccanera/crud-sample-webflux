package com.teste_nailton_boccanera.repository;

import com.teste_nailton_boccanera.model.response.RelatorioResponse;
import com.teste_nailton_boccanera.model.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query(value = "SELECT c.nome, c.cnpj, SUM(v.valor) as totalVendas " +
            "FROM venda v JOIN cliente c ON v.cliente_id = c.id " +
            "GROUP BY c.id " +
            "ORDER BY totalVendas DESC " +
            "LIMIT 10",
            nativeQuery = true)
    List<RelatorioResponse> findTop10ClientesComMaiorFaturamento();


}
