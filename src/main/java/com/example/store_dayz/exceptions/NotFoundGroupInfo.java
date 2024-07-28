package com.example.store_dayz.exceptions;

public class NotFoundGroupInfo extends RuntimeException {
  public NotFoundGroupInfo(String name) {
    super("Группировка по данному имени не найден: " + name);
  }
}
