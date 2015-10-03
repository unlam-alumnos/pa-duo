es_un_pais(argentina).
es_un_pais(chile).
es_un_pais(brasil).
es_un_pais(peru).
es_un_pais(bolivia).
es_un_pais(uruguay).
limita_con(argentina,chile).
limita_con(uruguay,argentina).
limita_con(argentina,brasil).
limita_con(argentina,bolivia).
son_limitrofes(X,Y):-limita_con(X,Y);limita_con(Y,X).
# dif(A,B)
# not()
# write(X+Y)
# limita_con(X,Y),write(X+Y),nl,fail.
# LIMITROFES Y TRANSLIMITROFES
limita_con(a,b).
limita_con(a,c).
limita_con(b,c).
limita_con(b,d).
limita_con(c,d).
son_limitrofes(X,Y):-limita_con(X,Y);limita_con(Y,X).
son_translimitrofes(X,Y):-son_limitrofes(X,Z),son_limitrofes(Z,Y),not(son_limitrofes(X,Y)),not(X==Y).
# console --> son_translimitrofes(X,Y),write(X+Y),nl,fail.
