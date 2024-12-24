package com.ashokit.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterExample {

    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";
        Pattern pattern = Pattern.compile("q.*k");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Match found: " + matcher.group());
        } else {
            System.out.println("Match not found");
        }
  }
}

