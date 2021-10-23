INSERT INTO states (title) VALUES
('ACTIVE'),
('BANNED'),
('DELETED');

INSERT INTO roles (title) VALUES
('ADMIN'),
('MODERATOR'),
('USER');

INSERT INTO users (email, login, password, role_id, state_id) VALUES
('maksim.astash@gmail.com', 'admin', '$2a$10$VM5KO28.rqM3/WextvASU.6dqkhML5LQZwwM8p.J.XaAUAl6nxfq6', 1, 1);
