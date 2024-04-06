package ru.oschepkov.cinema.utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class hash {
    public static String getHash(String originalString) {
        return Hashing.sha256().hashString(originalString, StandardCharsets.UTF_8).toString();
    }
}
