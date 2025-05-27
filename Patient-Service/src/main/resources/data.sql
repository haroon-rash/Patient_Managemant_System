-- Ensure the 'patient' table exists
CREATE TABLE IF NOT EXISTS patient
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    phone       VARCHAR(255)        NOT NULL,
    date_of_birth   DATE                NOT NULL,
    registered_date DATE                NOT NULL
    );

-- Insert patient records with Pakistani names and phone numbers
INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'Ali Khan',
       'ali.khan@example.com',
       'House 12, F-10, Islamabad',
       '0300-1234567',
       '1985-06-15',
       '2024-01-10'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Ayesha Malik',
       'ayesha.malik@example.com',
       'Street 45, DHA Phase 6, Lahore',
       '0321-9876543',
       '1990-09-23',
       '2023-12-01'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174001');

INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174002',
       'Usman Ahmed',
       'usman.ahmed@example.com',
       'Flat 8B, Clifton Block 5, Karachi',
       '0333-4567890',
       '1978-03-12',
       '2022-06-20'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174002');

INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174003',
       'Zainab Fatima',
       'zainab.fatima@example.com',
       'House 22, Satellite Town, Rawalpindi',
       '0345-1122334',
       '1982-11-30',
       '2023-05-14'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174003');

INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174004',
       'Bilal Raza',
       'bilal.raza@example.com',
       'Street 7, Gulshan-e-Iqbal, Karachi',
       '0312-3344556',
       '1995-02-05',
       '2024-03-01'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174004');

-- Additional Pakistani names
INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174005',
       'Hina Tariq',
       'hina.tariq@example.com',
       'House 101, Model Town, Lahore',
       '0301-6677889',
       '1988-07-25',
       '2024-02-15'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174005');

INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174006',
       'Hamza Sheikh',
       'hamza.sheikh@example.com',
       'Street 9, G-11, Islamabad',
       '0308-9988776',
       '1992-04-18',
       '2023-08-25'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174006');

INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174007',
       'Fatima Shah',
       'fatima.shah@example.com',
       'Flat 203, Bahria Town, Rawalpindi',
       '0340-7766554',
       '1975-01-11',
       '2022-10-10'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174007');

INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174008',
       'Ahmed Nawaz',
       'ahmed.nawaz@example.com',
       'House 56, Gulberg, Lahore',
       '0355-2233445',
       '1989-09-02',
       '2024-04-20'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174008');

INSERT INTO patient (id, name, email, address, phone, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174009',
       'Rabia Yousaf',
       'rabia.yousaf@example.com',
       'Street 10, PWD Colony, Islamabad',
       '0306-5566778',
       '1993-11-15',
       '2023-06-30'
    WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174009');
