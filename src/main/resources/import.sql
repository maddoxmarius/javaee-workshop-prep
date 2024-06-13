-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into real_user (id, name) values(nextval('hibernate_sequence'), 'Markus');
insert into real_user (id, name) values(nextval('hibernate_sequence'), 'Marius');
insert into real_user (id, name) values(nextval('hibernate_sequence'), 'Abdoulaye');

insert into animal (id, name, type, isAvailable) values(nextval('hibernate_sequence'), 'Rex', 0, true);
insert into animal (id, name, type, isAvailable) values(nextval('hibernate_sequence'), 'Pixie', 1, true);
