package classesForTests;

import base.AccountService;
import base.dataSets.UserDataSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivan on 03.04.15.
 */
public class AccountServiceStubExist implements AccountService {
    private Map<String, UserDataSet> users = new HashMap<>();
    private Map<String, UserDataSet> sessions = new HashMap<>();

    public boolean addUser(String userName, UserDataSet userDataSet) {
        return false;
    }

    public UserDataSet getUser(String userName) {
        return new UserDataSet("name", "password", "email");
    }

    public void addSession(String sessionId, UserDataSet userDataSet) {
        sessions.put(sessionId, userDataSet);
    }

    public UserDataSet getSessions(String sessionId) {
        return new UserDataSet("test", "123", "test@test");
    }

    public UserDataSet removeSessions(String sessionId) { return new UserDataSet("test", "123", "test@test"); }

    public String getNumberOfOnlineUsers() { return String.valueOf(sessions.size()); }

    public String getNumberOfUsers() { return String.valueOf(users.size()); }

    public String getUserName(String sessionId) {
        return sessions.get(sessionId).getName();
    }
}
