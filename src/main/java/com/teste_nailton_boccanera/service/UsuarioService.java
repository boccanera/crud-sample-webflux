package com.teste_nailton_boccanera.service;

import com.teste_nailton_boccanera.model.entity.Usuario;
import com.teste_nailton_boccanera.repository.UsuarioRepository;
import com.teste_nailton_boccanera.model.mapper.UsuarioMapper;
import com.teste_nailton_boccanera.model.request.UsuarioRequest;
import com.teste_nailton_boccanera.model.response.UsuarioResponse;
import com.teste_nailton_boccanera.service.interf.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = UsuarioMapper.requestToEntity(usuarioRequest);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return new UsuarioResponse(usuarioRepository.save(usuario).getNome());
    }

}
