create table polls (
   id integer not null,
   title varchar(255) not null,
   description varchar(max) not null,
   active bit default 1,
   shared bit default 1,
   primary key(id)
);