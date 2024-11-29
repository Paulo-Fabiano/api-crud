package com.api.estoque.api_crud.Exceptions;

public class BoletoNaoAdicionado extends Exception{

    public BoletoNaoAdicionado(String s) {
        super(s);
    }

    public BoletoNaoAdicionado(String s, Throwable causa) {
        super(s, causa);
    }
}
