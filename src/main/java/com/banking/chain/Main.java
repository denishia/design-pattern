package com.banking.chain;

public class Main {
    public static void main(String[] args) {

        // Build the chain: FrontDesk -> Billing -> Technical -> Manager
        SupportHandler frontDesk = new FrontDeskAgent();
        frontDesk.setNext(new BillingAgent())
                 .setNext(new TechnicalAgent())
                 .setNext(new ManagerAgent());

        SupportTicket[] tickets = {
            new SupportTicket("T-001", "What are your delivery hours?",     1),
            new SupportTicket("T-002", "My refund has not been processed.", 2),
            new SupportTicket("T-003", "App crashes on checkout.",          3),
            new SupportTicket("T-004", "Data breach complaint.",            4)
        };

        for (SupportTicket ticket : tickets) {
            System.out.println("\nTicket " + ticket.getId() + ": \"" + ticket.getIssue() + "\"");
            frontDesk.handle(ticket);
        }
    }
}
