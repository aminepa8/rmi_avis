# rmi_avis


One Paragraph of project description goes here


### Prerequisites

 * Add the file mysql-connector.jar to the following directory
 C:\Program Files\Java\jre1.8.0_202\lib\ext
 This  'jre1.8.0_202' is the installed jre version , you will probably found another version , somethin begin with jre
* Create new database in your phpMyAdmin and name it 'detailsavis' after that import the detailsavis.sql file in the import section

### Compiling 
First Ghater all the *.java files in the same folder
Then open CMD and past the followig command

```
javac *.java
```
### Executing 
First start the Server
```
java Server
```
For the Responsable  
```
java ResponsableClient
```
Expected results example
```
*********************MENU**************************
[1] - Afficher la lite des Avis
[2] - Ajouter une Avis
[3] - Modifier Une Avie
[4] - Supprimer Une Avie
[0] - Quit
**************************************************
```
For the Etudiant  
```
java EtudiantClient
```
Expected results example
```
=======================(Avis)========================
ID: 1
Avis : Les étudiants ne disposant pas de carte d?étudiant seront interdits de passer les examens.
ID: 2
Avis : L?étudiant doit se présenter à la date et à la salle indiquée sur la liste
=======================(Fin-Avis)========================
```
