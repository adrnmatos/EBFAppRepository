create database ebf;

create table ebf.usuario (
id int primary key,
nome varchar(50) not null,
senha varchar(10) not null );

create table ebf.plano (
id int primary key,
nome varchar(20) not null);

create table ebf.cliente (
id int primery key,
nome varchar(30) not null,
rg int not null,
cpf int not null);