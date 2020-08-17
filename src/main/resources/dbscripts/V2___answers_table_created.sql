
create table ANSWERS(
    id serial primary key,
    text varchar(200) not null,
    question_id integer not null,
    is_right boolean not null,
    foreign key (question_id) references QUESTIONS(id)
);

-- some test values
-- in seeds