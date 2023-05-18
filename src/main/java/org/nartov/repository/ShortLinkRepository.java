package org.nartov.repository;

import org.nartov.domain.ShortLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkRepository  extends JpaRepository<ShortLink, Long> {

    ShortLink findByShortLinkToken(String shortLinkToken);
}
