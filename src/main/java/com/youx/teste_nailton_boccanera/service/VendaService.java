package com.youx.teste_nailton_boccanera.service;

import com.youx.teste_nailton_boccanera.config.strategy.AguardandoPagamento;
import com.youx.teste_nailton_boccanera.model.entity.Cliente;
import com.youx.teste_nailton_boccanera.model.entity.Venda;
import com.youx.teste_nailton_boccanera.model.mapper.VendaMapper;
import com.youx.teste_nailton_boccanera.model.request.VendaRequest;
import com.youx.teste_nailton_boccanera.model.response.VendaResponse;
import com.youx.teste_nailton_boccanera.repository.ClienteRepository;
import com.youx.teste_nailton_boccanera.repository.VendaRepository;
import com.youx.teste_nailton_boccanera.service.interf.IVendaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendaService implements IVendaService {

    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;

    public VendaService(VendaRepository vendaRepository, ClienteRepository clienteRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<VendaResponse> create(VendaRequest vendaRequest) {
        Optional<Cliente> clienteOptional = clienteRepository.findByCnpj(vendaRequest.cliente().getCnpj());
        if(clienteOptional.isPresent()){
            Venda venda = VendaMapper.requestToEntity(vendaRequest, clienteOptional.get());
            new AguardandoPagamento().processar();
            venda = vendaRepository.save(venda);
            return Optional.of(new VendaResponse(venda.getCliente().getNome(), venda.getStatus(), venda.getValor()));
        }
        return Optional.empty();
    }

}
