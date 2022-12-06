package com.candidate.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public  class CandidateException extends Exception{
    private HttpStatus status;
    private String errorMessage;
    public CandidateException(HttpStatus status, String errorMessage) {
        super(errorMessage);
        this.status = status;
        this.errorMessage = errorMessage;
    }
}