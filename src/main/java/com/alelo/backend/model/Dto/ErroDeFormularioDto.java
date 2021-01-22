package com.alelo.backend.model.Dto;

public class ErroDeFormularioDto {
    private String campo;
    private String erro;

    public ErroDeFormularioDto(String field, String erro) {
        this.campo = field;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
