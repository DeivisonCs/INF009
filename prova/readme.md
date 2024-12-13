# Inserções para teste

```
INSERT INTO role (id, role) VALUES (1, 'ADMIN_USER'), (2, 'COMMON_USER');
INSERT INTO usuario (id, username, password) VALUES
	(1, 'Admin dos Santos', '$2a$12$afDlpPRJ0v5xQ5.Hj.uGbe/UsjVwGHIO1oqkoOxIAQLgsU427bkKG'),
	(2, 'Comum da Silva', '$2a$12$afDlpPRJ0v5xQ5.Hj.uGbe/UsjVwGHIO1oqkoOxIAQLgsU427bkKG');
-- 	123456

INSERT INTO usuario_roles VALUES (1,1), (2,2);
```
