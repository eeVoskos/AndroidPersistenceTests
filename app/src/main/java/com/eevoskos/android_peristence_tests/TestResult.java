package com.eevoskos.android_peristence_tests;

public class TestResult {

    public long duration;

    public TestResult(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return duration + " ms";
    }

}
