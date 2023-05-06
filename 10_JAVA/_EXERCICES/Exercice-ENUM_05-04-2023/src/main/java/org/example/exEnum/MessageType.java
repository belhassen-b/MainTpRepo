package org.example.exEnum;

public class MessageType {

public Priority getPriority(String message) {

if (message.equals("A")) {
    return Priority.HIGH;
} else if (message.equals("B")) {
    return Priority.MEDIUM;
} else if (message.equals("C")) {
    return Priority.LOW;
} else {
    return null;
}
}

    }
