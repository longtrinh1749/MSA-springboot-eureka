package com.shopeefood.clone.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

public class RegisterResult {
    private String role;
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public RegisterResult(String role, String sessionId) {
        this.role = role;
        this.sessionId = sessionId;
    }

    public RegisterResult(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
