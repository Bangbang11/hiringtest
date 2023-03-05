package com.tricada.hiringtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultResponse<T> {

    private String message;

    private boolean error;

    private int code;

    private T results;
}
