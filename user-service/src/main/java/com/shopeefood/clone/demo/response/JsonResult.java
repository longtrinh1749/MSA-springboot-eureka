package com.shopeefood.clone.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class JsonResult {
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private String result;
    private Object data;

    public static JsonResult build(String result, Object data) {
        return new JsonResult(result, data);
    }

    public static ResponseEntity<JsonResult> success(Object data) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("success", data));
    }

    public static ResponseEntity<JsonResult> found(Object data) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("found", data));
    }

    public static ResponseEntity<JsonResult> notFound(Object data) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("not found", data + " not existed"));
    }

    public static ResponseEntity<JsonResult> idNotFound() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("not found", "id is not exist"));
    }

    public static ResponseEntity<JsonResult> parentNotFound(String parent) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("not found", parent + " is not exist"));
    }

    public static ResponseEntity<JsonResult> badRequest(String mess) {
        return ResponseEntity.badRequest().contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("fail", mess));
    }

    public static ResponseEntity<JsonResult> serverError(String mess) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("error", mess));
    }

    public static ResponseEntity<JsonResult> saveError(String object) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("error", "Save " + object + " fail!"));
    }

    public static ResponseEntity<JsonResult> uploaded(Object saved) {
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("uploaded", saved));
    }

    public static ResponseEntity<JsonResult> updated(Object saved) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("updated", saved));
    }

    public static ResponseEntity<JsonResult> deleted() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(CONTENT_TYPE)).body(JsonResult.build("deleted", "deleted"));
    }
}
