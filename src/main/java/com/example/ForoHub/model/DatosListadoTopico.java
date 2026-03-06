package com.example.ForoHub.model;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Integer id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean status,
        String autor,
        String curso
) {
    // Constructor compacto para convertir la Entidad a DTO fácilmente
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(),topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}