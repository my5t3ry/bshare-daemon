package de.my5t3ry.bshare_daemon.persistence;

import de.my5t3ry.als_parser.domain.AbletonProject.AbletonProject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by: sascha.bast
 * since: 13.09.17
 */
public interface AbletonProjectRepository extends JpaRepository<AbletonProject, String> {
}
