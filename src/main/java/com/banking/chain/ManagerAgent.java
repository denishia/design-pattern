package com.banking.chain;

/** Level 4: manager handles anything that reached the top. */
public class ManagerAgent extends SupportHandler {

    @Override
    protected boolean canHandle(SupportTicket ticket) {
        return ticket.getLevel() >= 4;
    }

    @Override
    protected void resolve(SupportTicket ticket) {
        System.out.println("  [Manager]     Resolved \"" + ticket.getIssue() + "\"");
    }
}
