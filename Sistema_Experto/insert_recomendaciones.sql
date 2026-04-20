-- =====================================================
-- INSERT: recomendaciones

-- =====================================================
-- Resfriado común
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Beber abundante agua y líquidos calientes'
FROM enfermedades WHERE nombre = 'Resfriado común';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hacer reposo y dormir lo suficiente'
FROM enfermedades WHERE nombre = 'Resfriado común';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar lavados nasales con solución salina para la congestión'
FROM enfermedades WHERE nombre = 'Resfriado común';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consumir miel y limón para aliviar la tos leve'
FROM enfermedades WHERE nombre = 'Resfriado común';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar exposición al frío y cambios bruscos de temperatura'
FROM enfermedades WHERE nombre = 'Resfriado común';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Paracetamol si hay malestar general'
FROM enfermedades WHERE nombre = 'Resfriado común';

-- =====================================================
-- Gripe
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Reposar de 2 a 3 días'
FROM enfermedades WHERE nombre = 'Gripe';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hidratarse con agua e infusiones'
FROM enfermedades WHERE nombre = 'Gripe';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Controlar la fiebre con paracetamol o ibuprofeno'
FROM enfermedades WHERE nombre = 'Gripe';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar automedicarse con antibióticos'
FROM enfermedades WHERE nombre = 'Gripe';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'No realizar actividades físicas intensas'
FROM enfermedades WHERE nombre = 'Gripe';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar al médico si la fiebre dura más de 3 días'
FROM enfermedades WHERE nombre = 'Gripe';

-- =====================================================
-- Alergia estacional
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar exposición al polen'
FROM enfermedades WHERE nombre = 'Alergia estacional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Realizar lavados nasales con solución salina'
FROM enfermedades WHERE nombre = 'Alergia estacional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Ducharse y cambiarse de ropa al llegar de la calle'
FROM enfermedades WHERE nombre = 'Alergia estacional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar antihistamínicos recetados'
FROM enfermedades WHERE nombre = 'Alergia estacional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener los espacios libres de polvo'
FROM enfermedades WHERE nombre = 'Alergia estacional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar purificador de aire si es posible'
FROM enfermedades WHERE nombre = 'Alergia estacional';

-- =====================================================
-- Sinusitis aguda
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hacer inhalaciones de vapor'
FROM enfermedades WHERE nombre = 'Sinusitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar compresas tibias en el rostro'
FROM enfermedades WHERE nombre = 'Sinusitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aumentar el consumo de líquidos'
FROM enfermedades WHERE nombre = 'Sinusitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hacer lavados nasales con solución salina'
FROM enfermedades WHERE nombre = 'Sinusitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Tomar analgésicos si hay dolor'
FROM enfermedades WHERE nombre = 'Sinusitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Acudir al médico si los síntomas persisten más de 10 días'
FROM enfermedades WHERE nombre = 'Sinusitis aguda';

-- =====================================================
-- Faringitis viral
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Guardar reposo vocal'
FROM enfermedades WHERE nombre = 'Faringitis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Beber agua tibia e infusiones'
FROM enfermedades WHERE nombre = 'Faringitis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hacer gárgaras con agua tibia y sal'
FROM enfermedades WHERE nombre = 'Faringitis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consumir pastillas para la garganta si no hay alergia'
FROM enfermedades WHERE nombre = 'Faringitis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar bebidas frías y alimentos ácidos'
FROM enfermedades WHERE nombre = 'Faringitis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Tomar analgésicos si hay malestar intenso'
FROM enfermedades WHERE nombre = 'Faringitis viral';

-- =====================================================
-- Amigdalitis leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Beber líquidos tibios'
FROM enfermedades WHERE nombre = 'Amigdalitis leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hacer gárgaras con agua tibia y sal'
FROM enfermedades WHERE nombre = 'Amigdalitis leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener reposo'
FROM enfermedades WHERE nombre = 'Amigdalitis leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Tomar analgésicos si hay dolor'
FROM enfermedades WHERE nombre = 'Amigdalitis leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consumir alimentos blandos'
FROM enfermedades WHERE nombre = 'Amigdalitis leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar al médico si la fiebre supera 38.5 °C'
FROM enfermedades WHERE nombre = 'Amigdalitis leve';

-- =====================================================
-- Laringitis
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Reposar la voz'
FROM enfermedades WHERE nombre = 'Laringitis';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hidratarse con agua tibia'
FROM enfermedades WHERE nombre = 'Laringitis';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar irritantes como humo y alcohol'
FROM enfermedades WHERE nombre = 'Laringitis';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Humidificar el ambiente'
FROM enfermedades WHERE nombre = 'Laringitis';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consumir miel con limón si no hay contraindicación'
FROM enfermedades WHERE nombre = 'Laringitis';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Acudir al médico si la ronquera dura más de 2 semanas'
FROM enfermedades WHERE nombre = 'Laringitis';

-- =====================================================
-- Bronquitis aguda
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Ingesta de líquidos tibios'
FROM enfermedades WHERE nombre = 'Bronquitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar fumar y humo/polvo'
FROM enfermedades WHERE nombre = 'Bronquitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Reposo relativo'
FROM enfermedades WHERE nombre = 'Bronquitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Inhalar vapor'
FROM enfermedades WHERE nombre = 'Bronquitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar miel o pastillas para la garganta'
FROM enfermedades WHERE nombre = 'Bronquitis aguda';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar con un profesional si dura más de 2–3 semanas'
FROM enfermedades WHERE nombre = 'Bronquitis aguda';

-- =====================================================
-- Tos irritativa
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar cambios bruscos de temperatura'
FROM enfermedades WHERE nombre = 'Tos irritativa';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Buena hidratación'
FROM enfermedades WHERE nombre = 'Tos irritativa';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar fumar y humo de segunda mano'
FROM enfermedades WHERE nombre = 'Tos irritativa';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Pastillas para suavizar la garganta'
FROM enfermedades WHERE nombre = 'Tos irritativa';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener la cabeza algo elevada al dormir'
FROM enfermedades WHERE nombre = 'Tos irritativa';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar con un profesional si la tos persiste más de 2 semanas'
FROM enfermedades WHERE nombre = 'Tos irritativa';

-- =====================================================
-- COVID-19 leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aislamiento domiciliario'
FROM enfermedades WHERE nombre = 'COVID-19 leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Uso de mascarilla'
FROM enfermedades WHERE nombre = 'COVID-19 leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hidratación adecuada'
FROM enfermedades WHERE nombre = 'COVID-19 leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Control de la fiebre'
FROM enfermedades WHERE nombre = 'COVID-19 leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Vigilar signos de alarma'
FROM enfermedades WHERE nombre = 'COVID-19 leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar con un profesional de salud ante empeoramiento'
FROM enfermedades WHERE nombre = 'COVID-19 leve';

-- =====================================================
-- Gastroenteritis viral
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Beber suero de rehidratación'
FROM enfermedades WHERE nombre = 'Gastroenteritis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar comidas grasosas, picantes o muy pesadas'
FROM enfermedades WHERE nombre = 'Gastroenteritis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Iniciar dieta blanda progresiva'
FROM enfermedades WHERE nombre = 'Gastroenteritis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Lavarse bien las manos'
FROM enfermedades WHERE nombre = 'Gastroenteritis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Vigilar signos de deshidratación'
FROM enfermedades WHERE nombre = 'Gastroenteritis viral';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar con un profesional si es muy abundante'
FROM enfermedades WHERE nombre = 'Gastroenteritis viral';

-- =====================================================
-- Indigestión
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Comer porciones pequeñas y masticar lentamente'
FROM enfermedades WHERE nombre = 'Indigestión';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar algunas comidas'
FROM enfermedades WHERE nombre = 'Indigestión';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar acostarse después de comer'
FROM enfermedades WHERE nombre = 'Indigestión';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Reducir consumo de algunas bebidas'
FROM enfermedades WHERE nombre = 'Indigestión';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Registrar alimentos que desencadenan molestias'
FROM enfermedades WHERE nombre = 'Indigestión';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar con un profesional si los síntomas son frecuentes'
FROM enfermedades WHERE nombre = 'Indigestión';

-- =====================================================
-- Reflujo gastroesofágico
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar acostarse dentro de las 2–3 horas posteriores a las comidas'
FROM enfermedades WHERE nombre = 'Reflujo gastroesofágico';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Elevar la cabecera de la cama algunos centímetros'
FROM enfermedades WHERE nombre = 'Reflujo gastroesofágico';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar algunas comidas'
FROM enfermedades WHERE nombre = 'Reflujo gastroesofágico';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener un peso saludable'
FROM enfermedades WHERE nombre = 'Reflujo gastroesofágico';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Comer porciones pequeñas y frecuentes'
FROM enfermedades WHERE nombre = 'Reflujo gastroesofágico';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar con un profesional si los síntomas son recurrentes'
FROM enfermedades WHERE nombre = 'Reflujo gastroesofágico';

-- =====================================================
-- Estreñimiento
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aumentar la ingesta de agua'
FROM enfermedades WHERE nombre = 'Estreñimiento';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Incrementar consumo de fibra'
FROM enfermedades WHERE nombre = 'Estreñimiento';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Establecer horarios regulares para ir al baño sin prisas'
FROM enfermedades WHERE nombre = 'Estreñimiento';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Realizar actividad física moderada con frecuencia'
FROM enfermedades WHERE nombre = 'Estreñimiento';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar abuso de laxantes'
FROM enfermedades WHERE nombre = 'Estreñimiento';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consultar con un profesional si es crónico'
FROM enfermedades WHERE nombre = 'Estreñimiento';

-- =====================================================
-- Intolerancia a la lactosa leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Reducir lácteos enteros y preferir productos sin lactosa o bebidas vegetales'
FROM enfermedades WHERE nombre = 'Intolerancia a la lactosa leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Probar pequeñas cantidades de yogurt o quesos maduros solo si se toleran bien'
FROM enfermedades WHERE nombre = 'Intolerancia a la lactosa leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar comidas muy grasosas que aumenten el malestar'
FROM enfermedades WHERE nombre = 'Intolerancia a la lactosa leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener una dieta ligera en episodios de molestias'
FROM enfermedades WHERE nombre = 'Intolerancia a la lactosa leve';

-- =====================================================
-- Gastritis leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Comer porciones pequeñas y frecuentes, evitando picantes, café, frituras y alcohol'
FROM enfermedades WHERE nombre = 'Gastritis leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'No acostarse tras comer y beber agua en pequeñas cantidades'
FROM enfermedades WHERE nombre = 'Gastritis leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Reducir estrés y evitar alimentos muy ácidos o grasos'
FROM enfermedades WHERE nombre = 'Gastritis leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener horarios regulares'
FROM enfermedades WHERE nombre = 'Gastritis leve';

-- =====================================================
-- Síndrome del colon irritable leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Identificar alimentos desencadenantes y evitarlos'
FROM enfermedades WHERE nombre = 'Síndrome del colon irritable leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aumentar fibra soluble y preferir comidas ligeras'
FROM enfermedades WHERE nombre = 'Síndrome del colon irritable leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Comer despacio y mantener actividad física regular'
FROM enfermedades WHERE nombre = 'Síndrome del colon irritable leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Controlar el estrés con técnicas de relajación'
FROM enfermedades WHERE nombre = 'Síndrome del colon irritable leve';

-- =====================================================
-- Hipoglucemia leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consumir azúcar rápida como jugo, miel o caramelos al sentir síntomas'
FROM enfermedades WHERE nombre = 'Hipoglucemia leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Esperar 15 minutos y reevaluar'
FROM enfermedades WHERE nombre = 'Hipoglucemia leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener horarios de comida y evitar saltarlas'
FROM enfermedades WHERE nombre = 'Hipoglucemia leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Llevar snacks si la actividad es prolongada'
FROM enfermedades WHERE nombre = 'Hipoglucemia leve';

-- =====================================================
-- Dermatitis por contacto
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar el agente irritante y lavar la zona con agua tibia'
FROM enfermedades WHERE nombre = 'Dermatitis por contacto';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar compresas frías para aliviar la picazón'
FROM enfermedades WHERE nombre = 'Dermatitis por contacto';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar cremas calmantes como aloe vera'
FROM enfermedades WHERE nombre = 'Dermatitis por contacto';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener la piel hidratada y evitar rascar'
FROM enfermedades WHERE nombre = 'Dermatitis por contacto';

-- =====================================================
-- Urticaria Leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar calor, sudor y ropa ajustada'
FROM enfermedades WHERE nombre = 'Urticaria Leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar compresas frías para disminuir la picazón'
FROM enfermedades WHERE nombre = 'Urticaria Leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'No rascar las ronchas y mantener la piel fresca'
FROM enfermedades WHERE nombre = 'Urticaria Leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Identificar posibles desencadenantes como alimentos o detergentes'
FROM enfermedades WHERE nombre = 'Urticaria Leve';

-- =====================================================
-- Acné leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Lavar el rostro 1–2 veces al día con limpiadores suaves'
FROM enfermedades WHERE nombre = 'Acné leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'No reventar granos y usar productos no comedogénicos'
FROM enfermedades WHERE nombre = 'Acné leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener el cabello limpio y evitar tocar la cara'
FROM enfermedades WHERE nombre = 'Acné leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar protector solar para piel grasa'
FROM enfermedades WHERE nombre = 'Acné leve';

-- =====================================================
-- Picadura de insecto
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Lavar la zona con agua y jabón'
FROM enfermedades WHERE nombre = 'Picadura de insecto';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar compresas frías para reducir la inflamación'
FROM enfermedades WHERE nombre = 'Picadura de insecto';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar crema calmante de aloe vera'
FROM enfermedades WHERE nombre = 'Picadura de insecto';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar rascarse y monitorear cualquier signo de infección o fiebre'
FROM enfermedades WHERE nombre = 'Picadura de insecto';

-- =====================================================
-- Irritación por calor
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener la piel seca y fresca'
FROM enfermedades WHERE nombre = 'Irritación por calor';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar ropa ligera y transpirable'
FROM enfermedades WHERE nombre = 'Irritación por calor';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar compresas frías para calmar la picazón'
FROM enfermedades WHERE nombre = 'Irritación por calor';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar el sudor excesivo y no usar cremas grasosas que obstruyan los poros'
FROM enfermedades WHERE nombre = 'Irritación por calor';

-- =====================================================
-- Pie de atleta
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Lavar y secar bien los pies'
FROM enfermedades WHERE nombre = 'Pie de atleta';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Cambiar medias a diario'
FROM enfermedades WHERE nombre = 'Pie de atleta';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar talco secante'
FROM enfermedades WHERE nombre = 'Pie de atleta';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar caminar descalzo en lugares públicos'
FROM enfermedades WHERE nombre = 'Pie de atleta';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Si no mejora, buscar atención médica'
FROM enfermedades WHERE nombre = 'Pie de atleta';

-- =====================================================
-- Dolor de cabeza tensional
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Descansar en un lugar tranquilo'
FROM enfermedades WHERE nombre = 'Dolor de cabeza tensional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Hacer estiramientos suaves del cuello'
FROM enfermedades WHERE nombre = 'Dolor de cabeza tensional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantenerse hidratado'
FROM enfermedades WHERE nombre = 'Dolor de cabeza tensional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar el uso excesivo de pantallas'
FROM enfermedades WHERE nombre = 'Dolor de cabeza tensional';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Dormir lo necesario para aliviar el malestar'
FROM enfermedades WHERE nombre = 'Dolor de cabeza tensional';

-- =====================================================
-- Migraña leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Descansar en un cuarto oscuro y silencioso'
FROM enfermedades WHERE nombre = 'Migraña leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar compresas frías en la frente'
FROM enfermedades WHERE nombre = 'Migraña leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar ruidos y pantallas'
FROM enfermedades WHERE nombre = 'Migraña leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantenerse hidratado'
FROM enfermedades WHERE nombre = 'Migraña leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Detectar posibles desencadenantes para evitar futuros episodios'
FROM enfermedades WHERE nombre = 'Migraña leve';

-- =====================================================
-- Dolor lumbar leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar cargar peso'
FROM enfermedades WHERE nombre = 'Dolor lumbar leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Descansar pero sin permanecer en cama por mucho tiempo'
FROM enfermedades WHERE nombre = 'Dolor lumbar leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar calor local'
FROM enfermedades WHERE nombre = 'Dolor lumbar leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener una postura adecuada'
FROM enfermedades WHERE nombre = 'Dolor lumbar leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Realizar estiramientos suaves si no hay dolor adicional'
FROM enfermedades WHERE nombre = 'Dolor lumbar leve';

-- =====================================================
-- Fatiga o cansancio general
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Dormir entre 8 y 9 horas'
FROM enfermedades WHERE nombre = 'Fatiga o cansancio general';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener una buena hidratación'
FROM enfermedades WHERE nombre = 'Fatiga o cansancio general';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Consumir alimentos saludables'
FROM enfermedades WHERE nombre = 'Fatiga o cansancio general';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Tomar descansos si hubo mucho esfuerzo físico o mental'
FROM enfermedades WHERE nombre = 'Fatiga o cansancio general';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Reducir el estrés'
FROM enfermedades WHERE nombre = 'Fatiga o cansancio general';

-- =====================================================
-- Conjuntivitis viral leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Lavar las manos antes de tocar los ojos'
FROM enfermedades WHERE nombre = 'Conjuntivitis viral leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar compresas frías para calmar la irritación'
FROM enfermedades WHERE nombre = 'Conjuntivitis viral leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar frotarse los ojos'
FROM enfermedades WHERE nombre = 'Conjuntivitis viral leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'No compartir toallas ni maquillaje'
FROM enfermedades WHERE nombre = 'Conjuntivitis viral leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Usar lágrimas artificiales si hay sequedad'
FROM enfermedades WHERE nombre = 'Conjuntivitis viral leve';

-- =====================================================
-- Otitis externa leve
-- =====================================================
INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Mantener el oído seco'
FROM enfermedades WHERE nombre = 'Otitis externa leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Evitar el uso de hisopos'
FROM enfermedades WHERE nombre = 'Otitis externa leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Secar bien el oído externo después del baño'
FROM enfermedades WHERE nombre = 'Otitis externa leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Aplicar calor tibio para aliviar molestias'
FROM enfermedades WHERE nombre = 'Otitis externa leve';

INSERT INTO recomendaciones (id, enfermedad_id, recomendacion)
SELECT gen_random_uuid(), id, 'Buscar atención médica si el dolor persiste o hay fiebre'
FROM enfermedades WHERE nombre = 'Otitis externa leve';
