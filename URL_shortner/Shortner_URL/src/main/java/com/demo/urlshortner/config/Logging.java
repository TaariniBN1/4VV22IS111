package com.demo.urlshortner.config;

public class Logging {
	private String stack;
    private String level;
    private String packageName;
    private String message;

    public Logging(String stack, String level, String packageName, String message) {
        this.stack = stack;
        this.level = level;
        this.packageName = packageName;
        this.message = message;
    }
}


