# portfolioBackEnd BY ABEL DEV
espacio para guardar la parte logica e interactiva

DESARROLLADO CON LAS SIGUIENTES TECNOLOGIAS:
- APACHE NETBEANS IDE 17
- XAMPP CONTROL PANEL (PARTE DE PRUEBA)
- SPRING TOOLSUITE4 (CONTROL DE VERSIONES, DEPRECATED CODE, COMPATIBILIDAD DE LIBRERIAS JAVA, PATH CONFIGURACION, OPCIONES EXTRA MAVEN Y DEBUG)
- ECLIPSE IDE FOR JAVA DEVELOPERS VERSION 2022 (CONTROL EXTERNO DE ERRORES MEDIANTE LAS HERRAMIENTAS QUE OFRECE EL IDE)
- GIT Y GITHUB (PARA CONTROL DE VERSIONES Y SUBIDA A REPOSITORIO REMOTO)
- FIREFOX DEV TOOLS (CONTROL DE CONSOLA DE ERRORES)
- SPRINGBOOT VERSION 2.7.10
- JAVA VERSION 17
- POSTMAN

ESTE CODIGO SE COMPLEMENTA CON LO QUE SE DESARROLLA EN EL FRONTEND.
EL BACKEND PERMITE EL CONTROL Y ADMINISTRACION DE:

ENTIDAD (SEGUN ORDEN JERARQUICO:
- CONSTRUCCION (BUILD) DE TABLAS DE BASE DE DATOS CON UN MAXIMO DE CONEXIONES (2) POR MEDIDAS DE SEGURIDAD Y PRODUCTIVIDAD
- LOGIN (ALTA DE NUEVAS PERSONAS, CREACION DEL ROL (ADMIN OR USER) Y TOKEN PARA LOGIN) / TOKEN ACCES MEDIANTE JSON Web Token
- PERSONA (NOMBRE, APELLIDO, DESCRIPCION, CONTRASEÑA, IMAGEN)
- EXPERIENCIA LABORAL (CREACION Y MODIFICACION DE UNA EXPERIENCIA LABORAL A TRAVES DEL FRONTEND)
- EDUCACION (CREACION Y MODIFICACION DE UNA EDUCACION A TRAVES DEL FRONTEND)
- HABILIDADES (CREACION Y MODIFICACION DE UNA HABILIDAD A TRAVES DEL FRONTEND)
- SEGURIDAD INTEGRADA

PARA USAR ESTE PROYECTO DESDE 0 NECESITAS SABER:

ANTES DE EJECUTAR O COMPILAR LA APLICACION:
- ASEGURATE DE TENER BIEN LINKEADOS LOS ENLACES DEL BACKEND CON EL FRONTEND.
- ASEGURATE DE HABER CREADO UNA BASE DE DATOS YA SEA LOCAL/VIRTUAL/NUBE Y LINKEARLA CORRECTAMENTE EN APLICATION.PROPERTIES DENTRO DEL IDE COLOCANDO LAS RESPECTIVAS RUTAS.
- ASEGURATE QUE DE TENER TODOS LOS PATH Y LIBRERIAS ACTUALIZADAS.
- (IMPORTANTE) TENER EN CUENTA QUE "RUN APLICATION" NO ES LO MISMO QUE "BUILD".
- ANTES DE EJECUTAR POSICIONARSE EN LA CARPETA RAIZ DEL PROYECTO Y SELECCIONAR "BUILD" "CLEAN AND BUILD" OR "BUILD WITH DEPENDENCIES" DE ESTA MANERA SE GENERAN LAS TABLAS EN LA BASE DE DATOS.
- REVISAR ERRORES O COMPROBAR SI LO "CONSTRUYO" CORRECTAMENTE MEDIANTE EL SIGUIENTE MENSAJE "BUILD SUCCESS" 

AL EJECUTAR EL PROYECTO:
- IR A LA BASE DE DATOS DEL PROYECTO
- CREAR LA CANTIDAD DE DOS (2) ROLES DENTRO DE LA TABLA "ROL" [ROLE_ADMIN, ROLE_USER] CUYO ID DEBERA SER 1 PARA ADMIN Y 2 PARA USER
- IR A POSTMAN Y CREAR U NUEVO CODIGO DE AUTORIZACION MEDIANTE LA RUTA https://TURUTADELBACK/auth/nuevo
- PARA CREAR UNA PERSONA SE DEBERAN RESPETAR LOS SIGUIENTES CAMPOS: [contraseña, correo, nombre, nombre_usuario Y ROL [ROLE_ADMIN, ROLE_USER]] SE DEBE USAR EN POSTMAN EL CAMPO "RAW" Y NOTACION "JSON"
- ASEGURARSE QUE LA PERSONA QUE DIMOS DE ALTA PUEDA LOGEARSE MEDIANTE LA RUTA https://TURUTADELBACK/auth/login
- FINALMENTE CREA EN LA BASE DE DATOS, DENTRO DE LA TABLA "PERSONA" UNA PERSONA CON LOS SIGUIENTES DATOS: [apellido, descripcion, img, nombre]

*** IMPORTANTE ***
- ASEGURARSE DE CORREGIR LOS CAMPOS DE LAS TABLAS DENTRO DE LA BASE DE DATOS
ESPECIFICAMENTA LA DE IMG DANDOLE COMO VALOR DE CAMBIO A 255 ASEGURANDONOS QUE LA URL GENERADA EN FIREBASE SERA ACEPTADA Y NO ENTREGARA ERRORES
- EN EL CAMPO IMG DENTRO DE NUESTRA BASE DE DATOS DEBE ESTAR EN BLANCO DESDE UN PRINCIPIO (LUEGO TOMARA LA URL GENERADA POR FIREBASE DESDE UNA PETICION DEL FRONTEND)

ESO ES TODO --- ENJOY --- ///***ABELDEV***///
CONTACTAME */*/*/*
FACEBOOK: https://www.facebook.com/abel.velez/
LINKEDIN: https://www.linkedin.com/in/abel-v%C3%A9lez/
