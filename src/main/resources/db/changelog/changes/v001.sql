create table if not exists users_table (
  id bigserial not null,
  fullname varchar(255) not null,
  username varchar(255) not null,
  password varchar(255) not null,
  isAccountNotExpired boolean,
  isAccountNonLocked boolean,
  isCredentialsNonExpired boolean,
  isEnabled boolean,
  primary key (id)
);