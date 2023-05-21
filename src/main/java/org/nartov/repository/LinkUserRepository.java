package org.nartov.repository;

import org.nartov.domain.LinkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkUserRepository  extends JpaRepository<LinkUser, Long> {

    LinkUser findByEmail(String email);
}
