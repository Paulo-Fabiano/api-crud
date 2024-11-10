package com.api.estoque.api_crud.Exceptions;


public class IdNaoEncontrado extends Exception{

    public IdNaoEncontrado(String erro) {
        super(erro);
    }

    // Inclui a causa do erro
    public IdNaoEncontrado(String erro, Throwable causa) {
        super(erro, causa);
    }

}
