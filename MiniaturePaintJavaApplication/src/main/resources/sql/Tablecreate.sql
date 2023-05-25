
CREATE TABLE IF NOT EXISTS paint
(
    paint_id serial NOT NULL,
    name text  NOT NULL,
    brand text  NOT NULL,
    hex_color_code character varying(8)  NOT NULL,
    CONSTRAINT paint_pkey PRIMARY KEY (paint_id)
)

CREATE TABLE IF NOT EXISTS match_paint (
    base_paint_id INT NOT NULL,
    comparison_paint_id INT NOT NULL,
    match_value numeric(5,2) NOT NULL,
    
    PRIMARY KEY (base_paint_id, comparison_paint_id),
    
    CONSTRAINT fk_base_paint_id
        FOREIGN KEY (base_paint_id) 
        REFERENCES paint(paint_id),
    
    CONSTRAINT fk_comparison_paint_id
        FOREIGN KEY (comparison_paint_id)
        REFERENCES paint(paint_id)
);

DROP TABLE match_paint;

CREATE TABLE IF NOT EXISTS match_paint (
	match_id SERIAL PRIMARY KEY,
    base_paint_id INT NOT NULL,
    comparison_paint_id INT NOT NULL,
    match_value numeric(5,2) NOT NULL,
    
    CONSTRAINT fk_base_paint_id
        FOREIGN KEY (base_paint_id) 
        REFERENCES paint(paint_id),
    
    CONSTRAINT fk_comparison_paint_id
        FOREIGN KEY (comparison_paint_id)
        REFERENCES paint(paint_id)
);



--Deletes Duplicate Values and choose the greater paint_id to keep
DELETE FROM 
paint a USING paint b
WHERE a.paint_id < b.paint_id
AND a.name = b.name;

INSERT INTO paint (name, brand, hex_color_code)
VALUES 
	('StormyNight','Vallejo-Game', '#1f1a4f'),
	('NightBlue','Vallejo-Game','#19183f'),
	('ImperialPurple','Vallejo-Game','#211a4b'),
	('LiveryGreen','Vallejo-Game', '#9ece65');
