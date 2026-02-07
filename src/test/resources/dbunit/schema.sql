DROP TABLE IF EXISTS profiles;

CREATE TABLE profiles (
  id            INT AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(100)  NOT NULL,
  name_kana     VARCHAR(100)  NOT NULL,
  unit_name     VARCHAR(100)  NOT NULL,
  age           VARCHAR(3)    NOT NULL,
  blood         VARCHAR(5)    NOT NULL,
  birth_day     VARCHAR(6)    NOT NULL,
  zodiac_sign   VARCHAR(50)   NOT NULL,
  height        VARCHAR(5)    NOT NULL,
  weight        VARCHAR(5)    NOT NULL,
  bwh           VARCHAR(8)    NOT NULL,
  dominant_hand VARCHAR(50)   NOT NULL,
  birth_place   VARCHAR(50)   NOT NULL,
  favorite      VARCHAR(200),
  special_skill VARCHAR(200),
  cv            VARCHAR(100)  NOT NULL
);
