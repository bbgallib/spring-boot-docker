SET CHARSET UTF8;

DROP TABLE IF EXISTS profiles;

CREATE TABLE profiles (
  id            int auto_increment,
  name          varchar(100)  NOT NULL,
  name_kana     varchar(100)  NOT NULL,
  unit_name     varchar(100)  NOT NULL,
  age           varchar(3)   NOT NULL,
  blood         varchar(2)   NOT NULL,
  birth_day     varchar(6)   NOT NULL,
  zodiac_sign   varchar(50)  NOT NULL,
  height        varchar(3)   NOT NULL,
  weight        varchar(3)   NOT NULL,
  bwh           varchar(8)   NOT NULL,
  dominant_hand varchar(50)   NOT NULL,
  birth_place   varchar(50)   NOT NULL,
  favorite      varchar(200) NULL,
  special_skill varchar(200) NULL,
  cv            varchar(100)  NOT NULL,
  PRIMARY KEY(id, name)
);
