
create table QUESTIONS(
    id serial primary key,
    text varchar(200) not null,
    is_multi boolean not null
);

-- some test values
insert into QUESTIONS values(default, 'anytext1', true);
insert into QUESTIONS values(default, 'anytext2', false);
insert into QUESTIONS values(default, 'anytext3', true);
insert into QUESTIONS values(default, 'anytext4', false);
insert into QUESTIONS values(default, 'anytext5', false);
