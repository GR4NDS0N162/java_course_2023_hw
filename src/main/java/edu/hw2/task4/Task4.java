package edu.hw2.task4;

public final class Task4 {

    private Task4() {
    }

    public static CallingInfo callingInfo() {
        try {
            throw new Throwable();
        } catch (Throwable e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            String className = stackTrace[1].getClassName();
            String methodName = stackTrace[1].getMethodName();
            return new CallingInfo(className, methodName);
        }
    }
}
