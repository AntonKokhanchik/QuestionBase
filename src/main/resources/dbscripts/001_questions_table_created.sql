
create table QUESTIONS(
    id serial primary key,
    author varchar(50) not null,
    text varchar(200) not null,
    creation_time timestamp
);

-- some test values
insert into QUESTIONS values(default, 'Alex1', 'anytext1', '2019-04-15 10:00:00');
insert into QUESTIONS values(default, 'Alex2', 'anytext2', '2019-04-15 10:00:00');
insert into QUESTIONS values(default, 'Alex3', 'anytext3', '2019-04-15 10:00:00');
insert into QUESTIONS values(default, 'Alex4', 'anytext4', '2019-04-15 10:00:00');
insert into QUESTIONS values(default, 'Alex5', 'anytext5', '2019-04-15 10:00:00');
