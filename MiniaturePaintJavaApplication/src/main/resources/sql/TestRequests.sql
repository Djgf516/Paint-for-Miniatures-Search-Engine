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


SELECT *
FROM paint
ORDER BY paint_id;
WHERE brand ILIKE '%Vallejo-Game%'
ORDER BY paint_id;
TRIM(name)
SELECT *
FROM paint;
SELECT TRIM (hex_color_code)
FROM paint;

TRIM (hex_color_code)

--command " "\\copy public.vallejo_game (name, brand, hex_color_code, match_value) FROM 'C:/Users/Student/DOWNLO~1/VALLEJ~1.CSV' DELIMITER ',' CSV QUOTE '\"' ESCAPE '''';""

--Display All from each brand
SELECT name, TRIM(brand) AS brand, hex_color_code
FROM paint
WHERE brand LIKE '%ArmyPainter'
ORDER BY name;

--Simple Search by name
SELECT name, brand, hex_color_code
FROM paint
WHERE name ILIKE '%p%'
ORDER BY name LIMIT 25;

--Search by Brand name
SELECT name, brand, hex_color_code
FROM paint
WHERE brand ILIKE '%p%'
ORDER BY name LIMIT 25;

-- Search by hex_color_code
SELECT*
FROM paint
WHERE hex_color_code ILIKE '%55%'
ORDER BY hex_color_code
LIMIT 25;

SELECT *
FROM match_paint;

--Match Search using paint name
SELECT name, brand, hex_color_code
FROM paint 
WHERE paint_id IN(SELECT match_paint.comparison_paint_id
				FROM paint
				JOIN match_paint ON match_paint.base_paint_id = paint.paint_id
				WHERE paint.name LIKE '%AbbadonBlack%')
LIMIT 25;

--Match Search using Hex Color Code				
SELECT name, brand, hex_color_code
FROM paint 
WHERE paint_id IN(SELECT match_paint.comparison_paint_id
				FROM paint
				JOIN match_paint ON match_paint.base_paint_id = paint.paint_id
				WHERE paint.hex_color_code LIKE '%29556d');
				
--Modified version to also include the match value
SELECT p.name AS comparison_paint_name, p.brand, p.hex_color_code, mp.match_value 
FROM match_paint mp
JOIN paint p ON mp.comparison_paint_id = p.paint_id
JOIN paint p_base ON mp.base_paint_id = p_base.paint_id
WHERE p_base.hex_color_code ILIKE '%eb64%'
ORDER BY p.name;

--Match Search using paint name
SELECT p.name AS comparison_paint_name, p.brand, p.hex_color_code, mp.match_value 
FROM match_paint mp
JOIN paint p ON mp.comparison_paint_id = p.paint_id
JOIN paint p_base ON mp.base_paint_id = p_base.paint_id
WHERE p_base.name ILIKE '%BeastHide%'
ORDER BY p.name;

--Just the matches for the paint
SELECT match_paint.comparison_paint_id
FROM paint
JOIN match_paint ON match_paint.base_paint_id = paint.paint_id
WHERE paint.name LIKE '%BeastHide%';


SELECT p.name AS comparison_paint_name, p.brand, p.hex_color_code, mp.match_value 
FROM match_paint mp
JOIN paint p ON mp.comparison_paint_id = p.paint_id
JOIN paint p_base ON mp.base_paint_id = p_base.paint_id
WHERE p_base.name ILIKE '%BeastHide%'
ORDER BY p.name;





