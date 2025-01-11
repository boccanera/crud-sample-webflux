package com.teste_nailton_boccanera.service;

import com.teste_nailton_boccanera.model.entity.Cliente;
import com.teste_nailton_boccanera.model.mapper.ClienteMapper;
import com.teste_nailton_boccanera.model.request.ClienteRequest;
import com.teste_nailton_boccanera.model.response.ClienteResponse;
import com.teste_nailton_boccanera.repository.ClienteRepository;
import com.teste_nailton_boccanera.service.interf.IClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponse create(ClienteRequest clienteRequest) {
        Cliente cliente = ClienteMapper.requestToEntity(clienteRequest);
        cliente = clienteRepository.save(cliente);
        return new ClienteResponse(cliente.getNome(), cliente.getCnpj());
    }
}
