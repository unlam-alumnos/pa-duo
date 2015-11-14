% Ejercicio1/2
bebida(agua).
bebida(vino).
bebida(cerveza).
entrada(paella).
entrada(gazpacho).
entrada(consome).
carne(filete_de_cerdo).
carne(pollo_asado).
pescado(trucha).
pescado(bacalao).
postre(flan).
postre(helado).
postre(pastel).

comida(X,Y,Z):-entrada(X),(carne(Y);pescado(Y)),postre(Z).
comida_consome(X,Y,Z):-comida(X,Y,Z),(X == consome).
comida_no_flan(X,Y,Z):-comida(X,Y,Z),not(Z == flan).
menu(X,Y,Z,W):-bebida(X),comida(Y,Z,W).

% END Ejercicio1/2

% Ejercicio3
hombre(pedro).
hombre(manuel).
hombre(arturo).
mujer(maria).
padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, maria).

ninio(X,Y):-padre(Y,X).
hijo(X,Y):-ninio(X,Y),hombre(X).
hija(X,Y):-ninio(X,Y),mujer(X).
hermano_hermana(X,Y):-ninio(X,Z),ninio(Y,Z),not(X==Y).
hermano(X,Y):-hermano_hermana(X,Y),hombre(X).
hermana(X,Y):-hermano_hermana(Y,X),mujer(X).
% END Ejercicio3

% Ejercicio4
multiplicar(P,X,Y):-P is X*Y.
sumar(S,X,Y):-S is X+Y.
menor(X,Y):-X<Y.

ciudad(roma).
ciudad(londres).
ciudad(tunez).
transporte(roma,7000).
transporte(tunez,6000).
transporte(londres,9000).
comodidad(hotel,roma,1300).
comodidad(hotel,londres,1500).
comodidad(hotel,tunez,1000).
comodidad(hostel,roma,700).
comodidad(hostel,londres,900).
comodidad(hostel,tunez,650).
comodidad(camping,roma,500).
comodidad(camping,londres,550).
comodidad(camping,tunez,400).

% END Ejercicio4


% Ejercicio9

ventas1erSem(gonzalo,8000).
ventas1erSem(jorge,10000).
ventas1erSem(carlos,5000).
ventas1erSem(hugo,21000).
ventas1erSem(juan,20000).


ventas2doSem(gonzalo,2000).
ventas2doSem(jorge,10000).
ventas2doSem(carlos,16000).
ventas2doSem(juan,1000).

comision20(V,T):-ventas1erSem(V,T1),ventas2doSem(V,T2),T is T1+T2,T>20000.
comision10(V,T):-ventas1erSem(V,T1),ventas2doSem(V,T2),T is T1+T2,T=<20000.
comision5(V):-(ventas1erSem(V,_);ventas2doSem(V,_)),not(comision20(V,_)),not(comision10(V,_)).


% END Ejercicio9

% Sugerido PROMOCIONASTE

parcial1(ana,7).
parcial1(juan,4).
parcial1(cris,7).
parcial1(gaston,9).
parcial1(pablo,9).
parcial1(gonzalo,8).
parcial1(lucas,6).
parcial2(ana,4).
parcial2(juan,4).
parcial2(cris,7).
parcial2(gaston,7).
parcial2(pablo,7).
parcial2(gonzalo,7).
parcial2(laura,4).

notas(A,P1,P2):-parcial1(A,P1),parcial2(A,P2).
parcial1_aplazado(A):-parcial1(A,N),(N<4).
parcial2_aplazado(A):-parcial2(A,N),(N<4).
parcial1_cursado(A,N):-parcial1(A,N),(N>=4).
parcial2_cursado(A,N):-parcial2(A,N),(N>=4).
parcial1_promocion(A,N):-parcial1(A,N),(N>=7).
parcial2_promocion(A,N):-parcial2(A,N),(N>=7).
promedio(P,A,B):-P is (A+B)/2.
promocionan(A,NF):-parcial1_promocion(A,N1),parcial2_promocion(A,N2),promedio(NF,N1,N2).
recursan(A):-parcial1_aplazado(A);parcial2_aplazado(A).
cursada(A):-parcial1_cursado(A,_),parcial2_cursado(A,_),not(promocionan(A,_)).
producto_cartesiano(X,Y):-promocionan(_,X),promocionan(_,Y).
seleccion_menores(X,Y):-producto_cartesiano(X,Y),(X<Y).
proyeccion(X):-seleccion_menores(X,_).
maximo(X):-promocionan(_,X),not(proyeccion(X)).
merito(A,NF):-promocionan(A,NF),maximo(NF).
ausentes(A):-(parcial1(A,_);parcial2(A,_)),not(notas(A,_,_)).
% END PROMOCIONASTE

% SUGERIDO BACTERIAS

medicion(1,3000,32000).
medicion(2,1000,9000).
medicion(3,2000,15000).
medicion(4,1500,14000).
medicion(5,1000,11000).

validas(N,X,Y,D):-medicion(N,X,Y),D is Y-X,D=<10000.
priValida(N,X,Y,D):-validas(N,X,Y,D),!.

producto_cartesiano2(X,Y):-validas(_,_,X,_),validas(_,_,Y,_).
seleccion_menores2(X,Y):-producto_cartesiano2(X,Y),(X<Y).
proyeccion2(X):-seleccion_menores2(X,_).
maximo2(X):-validas(_,_,X,_),not(proyeccion2(X)).

maxValida(N,X,Y,D):-validas(N,X,Y,D),maximo2(Y).
% END BACTERIAS


% SUGERIDOS LIQUIDOS VENENOSOS

par(violeta,azul).
par(rojo,amarillo).
par(azul,anaranjado).
par(violeta,amarillo).
par(rojo,anaranjado).
par(verde,azul).

venenoso(X):-


% END SUGERIDOS LIQUIDOS VENENOSOS
