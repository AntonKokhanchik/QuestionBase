
create table ANSWERS(
    id serial primary key,
    author varchar(50) not null,
    text varchar(200) not null,
    creation_time timestamp,
    question_id integer,
    foreign key (question_id) references QUESTIONS(id)
);

-- some test values
insert into ANSWERS values(default, 'Alex2', 'anytext1', '2019-04-15 12:01:00',1);
insert into ANSWERS values(default, 'Alex3', 'anytext2', '2019-04-15 12:02:00',1);
insert into ANSWERS values(default, 'Alex4', 'anytext3', '2019-04-15 12:03:00',1);
insert into ANSWERS values(default, 'Alex5', 'anytext4', '2019-04-15 12:04:00',2);
insert into ANSWERS values(default, 'Alex5', 'anytext5', '2019-04-15 12:05:00',3);
