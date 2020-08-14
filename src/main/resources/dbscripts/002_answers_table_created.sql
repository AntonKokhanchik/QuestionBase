
create table ANSWERS(
    id serial primary key,
    text varchar(200) not null,
    question_id integer not null,
    is_right boolean not null,
    foreign key (question_id) references QUESTIONS(id)
);

-- some test values
insert into ANSWERS values(default, 'answer 1 for question 1', 1, true);
insert into ANSWERS values(default, 'answer 2 for question 1', 1, false);
insert into ANSWERS values(default, 'answer 3 for question 1', 1, false);
insert into ANSWERS values(default, 'answer 4 for question 1', 1, true);
insert into ANSWERS values(default, 'answer 1 for question 2', 2, false);
insert into ANSWERS values(default, 'answer 2 for question 2', 2, false);
insert into ANSWERS values(default, 'answer 3 for question 2', 2, true);
insert into ANSWERS values(default, 'answer 1 for question 3', 3, true);
insert into ANSWERS values(default, 'answer 2 for question 3', 3, true);
insert into ANSWERS values(default, 'answer 3 for question 3', 3, false);
insert into ANSWERS values(default, 'answer 1 for question 4', 4, false);
insert into ANSWERS values(default, 'answer 2 for question 4', 4, true);
insert into ANSWERS values(default, 'answer 3 for question 4', 4, false);
insert into ANSWERS values(default, 'answer 4 for question 4', 4, false);
insert into ANSWERS values(default, 'answer 1 for question 5', 5, true);
insert into ANSWERS values(default, 'answer 2 for question 5', 5, false);
insert into ANSWERS values(default, 'answer 3 for question 5', 5, false);
insert into ANSWERS values(default, 'answer 4 for question 5', 5, false);
