-- Script para corregir la tabla categoria_subcategoria si ya existe
-- Este script asegura que la columna id tenga el DEFAULT correcto

-- Si la tabla ya existe pero el DEFAULT no funciona, alterarla
ALTER TABLE categoria_subcategoria 
  ALTER COLUMN id SET DEFAULT gen_random_uuid();

-- Si la columna id no permite NULL pero no tiene DEFAULT, necesitamos hacerla nullable temporalmente
-- o mejor aún, asegurarnos de que tenga el DEFAULT
-- (Esto solo es necesario si la tabla ya existía sin el DEFAULT)


