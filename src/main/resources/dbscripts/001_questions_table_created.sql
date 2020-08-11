
create table QUESTIONS(
    id decimal primary key,
    author varchar(50) not null,
    text varchar(200) not null,
    creation_time timestamp
);

-- some test values
insert into QUESTIONS values(1, 'Alex1', 'anytext1', '2019-04-15 10:00:00');
insert into QUESTIONS values(2, 'Alex2', 'anytext2', '2019-04-15 10:00:00');
insert into QUESTIONS values(3, 'Alex3', 'anytext3', '2019-04-15 10:00:00');
insert into QUESTIONS values(4, 'Alex4', 'anytext4', '2019-04-15 10:00:00');
insert into QUESTIONS values(5, 'Alex5', 'anytext5', '2019-04-15 10:00:00');
