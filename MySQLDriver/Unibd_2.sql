﻿-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema unibd
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `unibd` ;

-- -----------------------------------------------------
-- Schema unibd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `unibd` DEFAULT CHARACTER SET utf8 ;
USE `unibd` ;

-- -----------------------------------------------------
-- Table `unibd`.`cadastro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `unibd`.`cadastro` ;

CREATE TABLE IF NOT EXISTS `unibd`.`cadastro` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome_Completo` VARCHAR(100) NOT NULL,
  `Data_de_Nascimento` VARCHAR(25) NOT NULL,
  `Sexo` VARCHAR(9) NOT NULL,
  `CPF` VARCHAR(15) NOT NULL,
  `RG` VARCHAR(20) NOT NULL,
  `CEP` VARCHAR(10) NOT NULL,
  `Endereco` VARCHAR(100) NOT NULL,
  `Numero` VARCHAR(10) NOT NULL,
  `Complemento` VARCHAR(45) NULL DEFAULT NULL,
  `Bairro` VARCHAR(35) NOT NULL,
  `Cidade` VARCHAR(35) NOT NULL,
  `UF` VARCHAR(10) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `Telefone_Residencial` VARCHAR(20) NOT NULL,
  `Telefone_Celular` VARCHAR(20) NOT NULL,
  `Universidade` VARCHAR(50) NOT NULL,
  `EnderecoUniversidade` VARCHAR(100) NOT NULL,
  `Curso` VARCHAR(50) NOT NULL,
  `Usuario` VARCHAR(50) NOT NULL,
  `Senha` VARCHAR(50) NOT NULL,
  `PerguntaSecreta` VARCHAR(50) NOT NULL,
  `Cargo` VARCHAR(50) NOT NULL,
  `Categoria` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `unibd`.`sugestoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `unibd`.`sugestoes` ;

CREATE TABLE IF NOT EXISTS `unibd`.`sugestoes` (
  `ID_Sugestao` INT(11) NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(50) NOT NULL,
  `Texto` VARCHAR(500) NOT NULL,
  `Data_Postada` VARCHAR(45) NOT NULL,
  `Status_Sugestao` VARCHAR(50) NOT NULL,
  `Like_Positivo` INT(11) NOT NULL,
  `Deslike_Negativo` INT(11) NOT NULL,
  `Categoria` VARCHAR(45) NOT NULL,
  `cadastro_ID` INT(11) NOT NULL,
  `Autor` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_Sugestao`),
  INDEX `fk_sugestoes_cadastro1_idx` (`cadastro_ID` ASC),
  CONSTRAINT `fk_sugestoes_cadastro1`
    FOREIGN KEY (`cadastro_ID`)
    REFERENCES `unibd`.`cadastro` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `unibd`.`comentario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `unibd`.`comentario` ;

CREATE TABLE IF NOT EXISTS `unibd`.`comentario` (
  `ID_Comentario` INT(11) NOT NULL AUTO_INCREMENT,
  `Comentario` VARCHAR(120) NOT NULL,
  `Data_Comentario` VARCHAR(45) NOT NULL,
  `Hora_Comentario` VARCHAR(45) NOT NULL,
  `sugestoes_ID_Sugestao` INT(11) NOT NULL,
  `cadastro_ID` INT(11) NOT NULL,
  `Autor` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_Comentario`, `cadastro_ID`),
  INDEX `fk_comentario_sugestoes1_idx` (`sugestoes_ID_Sugestao` ASC),
  INDEX `fk_comentario_cadastro1_idx` (`cadastro_ID` ASC),
  CONSTRAINT `fk_comentario_cadastro1`
    FOREIGN KEY (`cadastro_ID`)
    REFERENCES `unibd`.`cadastro` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentario_sugestoes1`
    FOREIGN KEY (`sugestoes_ID_Sugestao`)
    REFERENCES `unibd`.`sugestoes` (`ID_Sugestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `unibd`.`votos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `unibd`.`votos` ;

CREATE TABLE IF NOT EXISTS `unibd`.`votos` (
  `ID_Votos` INT(11) NOT NULL AUTO_INCREMENT,
  `cadastro_ID` INT(11) NOT NULL,
  `sugestoes_ID_Sugestao` INT(11) NOT NULL,
  PRIMARY KEY (`ID_Votos`),
  INDEX `fk_Like_Gostei_cadastro_idx` (`cadastro_ID` ASC),
  INDEX `fk_Like_Gostei_sugestoes1_idx` (`sugestoes_ID_Sugestao` ASC),
  CONSTRAINT `fk_Like_Gostei_cadastro`
    FOREIGN KEY (`cadastro_ID`)
    REFERENCES `unibd`.`cadastro` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Like_Gostei_sugestoes1`
    FOREIGN KEY (`sugestoes_ID_Sugestao`)
    REFERENCES `unibd`.`sugestoes` (`ID_Sugestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




INSERT INTO cadastro (Nome_Completo, Data_de_Nascimento, Sexo, CPF, RG, CEP, Endereco, Numero, Complemento, Bairro, Cidade, UF, Email, Telefone_Residencial, Telefone_Celular, Universidade, EnderecoUniversidade, Curso, Usuario, Senha, PerguntaSecreta, Cargo, Categoria)VALUES('Admin', '01/01/2016', 'Masculino', '010.101.010-10', '01.010.101-0', '00000-000', 'Rua.', '00', '', 'Mooca', 'São Paulo', 'SP', 'Admin@gmail.com', '(  )     -    ', '(11) 00000-0000', 'Universidade Novo Intelecto', ' Av. Brigadeiro Faria Lima, 2443 - Itaim Bibi', 'Analise e desenvolvimento de sistemas', 'Admin', 'admin', 'Admin', 'Superior', 'Admin');
INSERT INTO cadastro (Nome_Completo, Data_de_Nascimento, Sexo, CPF, RG, CEP, Endereco, Numero, Complemento, Bairro, Cidade, UF, Email, Telefone_Residencial, Telefone_Celular, Universidade, EnderecoUniversidade, Curso, Usuario, Senha, PerguntaSecreta, Cargo, Categoria)VALUES('Avaliador', '01/01/2016', 'Masculino', '010.101.010-10', '01.010.101-0', '00000-000', 'Rua.', '00', '', 'Mooca', 'São Paulo', 'SP', 'Avaliador@gmail.com', '(  )     -    ', '(11) 00000-0000', 'Universidade Novo Intelecto', ' Av. Brigadeiro Faria Lima, 2443 - Itaim Bibi', 'Analise e desenvolvimento de sistemas', 'Avaliador', 'Avaliador', 'Avaliador', 'Avaliador', 'Infraestrutura');
INSERT INTO cadastro (Nome_Completo, Data_de_Nascimento, Sexo, CPF, RG, CEP, Endereco, Numero, Complemento, Bairro, Cidade, UF, Email, Telefone_Residencial, Telefone_Celular, Universidade, EnderecoUniversidade, Curso, Usuario, Senha, PerguntaSecreta, Cargo, Categoria)VALUES('Colaborador', '01/01/2016', 'Masculino', '010.101.010-10', '01.010.101-0', '00000-000', 'Rua.', '00', '', 'Mooca', 'São Paulo', 'SP', 'Colaborador@gmail.com', '(  )     -    ', '(11) 00000-0000', 'Universidade Novo Intelecto', ' Av. Brigadeiro Faria Lima, 2443 - Itaim Bibi', 'Analise e desenvolvimento de sistemas', 'Colaborador', 'Colaborador', 'Colaborador', 'Colaborador', 'Colaborador');
