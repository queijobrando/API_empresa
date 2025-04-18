ALTER TABLE funcionarios
ADD COLUMN setor_id BIGINT,
ADD CONSTRAINT fk_funcionarios_setor
FOREIGN KEY (setor_id)
REFERENCES setor(id);
