DROP TABLE IF EXISTS EMPRESA_VENDEDORA;
CREATE TABLE EMPRESA_VENDEDORA
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    quant_disponivel INT NOT NULL,
    quant_vendida INT NULL
);

INSERT INTO EMPRESA_VENDEDORA (nome, quant_disponivel, quant_vendida)
VALUES ('Empresa P', 4000 , 0);

DROP TABLE IF EXISTS EMPRESA_INTERESSADA;
CREATE TABLE EMPRESA_INTERESSADA
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    quant_requerida INT NOT NULL,
    valor INT NOT NULL,
    vendedora_id BIGINT,

    FOREIGN KEY (vendedora_id) REFERENCES EMPRESA_VENDEDORA (id)
);

INSERT INTO EMPRESA_INTERESSADA (nome, quant_requerida, valor)
VALUES ('Empresa A', 1000, 20),
       ('Empresa 9', 700, 12),
       ('Empresa B', 1600, 50),
       ('Empresa 10', 600, 30),
       ('Empresa C', 8900, 25),
       ('Empresa D', 800, 27),
       ('Empresa E', 600, 36);