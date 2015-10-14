parcial_1(ana,7).
parcial_1(juan,4).
parcial_1(cristian,5).
parcial_1(pablo,2).
parcial_1(gonzalo,4).
parcial_1(gaston,9).
parcial_1(diego,5).
parcial_1(javier,4).
parcial_1(federico,8).

parcial_2(ana,7).
parcial_2(juan,7).
parcial_2(cristian,2).
parcial_2(pablo,4).
parcial_2(gonzalo,4).
parcial_2(gaston,8).
parcial_2(diego,7).
parcial_2(javier,4).
parcial_2(federico,8).

notas(X,Y,Z):-parcial_1(X,Y),parcial_2(X,Z).
parcial_1_cursada(X,Y):-parcial_1(X,Y),(Y>=4).
parcial_2_cursada(X,Y):-parcial_2(X,Y),(Y>=4).
parcial_1_promocion(X,Y):-parcial_1(X,Y),(Y>=7).
parcial_2_promocion(X,Y):-parcial_2(X,Y),(Y>=7).
promedio(X,P):-parcial_1(X,Y),parcial_2(X,Z),P is(Y+Z)/2.
promocionan(X,P):-parcial_1_promocion(X,Y),parcial_2_promocion(X,Z),promedio(X,P).
cursan(X,Y,Z):-parcial_1_cursada(X,Y),parcial_2_cursada(X,Z),not(promocionan(X,Y,Z)).
recursan(X):-notas(X,_,_),not(promocionan(X,_)),not(cursan(X,_,_)).

producto(X,Y):-promocionan(_,X),promocionan(_,Y).
seleccion(X,Y):-producto(X,Y),(X<Y).
proyeccion(X):-seleccion(X,_).
maximo(X,Y):-promocionan(X,Y),not(proyeccion(Y)).
