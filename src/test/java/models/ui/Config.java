package models.ui;

import java.util.Date;
import java.util.Map;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
public class Config {
    private Date released;
    private int timeout;
    private String browser;
    private String node_url;
    private boolean bring_to_front;
    private boolean maximize;
    private int waitForFrame;
    private Map<String, String> users;

    public int getWaitForFrameTimeout() {
        return waitForFrame;
    }

    public void setWaitForFrame(int waitForFrame) {
        this.waitForFrame = waitForFrame;
    }

    public String getNode_url() {
        return node_url;
    }

    public void setNode_url(String node_url) {
        this.node_url = node_url;
    }

    public boolean isBring_to_front() {
        return bring_to_front;
    }

    public void setBring_to_front(boolean bring_to_front) {
        this.bring_to_front = bring_to_front;
    }

    public boolean isMaximize() {
        return maximize;
    }

    public void setMaximize(boolean maximize) {
        this.maximize = maximize;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }
}
