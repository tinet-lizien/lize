package com.tinet.lize.data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 重新封装ResponseEntity,用于返回数据的json状态码和http状态码一致
 *
 * @author lizy
 * @date 2018/03/28
 */
public class ResponseModel extends ResponseEntity<ResponseBody> {

    public ResponseModel() {
        super(HttpStatus.OK);
    }

    public ResponseModel(Object result) {
        super(new ResponseBody(result), HttpStatus.OK);
    }

    public ResponseModel(HttpStatus status) {
        super(new ResponseBody(status), status);
    }

    public ResponseModel(Object result, HttpStatus status) {
        super(new com.tinet.lize.data.ResponseBody(status, status.name(), result), status);
    }

    public ResponseModel(HttpStatus status, String message) {
        super(new ResponseBody(status, message, null), status);
    }

    public ResponseModel(Object result, String message) {

        super(new ResponseBody(HttpStatus.OK, message, result), HttpStatus.OK);
    }

    public ResponseModel(HttpStatus status, String message, Object result) {
        super(new ResponseBody(status, message, result), status);
    }
}
