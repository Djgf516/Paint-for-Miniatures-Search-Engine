SELECT name, COUNT(name)
FROM paint
GROUP BY (name)
HAVING COUNT(name)>1
ORDER BY name;

SELECT DISTINCT name, COUNT(name)
FROM paint
GROUP BY (name)
HAVING COUNT(name)>1
ORDER BY name;


DELETE FROM 
paint a USING paint b
WHERE a.paint_id < b.paint_id
AND a.name = b.name;

SELECT *
FROM paint
WHERE brand ILIKE '%ArmyPainter%';

SELECT TRIM(name) 
FROM paint;
SELECT TRIM (hex_color_code)
FROM paint;




TRIM (hex_color_code)

--command " "\\copy public.vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:/Users/Student/DOWNLO~1/VALLEJ~1.CSV' DELIMITER ',' CSV QUOTE '\"' ESCAPE '''';""

SELECT*
FROM paint
WHERE name ILIKE '%beiGeRed%'
LIMIT 25;


SELECT*
FROM vallejo_game
ORDER BY match_value;

SELECT*
FROM p3formula_test

SELECT*
FROM army_painter;
