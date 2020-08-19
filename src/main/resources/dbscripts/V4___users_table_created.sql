
create table USERS(
    login varchar(50) primary key,
    password varchar(50) not null,
    full_name varchar(100) not null,
    is_admin boolean default false
);

alter table COMMENTS rename column author to author_name;
alter table COMMENTS add author_login varchar(50);
alter table COMMENTS add foreign key (author_login) references USERS(login);