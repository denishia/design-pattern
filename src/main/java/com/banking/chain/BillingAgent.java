package com.banking.chain;

/** Level 2: support executive handles queries the chatbot could not resolve. */
public class BillingAgent extends SupportHandler {

    @Override
    protected boolean canHandle(SupportTicket ticket) {
        return ticket.getLevel() == 2;
    }

    @Override
    protected void resolve(SupportTicket ticket) {
        System.out.println("  [Support Executive] Resolved \"" + ticket.getIssue() + "\"");
    }
}
