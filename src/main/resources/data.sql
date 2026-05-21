
INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('jperez', 'Juan', 'Pérez', 'juan.perez@example.com', 'ADMIN', '12345', 'San Francisco');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('mgarcia', 'María', 'García', 'maria.garcia@example.com', 'USER', '23456', 'Austin');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('clopez', 'Carlos', 'López', 'carlos.lopez@example.com', 'MANAGER', '34567', 'Aspen');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('asanchez', 'Ana', 'Sánchez', 'ana.sanchez@example.com', 'USER', '45678', 'Monterrey');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('drodriguez', 'David', 'Rodríguez', 'david.rodriguez@example.com', 'USER', '56789', 'Guadalajara');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('lfernandez', 'Laura', 'Fernández', 'laura.fernandez@example.com', 'ADMIN', '67890', 'CDMX');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('jmoreno', 'Javier', 'Moreno', 'javier.moreno@example.com', 'MANAGER', '78901', 'Puebla');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('mramirez', 'Marta', 'Ramírez', 'marta.ramirez@example.com', 'USER', '89012', 'Veracruz');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('atorres', 'Alejandro', 'Torres', 'alejandro.torres@example.com', 'USER', '90123', 'La Paz');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('pflores', 'Patricia', 'Flores', 'patricia.flores@example.com', 'MANAGER', '01234', 'Santiago');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('rvazquez', 'Raúl', 'Vázquez', 'raul.vazquez@example.com', 'USER', '11223', 'Sao Paulo');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('sruiz', 'Sofía', 'Ruiz', 'sofia.ruiz@example.com', 'ADMIN', '22334', 'Asunción');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('icastro', 'Irene', 'Castro', 'irene.castro@example.com', 'USER', '33445', 'Montevideo');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('mnavarro', 'Manuel', 'Navarro', 'manuel.navarro@example.com', 'MANAGER', '44556', 'Quito');

INSERT INTO users (user_name, first_name, last_name, email, role, ssn, address)
VALUES ('oramos', 'Olga', 'Ramos', 'olga.ramos@example.com', 'USER', '55667', 'Bogotá');


INSERT INTO Orders(user_id, description) values(1, 'order11');
INSERT INTO Orders(user_id, description) values(1, 'order12');
INSERT INTO Orders(user_id, description) values(1, 'order13');
INSERT INTO Orders(user_id, description) values(2, 'order21');
INSERT INTO Orders(user_id, description) values(2, 'order22');
INSERT INTO Orders(user_id, description) values(3, 'order31');


INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Ana García', 'IT', '08:30:00', '17:30:00', 55000.00, '2023-06-15');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Carlos López', 'IT', '09:00:00', '18:00:00', 62000.00, '2024-01-20');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Marta Rodríguez', 'HR', '08:45:00', '17:15:00', 48000.00, '2022-11-10');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Javier Martínez', 'Sales', '09:30:00', '18:30:00', 71000.00, '2023-09-05');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Laura Fernández', 'Marketing', '08:00:00', '16:30:00', 53000.00, '2023-12-01');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('David Sánchez', 'Finance', '09:15:00', '17:45:00', 67000.00, '2024-03-18');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Elena Gómez', 'IT', '10:00:00', '19:00:00', 59000.00, '2022-08-22');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Pablo Ruiz', 'Sales', '08:30:00', '17:00:00', 68500.00, '2023-10-12');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Sofía Moreno', 'HR', '09:00:00', '17:30:00', 51000.00, '2023-05-30');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Daniel Jiménez', 'Finance', '08:15:00', '16:45:00', 72000.00, '2024-02-14');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Carmen Álvarez', 'Marketing', '09:45:00', '18:15:00', 49500.00, '2022-12-03');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Alejandro Romero', 'IT', '07:30:00', '15:30:00', 64000.00, '2023-07-19');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Isabel Torres', 'Sales', '08:00:00', '16:00:00', 74000.00, '2024-04-25');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Francisco Vázquez', 'HR', '10:15:00', '19:15:00', 46000.00, '2023-01-17');
INSERT INTO employees (name, department, login_time, logout_time, salary, last_promotion_date) VALUES ('Lucía Navarro', 'Finance', '09:30:00', '18:00:00', 70000.00, '2023-11-08');