package com.fillingstation.managers;

import com.fillingstation.models.*;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private List<ChargingSession> sessions = new ArrayList<>();
    private int nextSessionId = 1;

    public ChargingSession createSession(Customer customer, ChargingStation station) {
        if (!"FREE".equals(station.getStatus())) {
            throw new IllegalStateException("Station is not available");
        }

        if (customer.getBalance() < 5.0) {
            throw new IllegalStateException("Insufficient balance");
        }

        ChargingSession session = new ChargingSession(nextSessionId++, customer, station);
        sessions.add(session);
        return session;
    }

    public ChargingSession readSession(int sessionId) {
        return sessions.stream()
                .filter(s -> s.getSessionId() == sessionId)
                .findFirst()
                .orElse(null);
    }

    public void updateSession(ChargingSession session) {

    }

    public void deleteSession(int sessionId) {
        sessions.removeIf(s -> s.getSessionId() == sessionId);
    }

    public List<ChargingSession> getActiveSessions() {
        return sessions;
    }
}