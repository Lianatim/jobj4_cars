package ru.job4j.cars.filter;

enum UserRegistered {
    LOGIN_PAGE("loginPage"),
    LOGIN("login"),
    FORM_ADD_USER("formAdd"),
    FAIL("fail"),
    SUCCESS("success"),
    REGISTRATION("registration");

    private final String name;

    UserRegistered(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}