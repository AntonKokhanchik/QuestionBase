
create table QUESTIONS(
    id serial primary key,
    text varchar(200) not null,
    is_multi boolean not null
);

-- some test values
-- in seeds