/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * MemberConsoleAdapter.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public class MemberConsoleAdapter implements MemberOperations {
    private final DBMemberManager memberManager;

    public MemberConsoleAdapter(DBMemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void addMember(Member member) {
        memberManager.add(member);
    }

    @Override
    public void removeMember(int memberId) {
        memberManager.remove(memberId);
    }

    @Override
    public void listMembers() {
        memberManager.list();
    }
}
