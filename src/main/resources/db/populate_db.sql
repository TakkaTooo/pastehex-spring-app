INSERT INTO states (title) VALUES
('ACTIVE'),
('BANNED'),
('DELETED');

INSERT INTO roles (title) VALUES
('ADMIN'),
('MODERATOR'),
('USER');

INSERT INTO programming_languages (title) VALUES
('None'),
('Java'),
('C++'),
('Python'),
('Rust');

INSERT INTO expirations (title, removal_time) VALUES
('Never', null),
('10 Minutes', 600),
('1 Hour', 3600),
('1 Day', 86400),
('1 Week', 2073600),
('2 Weeks', 414720),
('1 Month', 8294400),
('6 Month', 49766400),
('1 Year', 31536000);

INSERT INTO exposures (title) VALUES
('Public'),
('Private');

INSERT INTO paste_settings (programming_language_id, expiration_id, exposure_id) VALUES
(1, 1, 1);

INSERT INTO users (email, login, password, role_id, state_id, default_paste_settings) VALUES
('maksim.astash@gmail.com', 'admin', '$2a$10$VM5KO28.rqM3/WextvASU.6dqkhML5LQZwwM8p.J.XaAUAl6nxfq6', 1, 1, 1);

INSERT INTO folders (title, user_id) VALUES
('Default', 1);