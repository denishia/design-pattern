package com.banking.chain;

/** Level 3: tech support handles deep technical issues. */
public class TechnicalAgent extends SupportHandler {

    @Override
    protected boolean canHandle(SupportTicket ticket) {
        return ticket.getLevel() == 3;
    }

    @Override
    protected void resolve(SupportTicket ticket) {
        System.out.println("  [Tech Support]      Resolved \"" + ticket.getIssue() + "\"");
    }
}
