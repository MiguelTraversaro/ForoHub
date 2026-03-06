package com.example.ForoHub.model;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Integer id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean status,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
