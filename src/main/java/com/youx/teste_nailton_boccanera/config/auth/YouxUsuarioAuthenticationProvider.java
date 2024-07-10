package com.youx.teste_nailton_boccanera.config.auth;

import com.youx.teste_nailton_boccanera.model.entity.Usuario;
import com.youx.teste_nailton_boccanera.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class YouxUsuarioAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String nome = authentication.getName();
        String senha = authentication.getCredentials().toString();
        Optional<Usuario> usuario = usuarioRepository.findByNome(nome);

        if (usuario.isPresent() && passwordEncoder.matches(senha, usuario.get().getSenha())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(usuario.get().getCargo()));
            return new UsernamePasswordAuthenticationToken(nome, senha, authorities);
        } else {
            throw new BadCredentialsException("Usuário e/ou senha inválido.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
