package com.zxl.request.request;

import lombok.Data;

@Data
public class RequestEntity<T> {
    private String msg;
    private int status;
    private String tips;
    private T data;

    public static <T> RequestEntity<T> success(RequestCode requestCode, T data) {
        RequestEntity<T> requestEntity = new RequestEntity<>();
        requestEntity.setMsg(requestCode.getMsg());
        requestEntity.setStatus(requestCode.getStatus());
        requestEntity.setTips(requestCode.getTips());
        requestEntity.setData(data);
        return requestEntity;
    }

    public static <T> RequestEntity<T> success(RequestCode requestCode) {
        RequestEntity<T> requestEntity = new RequestEntity<>();
        requestEntity.setMsg(requestCode.getMsg());
        requestEntity.setStatus(requestCode.getStatus());
        requestEntity.setTips(requestCode.getTips());
        return requestEntity;
    }

    public static <T> RequestEntity<T> error(RequestCode requestCode, T data) {
        RequestEntity<T> requestEntity = new RequestEntity<>();
        requestEntity.setMsg(requestCode.getMsg());
        requestEntity.setStatus(requestCode.getStatus());
        requestEntity.setTips(requestCode.getTips());
        requestEntity.setData(data);
        return requestEntity;
    }

    public static <T> RequestEntity<T> error(RequestCode requestCode) {
        RequestEntity<T> requestEntity = new RequestEntity<>();
        requestEntity.setMsg(requestCode.getMsg());
        requestEntity.setStatus(requestCode.getStatus());
        requestEntity.setTips(requestCode.getTips());
        return requestEntity;
    }

    public static <T> RequestEntity<T> error() {
        RequestEntity<T> requestEntity = new RequestEntity<>();
        return requestEntity;
    }
}
