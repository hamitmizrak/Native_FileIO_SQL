-- SQL: Structure Query Language
-- non-case sentive
-- 1049: database veya table ismi yanlışsa
-- 1054: yanlış attributes

-- Drop database
DROP DATABASE `one_page`;

-- Tuncate
TRUNCATE `one_page`.`blog`;

-- ##########################################################
-- Create Database
CREATE SCHEMA `one_page` DEFAULT CHARACTER SET utf8 ;

-- Database select
use one_page;

-- Create Table
CREATE TABLE `one_page`.`blog` (
   `id` INT NOT NULL AUTO_INCREMENT,
   `header` VARCHAR(400) NULL DEFAULT 'blog başlığınıı girmediniz',
   `content` MEDIUMBLOB NULL,
   `created_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`));

-- ###############################################################################
-- insert
insert into one_page.blog (header,content) values ("Css2","Cont data css");

-- update
update  one_page.blog set header="Hamit55",content="Mızrak55" where id =1;

-- delete
delete FROM one_page.blog where id="1";
-- ##### SELECT ##########################################################################
-- Select
SELECT * FROM one_page.blog;

-- Count
select count(*) from one_page.blog;

-- find
select * from one_page.blog where id =1;

-- find sadece name
select header from one_page.blog;
select header from one_page.blog where id = 1;

-- #### LIKE ###########################################################################
-- like : Search
-- header kolonunda p ile başlayan değerleri bul
select * from one_page.blog where header like 'M%';

-- header kolonunda p ile biten değerleri bul
select * from one_page.blog  where header like '%1';

-- header kolonunda ikinci harfi s olan bütün verileri listele
select * from one_page.blog  where header like '_s%';
select header from one_page.blog  where header like '_s%';

-- header ve content
select * from one_page.blog  where header like 'H%' or content like 'c%';
