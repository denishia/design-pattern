package com.banking.chain;

/**
 * The request that travels through the chain.
 */
public class SupportTicket {

    private final String id;
    private final String issue;
    private final int level;   // 1 = basic, 2 = billing, 3 = technical, 4 = escalate to manager

    public SupportTicket(String id, String issue, int level) {
        this.id    = id;
        this.issue = issue;
        this.level = level;
    }

    public String getId()    { return id; }
    public String getIssue() { return issue; }
    public int getLevel()    { return level; }
}
