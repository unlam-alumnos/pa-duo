numero(1).
numero(2).
numero(3).
numero(4).
numero(5).
numero(6).
numero(7).
numero(8).
numero(9).
producto(X,Y,Z):-numero(X),numero(Y),numero(Z).
produ(X,Y,Z):-numero(X),numero(Y),!,numero(Z).
suma(X,Y,Z,S):-numero(X),numero(Y),numero(Z),S is X+Y+Z.
suma_mas(X,Y,Z,S):-suma(X,Y,Z,S),S>15.
pri_suma_mas(X,Y,Z,S):-suma_mas(X,Y,Z,S),!.
fibonacci(0,0).
fibonacci(1,1).
fibonacci(N,F):-N>1,N1 is N-1,fibonacci(N1,F1),N2 is N-2,fibonacci(N2,F2),F is F1+F2.
pss(A,1,A).
pss(A,B,P):-B>1, X is B-1, pss(A,X,P1), P is (A + P1).
