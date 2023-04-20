-- Table: public.p3formula_test

-- DROP TABLE public.p3formula_test;

CREATE TABLE IF NOT EXISTS public.p3formula_test
(
    paint_id integer NOT NULL DEFAULT nextval('p3formula_test_paint_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    brand text COLLATE pg_catalog."default" NOT NULL,
    hex_color_code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    match_value numeric(5,2),
    CONSTRAINT p3formula_test_pkey PRIMARY KEY (paint_id)
)

TABLESPACE pg_default;

ALTER TABLE public.p3formula_test
    OWNER to postgres;