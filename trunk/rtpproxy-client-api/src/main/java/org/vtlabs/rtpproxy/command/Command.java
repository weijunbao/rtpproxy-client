/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.vtlabs.rtpproxy.command;

import java.util.UUID;
import org.vtlabs.rtpproxy.client.RTPProxyClientListener;

/**
 *
 * @author mhack
 */
public abstract class Command {
    private Object appData;
    private String sessionID;
    private String cookie;
    private RTPProxyClientListener listener;
    private CommandListener cmdListener;

    public Command() {
        UUID uuid = UUID.randomUUID();
        cookie = uuid.toString();
    }

    /**
     * Text representation of the command as defined in the RTPPRoxy
     * protocol.
     */
    public abstract String getMessage();

    public String getCookie() {
        return cookie;
    }

    public RTPProxyClientListener getCallbackListener() {
        return listener;
    }

    public void setCallbackListener(RTPProxyClientListener listener) {
        this.listener = listener;
    }

    public CommandListener getListener() {
        return cmdListener;
    }

    public void setListener(CommandListener listener) {
        cmdListener = listener;
    }

    public void commandTimeout() {
        cmdListener.commandTimeout(this);
    }

    public Object getAppData() {
        return appData;
    }

    public void setAppData(Object appData) {
        this.appData = appData;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}