package org.nartov.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "short_link")
@Data
public class ShortLink {

    @Id
    @Column(name = "id_short_link")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idShortLink;

    @Column(name = "short_link_token", unique = true, nullable = false)
    private String shortLinkToken;

    @Column(name = "full_url", nullable = false)
    private String fullUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_link_user")
    private LinkUser linkUser;
}
