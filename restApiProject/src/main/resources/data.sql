INSERT INTO USUARIOS(ID,NAME,BIRTH_DATE) values 
	(10001,'Alberto',CURRENT_DATE),
	(10002,'Laura',CURRENT_DATE),
	(10003,'Pepito',CURRENT_DATE);
	
INSERT INTO PUBLICACIONES(ID,MENSAJE,USUARIO_ID) values --IMPORTANTÍSIMO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! EN EL INSERT SE PONE EL NOMBRE DADO A LA ENTIDAD SI ES DISTINTO AL DE LA CLASE Y, ADEMAS, SE USA EL NOMBRE_ID PARA EL CAMPO
	(20001,'El capitalismo no es la solucion.',10001),
	(20002,'Aguas revueltas, ganancia de pescadores.',10001),
	(20003,'Quiero que se solucione todo, son todos iguales.',10002);
