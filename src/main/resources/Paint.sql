--Paint Name, Brand , Hex Code, Match Value
-- First Table
CREATE TABLE vallejo_game(
	paint_id serial NOT NULL,
	name varchar(100) NOT NULL,
	brand varchar(50) NOT NULL,
	hex_color_code varchar (10) NOT NULL, 
	match_value DECIMAL(3,2) NULL,
	CONSTRAINT PK_paint_id PRIMARY KEY (paint_id)

);

SELECT *
FROM vallejo_game; 

COPY vallejo_game
FROM ' '