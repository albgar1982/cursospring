-- Sin especificar ID
-- Deben aniadirse ciertas propiedades en el properties, porque, si no, Spring carga esto primero y luego las entidades y fallara, al no existir aun tarea
INSERT INTO tareas (descripcion, nombre_usuario, fecha_objetivo, hecho) 
VALUES 
    ('Hacer la compra', 'Alber', '2025-04-01', false),
    ('Celebrar cumpleaños', 'Alber', '2025-04-06', false),
    ('Conseguir un trabajo', 'Alber', '2025-03-28', false),
    ('Aprobar la oposición', 'Laura', '2025-11-22', false),
    ('Comprar el piso', 'Laura', '2025-05-29', false);