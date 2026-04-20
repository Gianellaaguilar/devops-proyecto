-- =====================================================
-- INSERT: enfermedades
-- Basado en las enfermedades de las capturas de pantalla
-- =====================================================

INSERT INTO enfermedades (id, nombre, categoria, descripcion) VALUES
-- Gastrointestinal
(gen_random_uuid(), 'Reflujo gastroesofágico', 'Gastrointestinal', 'Condición donde el ácido del estómago regresa al esófago'),
(gen_random_uuid(), 'Gastritis leve', 'Gastrointestinal', 'Inflamación leve del revestimiento del estómago'),
(gen_random_uuid(), 'Gastroenteritis viral', 'Gastrointestinal', 'Inflamación del estómago e intestinos causada por virus'),
(gen_random_uuid(), 'Indigestión', 'Gastrointestinal', 'Malestar digestivo que ocurre después de comer'),
(gen_random_uuid(), 'Estreñimiento', 'Gastrointestinal', 'Dificultad para evacuar o disminución en la frecuencia'),
(gen_random_uuid(), 'Síndrome del colon irritable leve', 'Gastrointestinal', 'Trastorno funcional del intestino que causa malestar'),
(gen_random_uuid(), 'Intolerancia a la lactosa leve', 'Gastrointestinal', 'Dificultad para digerir la lactosa, el azúcar de la leche'),

-- Dermatológico
(gen_random_uuid(), 'Dermatitis por contacto', 'Dermatológico', 'Inflamación de la piel causada por contacto con sustancias'),
(gen_random_uuid(), 'Urticaria Leve', 'Dermatológico', 'Erupción cutánea caracterizada por ronchas y picazón'),
(gen_random_uuid(), 'Picadura de insecto', 'Dermatológico', 'Reacción local de la piel a la picadura de un insecto'),
(gen_random_uuid(), 'Acné leve', 'Dermatológico', 'Condición de la piel caracterizada por espinillas y comedones'),
(gen_random_uuid(), 'Pie de atleta', 'Dermatológico', 'Infección fúngica que afecta los pies, especialmente entre los dedos'),
(gen_random_uuid(), 'Irritación por calor', 'Dermatológico', 'Erupción cutánea causada por el sudor atrapado'),

-- Respiratorio
(gen_random_uuid(), 'Resfriado común', 'Respiratorio', 'Enfermedad viral leve que afecta el tracto respiratorio superior'),
(gen_random_uuid(), 'Gripe', 'Respiratorio', 'Infección viral respiratoria más severa que el resfriado'),
(gen_random_uuid(), 'Bronquitis aguda', 'Respiratorio', 'Inflamación de los bronquios que causa tos y dificultad respiratoria'),
(gen_random_uuid(), 'Tos irritativa', 'Respiratorio', 'Tos seca y persistente sin producción de flema'),
(gen_random_uuid(), 'Sinusitis aguda', 'Respiratorio', 'Inflamación de los senos paranasales generalmente por infección'),
(gen_random_uuid(), 'Alergia estacional', 'Respiratorio', 'Reacción alérgica a alérgenos ambientales como polen'),
(gen_random_uuid(), 'COVID-19 leve', 'Respiratorio', 'Infección viral respiratoria causada por el coronavirus SARS-CoV-2'),
(gen_random_uuid(), 'Faringitis viral', 'Respiratorio', 'Inflamación de la faringe causada por virus'),
(gen_random_uuid(), 'Laringitis', 'Respiratorio', 'Inflamación de la laringe que causa ronquera'),

-- Otorrinolaringológico
(gen_random_uuid(), 'Otitis externa leve', 'Otorrinolaringológico', 'Inflamación del conducto auditivo externo'),
(gen_random_uuid(), 'Amigdalitis leve', 'Otorrinolaringológico', 'Inflamación de las amígdalas de leve a moderada'),

-- Neurológico
(gen_random_uuid(), 'Dolor de cabeza tensional', 'Neurológico', 'Dolor de cabeza común causado por tensión muscular'),
(gen_random_uuid(), 'Migraña leve', 'Neurológico', 'Tipo de dolor de cabeza pulsátil que puede causar náuseas'),

-- Musculoesquelético
(gen_random_uuid(), 'Dolor lumbar leve', 'Musculoesquelético', 'Dolor en la región baja de la espalda, generalmente por tensión'),

-- General
(gen_random_uuid(), 'Fatiga o cansancio general', 'General', 'Sensación generalizada de falta de energía y cansancio'),

-- Oftalmológico
(gen_random_uuid(), 'Conjuntivitis viral leve', 'Oftalmológico', 'Inflamación de la conjuntiva del ojo causada por virus'),

-- Metabólico
(gen_random_uuid(), 'Hipoglucemia leve', 'Metabólico', 'Nivel bajo de azúcar en sangre que causa síntomas leves');

