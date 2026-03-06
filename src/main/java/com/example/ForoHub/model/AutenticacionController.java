package com.example.ForoHub.model;

import com.example.ForoHub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.example.ForoHub.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired // <--- VERIFICA QUE ESTA LÍNEA ESTÉ AQUÍ
    private AuthenticationManager manager;

    @Autowired // <--- Y ESTA TAMBIÉN
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        var authToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.clave());
        var usuarioAutenticado = manager.authenticate(authToken);

        // Aquí es donde te daba el error porque tokenService era null
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

    // Agrega esto al final de AutenticacionController.java
    record DatosJWTToken(String jwTtoken) {}
}