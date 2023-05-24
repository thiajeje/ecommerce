package org.una.sdm.aula09.exceptions;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(){
        super();
    }

    public ProdutoNotFoundException(String msg){
        super(msg);
    }
}

