CREATE TABLE IF NOT EXISTS public.link_user
(
    id_user SERIAL PRIMARY KEY,
    email character varying(255)  NOT NULL UNIQUE,
    name character varying(255)  NOT NULL,
    password character varying(255)  NOT NULL,
    surname character varying(255)
);

CREATE TABLE IF NOT EXISTS public.short_link
(
    id_short_link SERIAL PRIMARY KEY,
    full_url character varying(255) NOT NULL,
    short_link_token character varying(255) NOT NULL UNIQUE,
    fk_link_user bigint,
    CONSTRAINT fk7qhpighutk0rmgr7v3q2i6jw5 FOREIGN KEY (fk_link_user)
        REFERENCES public.link_user (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)