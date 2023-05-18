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

--Deletes Duplicate Values and choose the greater paint_id to keep
DELETE FROM 
paint a USING paint b
WHERE a.paint_id < b.paint_id
AND a.name = b.name;

SELECT *
FROM paint
WHERE brand ILIKE '%Vallejo-Game%'
ORDER BY paint_id;

SELECT TRIM(name) 
FROM paint;
SELECT TRIM (hex_color_code)
FROM paint;




TRIM (hex_color_code)

--command " "\\copy public.vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:/Users/Student/DOWNLO~1/VALLEJ~1.CSV' DELIMITER ',' CSV QUOTE '\"' ESCAPE '''';""

SELECT*
FROM paint;
WHERE name ILIKE '%beiGeRed%'
LIMIT 25;
#29556d

SELECT*
FROM paint
WHERE hex_color_code LIKE '%29556d';

SELECT *
FROM match_paint;


SELECT * 
FROM paint 
WHERE paint_id IN(SELECT match_paint.comparison_paint_id
				FROM paint
				JOIN match_paint ON match_paint.base_paint_id = paint.paint_id
				WHERE paint.name LIKE '%Green%')
LIMIT 25;
				
SELECT * 
FROM paint 
WHERE paint_id IN(SELECT match_paint.comparison_paint_id
				FROM paint
				JOIN match_paint ON match_paint.base_paint_id = paint.paint_id
				WHERE paint.hex_color_code LIKE '%29556d');


--Just the matches for the paint
SELECT match_paint.comparison_paint_id
FROM paint
JOIN match_paint ON match_paint.base_paint_id = paint.paint_id
WHERE paint.name LIKE '%Green%';


SELECT mp.match_value, p.name, p.brand, p.hex_color_code AS comparison_paint_name
FROM match_paint mp
JOIN paint p ON mp.comparison_paint_id = p.paint_id
JOIN paint p_base ON mp.base_paint_id = p_base.paint_id
WHERE p_base.name ILIKE '%Red%'
ORDER BY p.name;





