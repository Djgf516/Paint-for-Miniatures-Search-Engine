SELECT name, COUNT(name)
FROM vallejo_game
GROUP BY (name)
HAVING COUNT(name)>1
ORDER BY name;

DELETE FROM 
vallejo_game a USING vallejo_game b
WHERE a.paint_id < b.paint_id
AND a.name = b.name;


--command " "\\copy public.vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:/Users/Student/DOWNLO~1/VALLEJ~1.CSV' DELIMITER ',' CSV QUOTE '\"' ESCAPE '''';""

SELECT*
FROM vallejo_game
WHERE name ILIKE '%beiGeRed%'
LIMIT 25;


