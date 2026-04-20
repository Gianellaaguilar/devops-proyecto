-- =====================================================
-- INSERT: enfermedad_sintoma

-- =====================================================
-- Resfriado común
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Resfriado común'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Congestión nasal',
    'Estornudos frecuentes',
    'Secreción nasal clara',
    'Tos leve',
    'Dolor de garganta leve'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Resfriado común')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Gripe
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Gripe'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Fiebre alta súbita',
    'Dolor muscular',
    'Escalofríos',
    'Tos seca',
    'Cansancio intenso'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Gripe')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Alergia estacional
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Alergia estacional'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Estornudos repetidos',
    'Picazón nasal',
    'Ojos llorosos',
    'Congestión sin fiebre',
    'Tos irritativa'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Alergia estacional')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Sinusitis aguda
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Sinusitis aguda'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor facial o presión',
    'Congestión intensa',
    'Secreción nasal espesa amarilla/verde',
    'Disminución del olfato',
    'Dolor de cabeza'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Sinusitis aguda')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Faringitis viral
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Faringitis viral'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor de garganta intenso',
    'Fiebre baja',
    'Tos leve',
    'Enrojecimiento faríngeo',
    'Ganglios sensibles'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Faringitis viral')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Amigdalitis leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Amigdalitis leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor al tragar',
    'Fiebre moderada',
    'Amígdalas inflamadas',
    'Placas leves',
    'Ganglios inflamados'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Amigdalitis leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Laringitis
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Laringitis'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Ronquera',
    'Voz débil',
    'Tos seca',
    'Irritación de garganta',
    'Dificultad ligera para hablar'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Laringitis')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Bronquitis aguda
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Bronquitis aguda'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Tos',
    'Dolor de pecho',
    'Fatiga',
    'Congestión nasal',
    'Flema'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Bronquitis aguda')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Tos irritativa
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Tos irritativa'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Tos seca',
    'Dolor de garganta',
    'Ausencia de fiebre',
    'Cosquilleo en garganta',
    'Tos de noche intensa'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Tos irritativa')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- COVID-19 leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'COVID-19 leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Fiebre',
    'Tos',
    'Fatiga',
    'Dolor de cabeza',
    'Congestión nasal'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'COVID-19 leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Gastroenteritis viral
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Gastroenteritis viral'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Diarrea',
    'Vómitos',
    'Dolor abdominal',
    'Fiebre',
    'Fatiga'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Gastroenteritis viral')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Indigestión
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Indigestión'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Sensación de llenura rápida',
    'Ardor de estómago',
    'Dolor abdominal',
    'Náuseas leves',
    'Distensión abdominal'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Indigestión')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Reflujo gastroesofágico
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Reflujo gastroesofágico'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Acidez',
    'Ardor de estómago',
    'Regurgitación',
    'Dolor de pecho',
    'Dolor de garganta'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Reflujo gastroesofágico')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Estreñimiento
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Estreñimiento'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dificultad de evacuación',
    'Heces duras',
    'Disminución de frecuencia de evacuación',
    'Dolor abdominal',
    'Distensión abdominal'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Estreñimiento')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Intolerancia a la lactosa leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Intolerancia a la lactosa leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Heces blandas frecuentes',
    'Dolor abdominal leve',
    'Gases',
    'Fiebre baja o ausente'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Intolerancia a la lactosa leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Gastritis leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Gastritis leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor epigástrico',
    'Náuseas leves',
    'Eructos frecuentes',
    'Ardor moderado',
    'Llenura rápida'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Gastritis leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Síndrome del colon irritable leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Síndrome del colon irritable leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor abdominal recurrente',
    'Gases',
    'Alternancia diarrea/estreñimiento',
    'Hinchazón',
    'Molestia que mejora tras evacuar'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Síndrome del colon irritable leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Hipoglucemia leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Hipoglucemia leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Mareos',
    'Sudor frío',
    'Temblor',
    'Hambre intensa',
    'Cansancio repentino'
)
AND s.subcategoria = 'Alteraciones del Metabolismo'
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Hipoglucemia leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Dermatitis por contacto
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Dermatitis por contacto'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Enrojecimiento',
    'Picazón',
    'Irritación localizada',
    'Pequeñas ampollas',
    'Inflamación leve'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Dermatitis por contacto')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Urticaria Leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Urticaria Leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Ronchas elevadas',
    'Picazón intensa',
    'Enrojecimiento',
    'Aparición súbita',
    'Empeora con calor'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Urticaria Leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Acné leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Acné leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Espinillas',
    'Puntos negros',
    'Granos pequeños',
    'Enrojecimiento focal',
    'Piel grasa'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Acné leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Picadura de insecto
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Picadura de insecto'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Bulto elevado',
    'Picazón',
    'Enrojecimiento',
    'Dolor leve',
    'Inflamación pequeña'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Picadura de insecto')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Irritación por calor
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Irritación por calor'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Pequeños puntitos rojos',
    'Picazón',
    'Sudor atrapado',
    'Ardor leve',
    'Aumento con humedad'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Irritación por calor')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Pie de atleta
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Pie de atleta'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Picazón entre los dedos',
    'Piel reseca',
    'Mal olor',
    'Enrojecimiento',
    'Grietas leves'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Pie de atleta')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Dolor de cabeza tensional
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Dolor de cabeza tensional'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor en banda en la cabeza',
    'Tensión en cuello',
    'Molestia leve-moderada',
    'No empeora con actividad',
    'Sin náuseas'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Dolor de cabeza tensional')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Migraña leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Migraña leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor pulsátil',
    'Molestia a la luz',
    'Náuseas leves',
    'Dolor unilateral',
    'Empeora con esfuerzo'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Migraña leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Dolor lumbar leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Dolor lumbar leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor en zona baja',
    'Rigidez',
    'Empeora al levantarse',
    'Mejor con descanso',
    'Sensación de presión'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Dolor lumbar leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Fatiga o cansancio general
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Fatiga o cansancio general'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Falta de energía',
    'Somnolencia',
    'Debilidad leve',
    'Falta de concentración',
    'Esfuerzo excesivo reciente'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Fatiga o cansancio general')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Conjuntivitis viral leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Conjuntivitis viral leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Ojo rojo',
    'Lagrimeo',
    'Ardor',
    'Sensación arenosa',
    'Sin pus espeso'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Conjuntivitis viral leve')
    AND es.sintoma_id = s.id
);

-- =====================================================
-- Otitis externa leve
-- =====================================================
INSERT INTO enfermedad_sintoma (id, enfermedad_id, sintoma_id)
SELECT gen_random_uuid(), 
    (SELECT id FROM enfermedades WHERE nombre = 'Otitis externa leve'),
    s.id
FROM sintomas s
WHERE s.nombre IN (
    'Dolor al tocar la oreja',
    'Picazón',
    'Enrojecimiento',
    'Sensación de oído tapado',
    'Secreción leve'
)
AND NOT EXISTS (
    SELECT 1 FROM enfermedad_sintoma es
    WHERE es.enfermedad_id = (SELECT id FROM enfermedades WHERE nombre = 'Otitis externa leve')
    AND es.sintoma_id = s.id
);
