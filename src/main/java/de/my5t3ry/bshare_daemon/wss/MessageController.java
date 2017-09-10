package de.my5t3ry.bshare_daemon.wss;

import de.my5t3ry.als_parser.AbletonFileParser;
import de.my5t3ry.bshare_daemon.wss.messages.ScanPathMessage;
import de.my5t3ry.bshare_daemon.wss.messages.ScanSuccessFullMessage;
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
    public ScanSuccessFullMessage recieiveScanPath(final ScanPathMessage message) throws Exception {
        final File file = new File(message.getPath());
        final AbletonFileParser als = new AbletonFileParser();
        final ScanSuccessFullMessage scanSuccessFullMessage = new ScanSuccessFullMessage();
        if (file.isDirectory()) {
            scanSuccessFullMessage.getResult().addAll(als.parseDirectory(file));
        } else {
            scanSuccessFullMessage.getResult().add(als.parse(file));
        }
        return scanSuccessFullMessage;
//           return new Greeting("Hello, " + message.getName() + "!");
    }
}
