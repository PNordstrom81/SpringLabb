DROP TABLE IF EXISTS cars;

CREATE TABLE cars (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  brand VARCHAR(250) NOT NULL,
  model VARCHAR(250) DEFAULT NULL

);

INSERT INTO cars (brand, model) VALUES
  ('Volvo', '740'),
  ('Porsche', 'GT'),
  ('Tesla', 'X');