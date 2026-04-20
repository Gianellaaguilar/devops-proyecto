-- =====================================================
-- INSERT: categoria_subcategoria

-- =====================================================
-- CATEGORÍA: Gastrointestinal
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'Gastrointestinal', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Gastrointestinal', 'Síntomas Digestivos Inferiores')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;

-- =====================================================
-- CATEGORÍA: Dermatológico
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'Dermatológico', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Dermatológico', 'Infecciones de Piel'),
(gen_random_uuid(), 'Dermatológico', 'Reacciones a Agentes Externos')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;

-- =====================================================
-- CATEGORÍA: Respiratorio
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'Respiratorio', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Respiratorio', 'Vías Aéreas Inferiores'),
(gen_random_uuid(), 'Respiratorio', 'Síntomas Alérgicos')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;

-- =====================================================
-- CATEGORÍA: Otorrinolaringológico
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'Otorrinolaringológico', 'Síntomas de Oído'),
(gen_random_uuid(), 'Otorrinolaringológico', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Otorrinolaringológico', 'Síntomas de Senos Paranasales')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;

-- =====================================================
-- CATEGORÍA: Neurológico
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'Neurológico', 'Cefaleas')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;

-- =====================================================
-- CATEGORÍA: Musculoesquelético
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'Musculoesquelético', 'Dolores Musculares')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;

-- =====================================================
-- CATEGORÍA: General
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'General', 'Síntomas Sistémicos')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;

-- =====================================================
-- CATEGORÍA: Oftalmológico
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'Oftalmológico', 'Infecciones Oculares')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;

-- =====================================================
-- CATEGORÍA: Metabólico
-- Subcategorías encontradas en síntomas:
-- =====================================================
INSERT INTO categoria_subcategoria (id, categoria_nombre, subcategoria_nombre) VALUES
(gen_random_uuid(), 'Metabólico', 'Alteraciones del Metabolismo')
ON CONFLICT (categoria_nombre, subcategoria_nombre) DO NOTHING;
