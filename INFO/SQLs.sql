
-- СТВОРЕННЯ БАЗИ ДАНИХ
-- Можливість створення БД з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Тут, БД створюємо через візуальний інструмент, наприклад,
-- MySQL Workbench.
CREATE DATABASE demo_db;

-- СТВОРЕННЯ ТАБЛИЦ ---
-- Можливість створення таблиць БД, з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Попередньо, необхідно спроектувати таблиці та їх зв'язки,
-- на основі сутностей реального світу.
-- Тут, таблиці БД створюємо через візуальний інструмент, наприклад,
-- MySQL Workbench.

-- Таблиця посад персоналу.
-- Робимо перелік необхідних посад в окремій таблиці.
-- У різних працівників може бути одна посада.
-- Можна легко редагувати значення (за потреби).
CREATE TABLE IF NOT EXISTS positions
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

-- Внесення даних до таблиці посад
INSERT INTO positions (name) VALUES (?);

-- Вибірка посад
SELECT * FROM positions;

-- Таблиця працівників
CREATE TABLE IF NOT EXISTS employees
( id INTEGER NOT NULL AUTO_INCREMENT,
  lastName VARCHAR(128) NOT NULL,
  firstName VARCHAR(128) NOT NULL,
  birthDate DATE NOT NULL,
  positionId INTEGER NOT NULL,
  phone VARCHAR(32) NOT NULL,
  salary DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (positionId) REFERENCES positions(id)
);

-- Внесення даних до таблиці працівників
INSERT INTO employees (lastName, firstName, birthDate, positionId, phone, salary) 
VALUES (?, ?, ?, ?, ?, ?);

-- Вибірка працівників
SELECT * FROM employees e 
INNER JOIN positions p ON e.positionId = p.id;

