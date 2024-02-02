package edu.coe.cs245.exceptions;

public class BankruptException extends RuntimeException{
    public BankruptException(String message){
        super(message);
    }
}
