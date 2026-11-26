
CREATE TABLE products (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sku VARCHAR(50) NOT NULL UNIQUE,
    nome VARCHAR(150) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    brand VARCHAR(100),
    bar_code VARCHAR(50),
    cost_price NUMERIC(12,2) NOT NULL,
    sell_price NUMERIC(12,2) NOT NULL,
    measurement_unit VARCHAR(20) NOT NULL
);