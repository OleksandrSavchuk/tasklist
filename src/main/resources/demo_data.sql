insert into users (name, username, password)
values ('John Doe', 'johndoe', '$2a$10$zyCeB0D3qKNT0Zr6dEkYEOocDWseb84CEOMevM3Npx.q2IIzlVSFG'),
       ('Oleksandr Savchuk', 'oleksandr', '$2a$10$3LC3TDKi2wRqCg64/GuNreGj9nuEGA2RLGNiQEYBEF./Uyabpckwq'),
       ('Mike Smith', 'mikesmith', '$2a$10$HziXbrbvIgt8kbjHPVtD/udrI3/bOgYcqTxlG8hMaG5XtEpfpo26m');


insert into tasks (title, description, status, expiration_date)
values ('Buy cheese', null, 'TODO', '2024-09-21 12:00:00'),
       ('Do homework', 'Math, Physics, Literature', 'IN_PROGRESS', '2024-09-28 15:00:00'),
       ('Clean rooms', null, 'DONE', null),
       ('Call Mike', null, 'TODO', '2024-10-01 10:00:00');

insert into users_tasks (task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');