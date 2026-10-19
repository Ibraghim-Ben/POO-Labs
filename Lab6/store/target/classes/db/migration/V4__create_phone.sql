CREATE TABLE phone (
    id SERIAL PRIMARY KEY,
    model VARCHAR(20) NOT NULL,
    os VARCHAR(15) NOT NULL,
    battery INT NOT NULL,
    camera INT NOT NULL,
    electronics_id INT NOT NULL REFERENCES electronics(id)
);
