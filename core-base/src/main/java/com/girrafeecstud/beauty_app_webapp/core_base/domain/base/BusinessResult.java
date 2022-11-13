package com.girrafeecstud.beauty_app_webapp.core_base.domain.base;

public class BusinessResult<T> {

    private T data;

   private String message;

    private BusinessResultStatus businessResultStatus;

    public BusinessResult(T data, String message, BusinessResultStatus businessResultStatus) {
        this.data = data;
        this.message = message;
        this.businessResultStatus = businessResultStatus;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public BusinessResultStatus getBusinessResultStatus() {
        return businessResultStatus;
    }
}
