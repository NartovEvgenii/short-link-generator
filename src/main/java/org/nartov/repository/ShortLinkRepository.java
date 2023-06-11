package org.nartov.repository;

import org.nartov.domain.LinkUser;
import org.nartov.domain.ShortLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortLinkRepository  extends JpaRepository<ShortLink, Long> {

    ShortLink findByShortLinkToken(String shortLinkToken);

    @Query("from ShortLink sh where sh.linkUser.idUser = :idUser")
    List<ShortLink> findAllByIdUser(Long idUser);
}
