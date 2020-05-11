create table if not exists users_table (
  id bigserial not null,
  fullName varchar(255) not null,
  username varchar(255) not null,
  password varchar(255) not null,
  primary key (id)
);