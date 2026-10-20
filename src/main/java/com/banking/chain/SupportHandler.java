package com.banking.chain;

/**
 * Base handler: every support agent extends this.
 * Each agent either handles the ticket or passes it to the next agent.
 */
public abstract class SupportHandler {

    private SupportHandler next;

    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;   // allows chaining: a.setNext(b).setNext(c)
    }

    public void handle(SupportTicket ticket) {
        if (canHandle(ticket)) {
            resolve(ticket);
        } else if (next != null) {
            System.out.println("  Escalating ticket " + ticket.getId() + " to next level...");
            next.handle(ticket);
        } else {
            System.out.println("  No handler available for ticket " + ticket.getId());
        }
    }

    protected abstract boolean canHandle(SupportTicket ticket);
    protected abstract void resolve(SupportTicket ticket);
}
