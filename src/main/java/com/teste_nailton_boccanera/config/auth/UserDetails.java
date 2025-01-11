package com.teste_nailton_boccanera.config.auth;

import com.teste_nailton_boccanera.model.entity.Usuario;
import com.teste_nailton_boccanera.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetails implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        String usuario, senha;
        List<GrantedAuthority> authorities;
        Optional<Usuario> optionalUsuario = usuarioRepository.findByNome(nome);
        if (optionalUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado com nome: " + nome);
        } else{
            usuario = optionalUsuario.get().getNome();
            senha = optionalUsuario.get().getSenha();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(optionalUsuario.get().getCargo()));
        }
        return new User(usuario,senha,authorities);
    }

}