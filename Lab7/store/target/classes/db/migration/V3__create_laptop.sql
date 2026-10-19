CREATE TABLE laptop (
    id SERIAL PRIMARY KEY,
    processor VARCHAR(20) NOT NULL,
    ram INT NOT NULL,
    weight DOUBLE PRECISION NOT NULL,
    electronics_id INT NOT NULL REFERENCES electronics(id)
);
