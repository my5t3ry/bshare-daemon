package de.my5t3ry.bshare_daemon.rest;

import de.my5t3ry.als_parser.domain.AbletonProject.AbletonProject;
import de.my5t3ry.bshare_daemon.persistence.AbletonProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by: sascha.bast
 * since: 13.09.17
 */
@RestController()
@RequestMapping("project/")
public class ProjectRestController {

    @Autowired
    private AbletonProjectRepository abletonProjectRepository;

    @RequestMapping()
    public List<AbletonProject> get() {
        return abletonProjectRepository.findAll();
    }

}
