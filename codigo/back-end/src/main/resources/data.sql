DROP TABLE IF EXISTS EMPRESA_VENDEDORA;
CREATE TABLE EMPRESA_VENDEDORA (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    quantidade_disponivel INT NOT NULL
);

INSERT INTO EMPRESA_VENDEDORA (nome, quantidade_disponivel) VALUES ('Empresa P', 100);

DROP TABLE IF EXISTS EMPRESA_INTERESSADA;
CREATE TABLE EMPRESA_INTERESSADA (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    lance DOUBLE NOT NULL,
    lote_energia_id BIGINT
);


DROP TABLE IF EXISTS LOTE_ENERGIA;
CREATE TABLE LOTE_ENERGIA (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tamanho INT NOT NULL,
    empresa_vendedora_id BIGINT,
    empresa_compradora_id BIGINT,
    FOREIGN KEY (empresa_vendedora_id) REFERENCES EMPRESA_VENDEDORA(id),
    FOREIGN KEY (empresa_compradora_id) REFERENCES EMPRESA_INTERESSADA(id)
);

INSERT INTO LOTE_ENERGIA (tamanho, empresa_vendedora_id, empresa_compradora_id) VALUES
(10, 1, NULL),
(20, 1, NULL),
(30, 1, NULL);

ALTER TABLE EMPRESA_INTERESSADA
ADD CONSTRAINT fk_lote_energia
FOREIGN KEY (lote_energia_id) REFERENCES LOTE_ENERGIA(id);

INSERT INTO EMPRESA_INTERESSADA (nome, lance, lote_energia_id) VALUES
('Empresa A', 1000, 1),
('Empresa 9', 700, 2),
('Empresa B', 1600, 1),
('Empresa 10', 600, 3),
('Empresa C', 8900, 2),
('Empresa D', 800, 2),
('Empresa E', 600, 3);
