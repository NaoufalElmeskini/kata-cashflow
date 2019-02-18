# kata-cashflow

- Le projet Cashflow fournit les opérations suivantes  : dépôt, retrait et transfert d'argent entre comptes.

Afin de faciliter le test des services proposés, 5 comptes bancaires (classe/table Account) sont initialement insérés dans la BDD, avec des IDs allant de 1 à 5.
Voici les principaux URLs liés au différents services (port par défaut : 8000) :

(GET) http://localhost:8000/cashflow/{accountid} : 
      Affiche l'objet Account
(POST) http://localhost:8000/cashflow/{accountid}/deposit/{amount} : 
      Déposer un {amount} d'argent.
(POST) http://localhost:8000/cashflow/{accountid}/withdraw/{amount} : 
      Retirer un {amount} d'argent
(POST) http://localhost:8000/cashflow/transfer/from/{payerid}/to/{payeeid}/amount/{amount} : 
      Transférer un {amount} d'argent du compte avec l'id {payerid} vers le compte du {payeeid}.
