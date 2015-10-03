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
/*Cuáles son las comidas que ofrece el restaurante?*/
comida(W,X,Y,Z):-bebida(W),entrada(X),(carne(Y);pescado(Y)),postre(Z).
/*Cuáles son las comidas que tienen Consomé en las entradas?*/
comida_consome(W,X,Y,Z):-comida(W,X,Y,Z),(X==consome).
/*Cuáles son las comidas que no contienen flan como postre?*/
comida_sin_flan(W,X,Y,Z):-comida(W,X,Y,Z),not(Z==flan).