package de.my5t3ry.bshare_daemon.wss.messages;

import de.my5t3ry.als_parser.domain.AbletonProject.AbletonProject;

import java.util.ArrayList;
import java.util.List;

/**
 * created by: sascha.bast
 * since: 10.09.17
 */
public class ScanSuccessFullMessage {

    private final List<AbletonProject> result = new ArrayList<>();

    public List<AbletonProject> getResult() {
        return result;
    }
}
