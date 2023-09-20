INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('João', 'Silva', 'joao@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Ana', 'Pereira', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Carlos', 'Santos', 'carlos@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Mariana', 'Oliveira', 'mariana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Pedro', 'Ribeiro', 'pedro@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_USER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 2);

INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Edifício Montanha Verde', 'São Paulo', 100000.00, '2023-01-01', '2023-12-31', 'Próximo a trilhas para caminhadas e esportes ao ar livre.', 50000.00, 25000.00);
INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Construção Praia Dourada', 'Rio de Janeiro', 150000.00, '2024-01-01', '2024-12-31', 'Residências à beira-mar com acesso direto à praia.', 75000.00, 30000.00);
INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Complexo Urbanus', 'Rio Grande do Sul', 80000.00, '2023-03-01', '2023-11-30', 'Desenvolvimento sustentável e amigável para pedestres.', 40000.00, 20000.00);
INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Ponte Rio Sereno', 'Minas Gerais',120000.00, '2024-02-15', '2024-10-31', 'Reduzindo tempos de deslocamento e congestionamento.', 60000.00, 30000.00);
INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Torre Vista Panorâmica', 'Mato Grosso', 90000.00, '2023-06-01', '2023-09-30', 'Localização privilegiada no centro da cidade.', 45000.00, 22000.00);

INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Custo de Material', 5000.00, '2023-03-15', 1);
INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Custo de Mão de Obra', 7000.00, '2023-04-20', 1);
INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Custo de Mão de Obra', 6000.00, '2023-05-25', 2);
INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Custo de Material', 8000.00, '2023-06-30', 2);
INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Custo de Mão de Obra', 5500.00, '2023-07-05', 3);

INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Problemas geotécnicos nas montanhas podem comprometer a estabilidade do edifício.', 0.2, 0.4, 0.1, 1);
INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('A exposição à erosão costeira pode ameaçar a integridade das estruturas à beira-mar.', 0.3, 0.5, 0.2, 1);
INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Mudanças na economia podem afetar o financiamento e a demanda por propriedades.', 0.1, 0.2, 0.05, 2);
INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Problemas de construção, como escassez de recursos ou condições imprevisíveis do solo, podem atrasar a conclusão.', 0.4, 0.6, 0.15, 2);
INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Mudanças nas tendências do mercado imobiliário podem afetar a demanda por unidades no edifício.', 0.5, 0.3, 0.1, 3);

INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Contrato', '#001', '2023-02-10', 'Um acordo formal entre o proprietário e a empresa de construção que estabelece os termos, condições e responsabilidades relacionadas à construção.', 1);
INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Contrato', '#002', '2023-03-05', 'Um acordo formal entre o proprietário e a empresa de construção que estabelece os termos, condições e responsabilidades relacionadas à construção.', 1);
INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Contrato', '#003', '2023-04-20', 'Um acordo formal entre o proprietário e a empresa de construção que estabelece os termos, condições e responsabilidades relacionadas à construção.', 2);
INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Contrato', '#004', '2023-05-15', 'Um acordo formal entre o proprietário e a empresa de construção que estabelece os termos, condições e responsabilidades relacionadas à construção.', 2);
INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Contrato', '#005', '2023-06-10', 'Um acordo formal entre o proprietário e a empresa de construção que estabelece os termos, condições e responsabilidades relacionadas à construção.', 3);

INSERT INTO tb_user_project (user_id, project_id) VALUES (1, 1);
INSERT INTO tb_user_project (user_id, project_id) VALUES (1, 2);
INSERT INTO tb_user_project (user_id, project_id) VALUES (2, 1);
INSERT INTO tb_user_project (user_id, project_id) VALUES (3, 3);
INSERT INTO tb_user_project (user_id, project_id) VALUES (4, 2);