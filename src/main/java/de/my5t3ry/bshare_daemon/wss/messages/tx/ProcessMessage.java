package de.my5t3ry.bshare_daemon.wss.messages.tx;

/**
 * created by: sascha.bast
 * since: 10.09.17
 */
public class ProcessMessage {
    final private int progress;
    final private String message;

    public ProcessMessage(final int progress, final String message) {
        this.progress = progress;
        this.message = message;
    }

    public int getProgress() {
        return progress;
    }

    public String getMessage() {
        return message;
    }
}
