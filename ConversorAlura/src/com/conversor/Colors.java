package com.conversor;

public enum Colors{
    BG("#FFFCF7"),
    BLACK("#343a40"),
    BLUE("#4895ef"),
    BLACK_OTHER("#adb5bd"),
    BORDER("#4361ee"),
    BLUE_OTHER("#2a6f97");

    private String color;
	
	
    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

