package com.korostenskyi.app.wire.response;

import com.korostenskyi.app.data.entity.Character;
import org.springframework.http.HttpStatus;

import java.util.List;

public class AllCharactersResponse implements Response {

    private HttpStatus status;

    private List<Character> result;

    public AllCharactersResponse(HttpStatus status, List<Character> result) {
        this.status = status;
        this.result = result;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<Character> getResult() {
        return result;
    }

    public void setResult(List<Character> result) {
        this.result = result;
    }
}
