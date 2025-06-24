package api.util;



public class TestContext {
    private static final ThreadLocal<Integer> statusCode = new ThreadLocal<>();


    public static void setStatusCode(int code) {
        statusCode.set(code);
    }

    public static int getStatusCode() {
        return statusCode.get();
    }

}
