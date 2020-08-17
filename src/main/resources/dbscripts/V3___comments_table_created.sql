
create table COMMENTS(
    id serial primary key,
    author varchar(50) not null,
    text varchar(200) not null,
    creation_time timestamp,
    question_id integer,
    foreign key (question_id) references QUESTIONS(id)
);

-- some test values
-- in seeds