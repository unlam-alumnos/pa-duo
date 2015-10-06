numero(1).
numero(2).
numero(3).
producto_cartesiano(X,Y):-numero(X),numero(Y).
seleccion_menores(X,Y):-producto_cartesiano(X,Y),(X<Y).
proyeccion(X):-seleccion_menores(X,_).
maximo(X):-numero(X),not(proyeccion(X)).
