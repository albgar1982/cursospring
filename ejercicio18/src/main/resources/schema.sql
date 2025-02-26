/*
	Equivalencias de tipo de datos en Java / SQL
		long -> bigint
		String -> varchar
*/
create table cursos(
	id bigint not null,
	curso varchar(255) not null,
	autor varchar(255) not null,
	primary key(id)
);