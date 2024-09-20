package tests;

import java.io.IOException;

import tests.helpers.RequestSender;

public class FakeRequest {
    public static void main(String[] args) throws NumberFormatException, IOException {
        RequestSender.sendRequest(Integer.parseInt(args[0]), "GET", "/", new String[] { "Header1: blarg;" },
                "This is the body\r\n\r\n");

    }
}
