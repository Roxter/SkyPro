CREATE TABLE cars (
                      id SERIAL PRIMARY KEY,
                      brand VARCHAR(50) NOT NULL,
                      model VARCHAR(50) NOT NULL,
                      cost NUMERIC(10, 2) NOT NULL
);

CREATE TABLE people (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        age INTEGER CHECK (age > 0),
                        has_license BOOLEAN DEFAULT FALSE,
                        car_id INTEGER REFERENCES cars(id)
);