[![GitHub license](https://img.shields.io/github/license/Nsmsb/Jload)](https://github.com/Nsmsb/Jload/blob/main/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/Nsmsb/Jload)](https://github.com/Nsmsb/Jload/issues)


<h1 align=center> Projet DevOps  : Une bibliothèque d’analyse de données en Java (Jload).</h1>


## Préambule
Les Dataframes sont des tableaux en deux dimensions où chaque colonne est identifiée par un label et chaque ligne par un index. Chaque colonne stocke des données d’un seul type. Cependant deux colonnes différentes peuvent stocker des types différents (String ou Int).  
Pandas est une des bibliotèques les plus populaires (pour langage Python). Elle permet de traiter de grandes quantités de données simplement et efficacement (plus d'informations sur https://pandas.pydata.org).   
L’objectif de ce projet est d'implémenter une sous-partie des fonctionnalitées offertes par Pandas en Java.


## Description des fonctionnalitées
### 1- Création d'un Dataframe
Cette bibliotèque permet d'instancier un Dataframe de 2 manières différentes :

- Création d'un Dataframe à partir d'une matrice (String[][]):<br />
La première ligne de cette matrice représente les noms de chaque colonne.<br />
Les autres lignes de la matrice représentent les donneés de la ligne (index-1), ou index est la ligne courante!

- Création d'un dataframe à partir d'un fichier csv:<br />
Le fichier csv doit contenir en première ligne les noms de chaque colonne.<br />
un fichier csv est disponible dans le répertoire `src/test/ressources/exemple.csv`.   

**Attention** : Toutes les colonnes doivent etre de la meme tailles, c'est a dire contenir le meme nombre d'elements.


### 2- Affichage d'un Dataframe
Il existe 4 manières différentes pour afficher le contenu d'un Dataframe :

- Afficher le contenu intégral     : `showAll()`
- Afficher le contenu d'un interval [ i1 , i2 ] : `showBetween(int i1, int i2)`
- Afficher les 5 premières lignes  : `showFiveFirst()`
- Afficher les 5 dernières lignes  : `showFiveLast()`


### 3- Sélections dans un Dataframe
Il existe 2 manières différentes pour réaliser une selection dans un Dataframe.
Le résultat de la sélection est un nouveau Dataframe : 

- Selection d'une ligne  : `getRow(int index)`
- Selection d'une colonne a partir d'un index: `getColumn(int index)`
- Selection d'une colonne a partir d'un label: `getColumn(String label)`



## Execution
Pour lancer les tests unitaire, executer la commande suivante à la racine du projet :
```
  mvn test
```


## FeedBack

Ce project a été une occasion de mettre en oeuvre toutes les connaissances acquises durant ce semestre, et de se familiariser encore plus avec les outils étudiés dans un contexte plus technique que les TPs.
La mise en place des tests et de la pipeline d'intégration, dans les premières phases du projets, permet d'avancer très rapidement, et d'avoir une version stable et fonctionnelle après chaque fonctionnalité implémentée.   


## Contribution & issues 
### Issue
S'il vous plaît si vous avez un problème, ouvrez un problème et fournissez des captures d'écran et / ou du code.

### Contribution
Lorsque vous contribuez à ce référentiel, veuillez d'abord discuter de la modification que vous souhaitez apporter via un problème, un e-mail ou toute autre méthode avec les propriétaires de ce référentiel avant d'effectuer une modification.

Veuillez noter que nous suivons le processus de développement de gitflow, veuillez le suivre dans toutes vos interactions avec le projet.

