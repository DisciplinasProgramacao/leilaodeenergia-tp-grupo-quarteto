DROP TABLE IF EXISTS EMPRESA_VENDEDORA;
CREATE TABLE EMPRESA_VENDEDORA
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    quant_disponivel INT NOT NULL,
    quant_vendida INT NULL
);

INSERT INTO EMPRESA_VENDEDORA (nome, quant_disponivel, quant_vendida)
VALUES ('Empresa P', 4000 , 0),
       ('Empresa O', 4000 , 0);

DROP TABLE IF EXISTS EMPRESA_INTERESSADA;
CREATE TABLE EMPRESA_INTERESSADA
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    quant_requerida INT NOT NULL,
    valor DOUBLE NOT NULL,
    vendedora_id BIGINT,

    FOREIGN KEY (vendedora_id) REFERENCES EMPRESA_VENDEDORA (id)
);

INSERT INTO EMPRESA_INTERESSADA (nome, quant_requerida, valor, vendedora_id)
VALUES ('Empresa A', 1000, 20,1),
       ('Empresa 9', 700, 12,1),
       ('Empresa B', 1600, 50,1),
       ('Empresa 10', 600, 30,1),
       ('Empresa C', 8900, 25,1),
       ('Empresa D', 800, 27,1),
       ('Empresa E', 600, 36,1),
       ('Empresa F', 100, 34,1),
       ('Empresa G', 50, 8,1),
       ('Empresa H', 20, 1.5,1);
INSERT INTO EMPRESA_INTERESSADA (nome, quant_requerida, valor, vendedora_id)
VALUES ('Empresa A', 9000, 10,2),
       ('Empresa B', 500, 50,2),
       ('Empresa C', 9000, 55,2),
       ('Empresa D', 20, 20,2),
       ('Empresa E', 1, 10,2),
       ('Empresa F', 800, 34,2),
       ('Empresa G', 50, 8,2),
       ('Empresa H', 100, 11,2);