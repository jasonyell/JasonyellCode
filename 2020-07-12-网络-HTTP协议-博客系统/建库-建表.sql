create database hjb2_blog charset utf8mb4;

use hjb2_blog;

-- 用户表
create table new_table(
  id int primary key auto_increment,
  username varchar(40) not null unique,
  password varchar(100) not null
);

create table article(
  id int primary key auto_increment,
  user_id int not null,
  title varchar(200) not null,
  content text not null,
  published_at datetime not null
);

SELECT
  users.id author_id,
  users.username author_username,
  article.id,
  title,
  published_at
from article join users on article.user_id = users.id
order by published_at desc;

