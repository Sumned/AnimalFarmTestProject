DROP DATABASE IF EXISTS animal_farm;
CREATE DATABASE animal_farm;
use animal_farm;

create table lions
(
    id    BIGINT      NOT NULL UNIQUE AUTO_INCREMENT,
    name varchar(64) NOT NULL UNIQUE,
    creating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modification_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key (id),
    index idx_lion_name(name)
) ENGINE = InnoDB;

 CREATE TABLE `TABLE_SEQUENCE` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into TABLE_SEQUENCE VALUES(0);

create table cows
(
    id    BIGINT      NOT NULL UNIQUE AUTO_INCREMENT,
    name varchar(64) NOT NULL UNIQUE,
    creating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modification_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    lion_id BIGINT,
    primary key (id),
    constraint fk_schedule_cow_lion FOREIGN KEY (lion_id) references lions (id) on delete cascade,
    index idx_cow_name(name)
) ENGINE = InnoDB;

create table goats
(
    id    BIGINT      NOT NULL UNIQUE AUTO_INCREMENT,
    name varchar(64) NOT NULL UNIQUE,
    creating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modification_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    lion_id BIGINT,
    primary key (id),
    constraint fk_schedule_goat_lion FOREIGN KEY (lion_id) references lions (id) on delete cascade,
    index idx_goat_name(name)
) ENGINE = InnoDB;

create table grass
(
  id    BIGINT      NOT NULL UNIQUE AUTO_INCREMENT,
  creating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  last_modification_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  primary key (id),
  cow_id BIGINT,
  goat_id BIGINT,

  constraint fk_schedule_grass_cow FOREIGN KEY (cow_id) references cows (id) on delete cascade,
  constraint fk_schedule_grass_goat FOREIGN KEY (goat_id) references goats (id) on delete cascade
) ENGINE = InnoDB;


