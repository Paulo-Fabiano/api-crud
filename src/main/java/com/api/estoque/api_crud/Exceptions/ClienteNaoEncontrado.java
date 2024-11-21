package com.api.estoque.api_crud.Exceptions;

public class ClienteNaoEncontrado extends Exception {

    public ClienteNaoEncontrado(String erro) {
        super(erro);
    }

    public ClienteNaoEncontrado(String erro, Throwable causa) {
        super(erro, causa);
    }

}
