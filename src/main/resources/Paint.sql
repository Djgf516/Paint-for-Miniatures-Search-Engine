--Paint Name, Brand , Hex Code, Match Value
-- First Table
CREATE TABLE vallejo_game(
	paint_id serial NOT NULL,
	name varchar(100) NOT NULL,
	brand varchar(50) NOT NULL,
	hex_color_code char (7) NOT NULL, 
	match_value DECIMAL(3,2) NULL,
	CONSTRAINT PK_paint_id PRIMARY KEY (paint_id)

);

ALTER TABLE vallejo_game
ALTER COLUMN match_value TYPE DECIMAL (5,2);

SELECT *
FROM army_painter; 

SELECT * 
FROM vallejo_game; 


COPY vallejo_game
FROM ' '

COPY vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:\Users\Public\Downloads\Allthedata.csv' DELIMITER ',';

COPY vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:\Users\Public\Downloads\Allthedata.csv' DELIMITER ',';

SELECT *
FROM p3formula_test; 