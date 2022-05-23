package com.company;

public enum Status {
    BASE("On base     "),
    ROAD("On road     "),
    REPAIR("On repairing");

    private String def;

    Status(String def) {
        this.def = def;
    }

    @Override
    public String toString() {
        return def;
    }
}
