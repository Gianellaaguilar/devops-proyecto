-- =====================================================
-- INSERT: sintomas


-- =====================================================
-- VÍAS AÉREAS SUPERIORES (Respiratorio)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Congestión nasal', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Estornudos frecuentes', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Secreción nasal clara', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Tos leve', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Dolor de garganta leve', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Secreción nasal espesa amarilla/verde', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Disminución del olfato', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Congestión sin fiebre', 'Vías Aéreas Superiores'),
(gen_random_uuid(), 'Congestión intensa', 'Vías Aéreas Superiores')
ON CONFLICT DO NOTHING;

-- =====================================================
-- VÍAS AÉREAS INFERIORES (Respiratorio)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Tos', 'Vías Aéreas Inferiores'),
(gen_random_uuid(), 'Tos seca', 'Vías Aéreas Inferiores'),
(gen_random_uuid(), 'Tos irritativa', 'Vías Aéreas Inferiores'),
(gen_random_uuid(), 'Tos de noche intensa', 'Vías Aéreas Inferiores'),
(gen_random_uuid(), 'Flema', 'Vías Aéreas Inferiores')
ON CONFLICT DO NOTHING;

-- =====================================================
-- SÍNTOMAS ALÉRGICOS (Respiratorio)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Estornudos repetidos', 'Síntomas Alérgicos'),
(gen_random_uuid(), 'Picazón nasal', 'Síntomas Alérgicos'),
(gen_random_uuid(), 'Ojos llorosos', 'Síntomas Alérgicos')
ON CONFLICT DO NOTHING;

-- =====================================================
-- SÍNTOMAS DE GARGANTA (Otorrinolaringológico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Dolor de garganta intenso', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Enrojecimiento faríngeo', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Ganglios sensibles', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Dolor al tragar', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Amígdalas inflamadas', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Placas leves', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Ganglios inflamados', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Ronquera', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Voz débil', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Irritación de garganta', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Dificultad ligera para hablar', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Cosquilleo en garganta', 'Síntomas de Garganta'),
(gen_random_uuid(), 'Dolor de garganta', 'Síntomas de Garganta')
ON CONFLICT DO NOTHING;

-- =====================================================
-- SÍNTOMAS DE SENOS PARANASALES (Otorrinolaringológico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Dolor facial o presión', 'Síntomas de Senos Paranasales'),
(gen_random_uuid(), 'Dolor de cabeza', 'Síntomas de Senos Paranasales')
ON CONFLICT DO NOTHING;

-- =====================================================
-- SÍNTOMAS DE OÍDO (Otorrinolaringológico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Dolor al tocar la oreja', 'Síntomas de Oído'),
(gen_random_uuid(), 'Picazón', 'Síntomas de Oído'),
(gen_random_uuid(), 'Enrojecimiento', 'Síntomas de Oído'),
(gen_random_uuid(), 'Sensación de oído tapado', 'Síntomas de Oído'),
(gen_random_uuid(), 'Secreción leve', 'Síntomas de Oído')
ON CONFLICT DO NOTHING;

-- =====================================================
-- SÍNTOMAS DIGESTIVOS SUPERIORES (Gastrointestinal)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Sensación de llenura rápida', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Ardor de estómago', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Náuseas leves', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Acidez', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Regurgitación', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Eructos frecuentes', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Ardor moderado', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Llenura rápida', 'Síntomas Digestivos Superiores'),
(gen_random_uuid(), 'Dolor epigástrico', 'Síntomas Digestivos Superiores')
ON CONFLICT DO NOTHING;

-- =====================================================
-- SÍNTOMAS DIGESTIVOS INFERIORES (Gastrointestinal)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Dolor abdominal', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Distensión abdominal', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Diarrea', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Vómitos', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Dificultad de evacuación', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Heces duras', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Disminución de frecuencia de evacuación', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Dolor abdominal recurrente', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Gases', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Alternancia diarrea/estreñimiento', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Hinchazón', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Molestia que mejora tras evacuar', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Dolor abdominal leve', 'Síntomas Digestivos Inferiores'),
(gen_random_uuid(), 'Heces blandas frecuentes', 'Síntomas Digestivos Inferiores')
ON CONFLICT DO NOTHING;

-- =====================================================
-- ERUPCIONES Y LESIONES INFLAMATORIAS (Dermatológico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Enrojecimiento', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Picazón', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Irritación localizada', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Pequeñas ampollas', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Inflamación leve', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Ronchas elevadas', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Picazón intensa', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Aparición súbita', 'Erupciones y Lesiones Inflamatorias'),
(gen_random_uuid(), 'Empeora con calor', 'Erupciones y Lesiones Inflamatorias')
ON CONFLICT DO NOTHING;

-- =====================================================
-- INFECCIONES DE PIEL (Dermatológico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Espinillas', 'Infecciones de Piel'),
(gen_random_uuid(), 'Puntos negros', 'Infecciones de Piel'),
(gen_random_uuid(), 'Granos pequeños', 'Infecciones de Piel'),
(gen_random_uuid(), 'Enrojecimiento focal', 'Infecciones de Piel'),
(gen_random_uuid(), 'Piel grasa', 'Infecciones de Piel'),
(gen_random_uuid(), 'Picazón entre los dedos', 'Infecciones de Piel'),
(gen_random_uuid(), 'Piel reseca', 'Infecciones de Piel'),
(gen_random_uuid(), 'Mal olor', 'Infecciones de Piel'),
(gen_random_uuid(), 'Grietas leves', 'Infecciones de Piel'),
(gen_random_uuid(), 'Enrojecimiento', 'Infecciones de Piel')
ON CONFLICT DO NOTHING;

-- =====================================================
-- REACCIONES A AGENTES EXTERNOS (Dermatológico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Bulto elevado', 'Reacciones a Agentes Externos'),
(gen_random_uuid(), 'Picazón', 'Reacciones a Agentes Externos'),
(gen_random_uuid(), 'Enrojecimiento', 'Reacciones a Agentes Externos'),
(gen_random_uuid(), 'Dolor leve', 'Reacciones a Agentes Externos'),
(gen_random_uuid(), 'Inflamación pequeña', 'Reacciones a Agentes Externos'),
(gen_random_uuid(), 'Pequeños puntitos rojos', 'Reacciones a Agentes Externos'),
(gen_random_uuid(), 'Sudor atrapado', 'Reacciones a Agentes Externos'),
(gen_random_uuid(), 'Ardor leve', 'Reacciones a Agentes Externos'),
(gen_random_uuid(), 'Aumento con humedad', 'Reacciones a Agentes Externos')
ON CONFLICT DO NOTHING;

-- =====================================================
-- CEFALEAS (Neurológico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Dolor en banda en la cabeza', 'Cefaleas'),
(gen_random_uuid(), 'Tensión en cuello', 'Cefaleas'),
(gen_random_uuid(), 'Molestia leve-moderada', 'Cefaleas'),
(gen_random_uuid(), 'No empeora con actividad', 'Cefaleas'),
(gen_random_uuid(), 'Sin náuseas', 'Cefaleas'),
(gen_random_uuid(), 'Dolor pulsátil', 'Cefaleas'),
(gen_random_uuid(), 'Molestia a la luz', 'Cefaleas'),
(gen_random_uuid(), 'Náuseas leves', 'Cefaleas'),
(gen_random_uuid(), 'Dolor unilateral', 'Cefaleas'),
(gen_random_uuid(), 'Empeora con esfuerzo', 'Cefaleas')
ON CONFLICT DO NOTHING;

-- =====================================================
-- DOLORES MUSCULARES (Musculoesquelético)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Dolor en zona baja', 'Dolores Musculares'),
(gen_random_uuid(), 'Rigidez', 'Dolores Musculares'),
(gen_random_uuid(), 'Empeora al levantarse', 'Dolores Musculares'),
(gen_random_uuid(), 'Mejor con descanso', 'Dolores Musculares'),
(gen_random_uuid(), 'Sensación de presión', 'Dolores Musculares')
ON CONFLICT DO NOTHING;

-- =====================================================
-- SÍNTOMAS SISTÉMICOS (General)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Fiebre alta súbita', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Dolor muscular', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Escalofríos', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Cansancio intenso', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Fiebre', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Fatiga', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Fiebre baja', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Fiebre moderada', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Ausencia de fiebre', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Fiebre baja o ausente', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Falta de energía', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Somnolencia', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Debilidad leve', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Falta de concentración', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Esfuerzo excesivo reciente', 'Síntomas Sistémicos'),
(gen_random_uuid(), 'Dolor de pecho', 'Síntomas Sistémicos')
ON CONFLICT DO NOTHING;

-- =====================================================
-- ALTERACIONES DEL METABOLISMO (Metabólico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Mareos', 'Alteraciones del Metabolismo'),
(gen_random_uuid(), 'Sudor frío', 'Alteraciones del Metabolismo'),
(gen_random_uuid(), 'Temblor', 'Alteraciones del Metabolismo'),
(gen_random_uuid(), 'Hambre intensa', 'Alteraciones del Metabolismo'),
(gen_random_uuid(), 'Cansancio repentino', 'Alteraciones del Metabolismo')
ON CONFLICT DO NOTHING;

-- =====================================================
-- INFECCIONES OCULARES (Oftalmológico)
-- =====================================================
INSERT INTO sintomas (id, nombre, subcategoria) VALUES
(gen_random_uuid(), 'Ojo rojo', 'Infecciones Oculares'),
(gen_random_uuid(), 'Lagrimeo', 'Infecciones Oculares'),
(gen_random_uuid(), 'Ardor', 'Infecciones Oculares'),
(gen_random_uuid(), 'Sensación arenosa', 'Infecciones Oculares'),
(gen_random_uuid(), 'Sin pus espeso', 'Infecciones Oculares')
ON CONFLICT DO NOTHING;

