package de.my5t3ry.bshare_daemon.wss.messages.rx;

/**
 * created by: sascha.bast
 * since: 09.09.17
 */
public class ScanPathMessage {
    private String path;

    public ScanPathMessage() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(final String path) {
        this.path = path;
    }
}
