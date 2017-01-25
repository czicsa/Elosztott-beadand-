package hu.meiit.integration;

import hu.meiit.model.EmailDetails;

public class CustomRouter {

    public String routeDecision(EmailDetails email) {
        return "sendEmailChannel";

    }
}