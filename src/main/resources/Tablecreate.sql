-- Table: public.p3formula_test

-- DROP TABLE public.p3formula_test;

CREATE TABLE IF NOT EXISTS p3formula
(
    paint_id serial NOT NULL,
    name text  NOT NULL,
    brand text  NOT NULL,
    hex_color_code character varying(8)  NOT NULL,
    match_value numeric(5,2),
    CONSTRAINT p3formula_pkey PRIMARY KEY (paint_id)
)

CREATE TABLE IF NOT EXISTS vallejo_model
(
    paint_id serial NOT NULL,
    name text  NOT NULL,
    brand text  NOT NULL,
    hex_color_code character varying(8)  NOT NULL,
    match_value numeric(5,2),
    CONSTRAINT vallejo_model_pkey PRIMARY KEY (paint_id)
)

CREATE TABLE IF NOT EXISTS vallejo_game
(
    paint_id serial NOT NULL,
    name text  NOT NULL,
    brand text  NOT NULL,
    hex_color_code character varying(8)  NOT NULL,
    match_value numeric(5,2),
    CONSTRAINT vallejo_game_pkey PRIMARY KEY (paint_id)
)

CREATE TABLE IF NOT EXISTS army_painter
(
    paint_id serial NOT NULL,
    name text  NOT NULL,
    brand text  NOT NULL,
    hex_color_code character varying(8)  NOT NULL,
    match_value numeric(5,2),
    CONSTRAINT army_painter_pkey PRIMARY KEY (paint_id)
)

CREATE TABLE IF NOT EXISTS citadel
(
    paint_id serial NOT NULL,
    name text  NOT NULL,
    brand text  NOT NULL,
    hex_color_code character varying(8)  NOT NULL,
    match_value numeric(5,2),
    CONSTRAINT citadel_pkey PRIMARY KEY (paint_id)
)


CREATE TABLE IF NOT EXISTS paint
(
    paint_id serial NOT NULL,
    name text  NOT NULL,
    brand text  NOT NULL,
    hex_color_code character varying(8)  NOT NULL,
    match_value numeric(5,2),
    CONSTRAINT paint_pkey PRIMARY KEY (paint_id)
)


COPY vallejo_model (name, brand, hex_color_code, match_value) FROM 'C:\Users\Public\Downloads\Originals\CSV.Vallejo-Model.csv' DELIMITER ',';
COPY vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:\Users\Public\Downloads\Originals\CSV.Vallejo-Model.csv' DELIMITER ',';
COPY vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:\Users\Public\Downloads\Originals\CSV.Vallejo-Model.csv' DELIMITER ',';
COPY vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:\Users\Public\Downloads\Originals\CSV.Vallejo-Model.csv' DELIMITER ',';









DROP TABLE army_painter;
DROP TABLE p3formula_test;
DROP Table vallejo_game;
