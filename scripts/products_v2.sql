-- 1. Remove a coluna antiga
ALTER TABLE products
    DROP COLUMN measurement_unit;

-- 2. Adiciona a nova coluna
ALTER TABLE products
    ADD COLUMN weight NUMERIC(10,3);

-- 3. Atualiza o registro existente
UPDATE products
SET weight = 1.000
WHERE weight IS NULL;

-- 4. Torna a coluna obrigatória
ALTER TABLE products
    ALTER COLUMN weight SET NOT NULL;