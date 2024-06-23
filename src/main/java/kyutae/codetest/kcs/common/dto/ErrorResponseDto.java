package kyutae.codetest.kcs.common.dto;

public class ErrorResponseDto {
    private String error;
    private String exception;

    public ErrorResponseDto() {
    }
    public ErrorResponseDto(String error, String exception) {
        this.error = error;
        this.exception = exception;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "{" +
                "\"error\":\"" + error + '\"' +
                ", \"exception\":\"" + exception + '\"' +
                '}';
    }
}