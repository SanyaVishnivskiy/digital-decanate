package com.example.app.logic.common;

public class GlobalState {
    private static boolean _initialized;

    public static boolean isInitialized() {
        return _initialized;
    }

    public static void setInitialized(boolean initialized) {
        _initialized = initialized;
    }
}
