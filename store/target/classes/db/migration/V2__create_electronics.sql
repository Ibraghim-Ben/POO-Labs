CREATE TABLE electronics (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(20) NOT NULL,
    warranty_months INT NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    store_id INT NOT NULL REFERENCES store(id)
);
