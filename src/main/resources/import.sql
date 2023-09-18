INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('João', 'Silva', 'joao@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Ana', 'Pereira', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Carlos', 'Santos', 'carlos@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Mariana', 'Oliveira', 'mariana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Pedro', 'Ribeiro', 'pedro@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_MANAGER');
INSERT INTO tb_role (authority) VALUES ('ROLE_EMPLOYEE');
INSERT INTO tb_role (authority) VALUES ('ROLE_GUEST');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 4);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 5);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 2);

INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Project 1', 'Location 1', 100000.00, '2023-01-01', '2023-12-31', 'Project 1 description', 50000.00, 25000.00);
INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Project 2', 'Location 2', 150000.00, '2024-01-01', '2024-12-31', 'Project 2 description', 75000.00, 30000.00);
INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Project 3', 'Location 3', 80000.00, '2023-03-01', '2023-11-30', 'Project 3 description', 40000.00, 20000.00);
INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Project 4', 'Location 4', 120000.00, '2024-02-15', '2024-10-31', 'Project 4 description', 60000.00, 30000.00);
INSERT INTO tb_project (project_name, location, budget, start_date, estimated_completion_date, description, balance,  operating_costs) VALUES ('Project 5', 'Location 5', 90000.00, '2023-06-01', '2023-09-30', 'Project 5 description', 45000.00, 22000.00);

INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Cost 1 description', 5000.00, '2023-03-15', 1);
INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Cost 2 description', 7000.00, '2023-04-20', 1);
INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Cost 3 description', 6000.00, '2023-05-25', 2);
INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Cost 4 description', 8000.00, '2023-06-30', 2);
INSERT INTO tb_cost (description, amount, date, project_id) VALUES ('Cost 5 description', 5500.00, '2023-07-05', 3);

INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Risk 1 description', 0.2, 0.4, 0.1, 1);
INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Risk 2 description', 0.3, 0.5, 0.2, 1);
INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Risk 3 description', 0.1, 0.2, 0.05, 2);
INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Risk 4 description', 0.4, 0.6, 0.15, 2);
INSERT INTO tb_risk (description, probability, impact, real_estate_risk, project_id) VALUES ('Risk 5 description', 0.5, 0.3, 0.1, 3);

INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Type 1', 'Document 1', '2023-02-10', 'Document 1 description', 1);
INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Type 2', 'Document 2', '2023-03-05', 'Document 2 description', 1);
INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Type 1', 'Document 3', '2023-04-20', 'Document 3 description', 2);
INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Type 2', 'Document 4', '2023-05-15', 'Document 4 description', 2);
INSERT INTO tb_document (document_type, document_name, sent_date, description, project_id) VALUES ('Type 1', 'Document 5', '2023-06-10', 'Document 5 description', 3);

INSERT INTO tb_user_project (user_id, project_id) VALUES (1, 1);
INSERT INTO tb_user_project (user_id, project_id) VALUES (1, 2);
INSERT INTO tb_user_project (user_id, project_id) VALUES (2, 1);
INSERT INTO tb_user_project (user_id, project_id) VALUES (3, 3);
INSERT INTO tb_user_project (user_id, project_id) VALUES (4, 2);