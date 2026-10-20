package com.banking.chain;

/** Level 1: chatbot handles common automated queries. */
public class FrontDeskAgent extends SupportHandler {

    @Override
    protected boolean canHandle(SupportTicket ticket) {
        return ticket.getLevel() == 1;
    }

    @Override
    protected void resolve(SupportTicket ticket) {
        System.out.println("  [Chatbot]           Resolved \"" + ticket.getIssue() + "\"");
    }
}
