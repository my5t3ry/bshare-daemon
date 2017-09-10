package de.my5t3ry.bshare_daemon.wss;

import de.my5t3ry.als_parser.AbletonFileParser;
import de.my5t3ry.bshare_daemon.wss.messages.rx.ScanPathMessage;
import de.my5t3ry.bshare_daemon.wss.messages.tx.ScanProgressMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.io.File;

/**
 * created by: sascha.bast
 * since: 09.09.17
 */
@Controller
public class MessageController {
    @MessageMapping("/scan-path")
    @SendTo("/socket")
    public ScanProgressMessage receiveScanPath(final ScanPathMessage message) throws Exception {
        final File file = new File(message.getPath());
        final AbletonFileParser als = new AbletonFileParser();
        final ScanProgressMessage scanProgressMessage = new ScanProgressMessage(100, "Successfully scanned:'" + file.getAbsolutePath() + "'");
        if (file.isDirectory()) {
            scanProgressMessage.getResult().addAll(als.parseDirectory(file));
        } else {
            scanProgressMessage.getResult().add(als.parse(file));
        }
        return scanProgressMessage;
    }
}
