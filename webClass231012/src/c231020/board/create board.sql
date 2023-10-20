  create table boards(
  id number generated as identity primary key,
  user varchar2(10) not null,
  title varchar2(30) not null,
  content long not null,
  created_at timestamp default sysdate
  );