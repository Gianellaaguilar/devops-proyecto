-- Crear tabla de relación entre categorías y subcategorías
-- Esta tabla permite relacionar directamente las categorías con las subcategorías
-- para mejorar el rendimiento y la claridad de las consultas

CREATE TABLE IF NOT EXISTS categoria_subcategoria (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  categoria_nombre text NOT NULL,
  subcategoria_nombre text NOT NULL,
  UNIQUE(categoria_nombre, subcategoria_nombre)
);

-- Índices para mejorar el rendimiento de las consultas
CREATE INDEX IF NOT EXISTS idx_categoria_subcategoria_categoria 
  ON categoria_subcategoria(categoria_nombre);

CREATE INDEX IF NOT EXISTS idx_categoria_subcategoria_subcategoria 
  ON categoria_subcategoria(subcategoria_nombre);


