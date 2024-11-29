package com.api.estoque.api_crud.Exceptions;

public class BoletoNaoEncontrado extends Exception{

    public BoletoNaoEncontrado (String s) {
        super(s);
    }

    public BoletoNaoEncontrado(String s, Throwable erro) {
        super(s, erro);
    }

}
