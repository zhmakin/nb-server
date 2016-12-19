package org.neighbor.api;


import com.google.common.base.MoreObjects;

import java.util.Date;
import java.util.Objects;

public class JsonError {

    private ErrorCode code;
    private String message;
    private Date timestamp = new Date();

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonError error = (JsonError) o;
        return code == error.code &&
                Objects.equals(message, error.message) &&
                Objects.equals(timestamp, error.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("message", message)
                .add("timestamp", timestamp)
                .toString();
    }
}