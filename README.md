# Quiz-ver1-java
Projet Nº01 (12/20), application bureau en Java, en utilisant les fichiers (Input &amp; Output).
<h1>Rapport Projet de session en Java</h1>
<h2>Application pour tester les connaissances en Java</h2>
<h3>I-	Introduction</h3>
L’idée de ce projet était initialement de créer une application qui va me permettre d’enregistrer et manipuler des différentes questions qui peuvent être posées lors d’une entrevue pour un poste de programmeur Java. Les façons de poser une question se diffèrent, afin de piéger un candidat; sur ce principe là je me suis basé pour définir trois (3) différents types de questions :
1)	Question à choix multiple, je peux avoir entre deux (2) et cinq (5) choix y compris la ou les bonnes réponses.
2)	Question représentée par une image (partie de code Java) qui contient une erreur à trouver.
3)	Question représentée comme une partie de code en java où on doit trouver le résultat de son exécution.
Ensuite, j’ai développé mon application, en ajoutant une fonctionnalité de passer un quiz avec un nombre choisi de questions déjà enregistrées.
Enfin, après le cours concernant l’internationalisation (i18n) qu’on a eu dernièrement dans la matière IHM, j’ai essayé d’internationaliser mon application (10%, vu le temps demande pour la traduction)



<h3>II-	Description des classes</h3>

1-	Package control
Nom	Description
class AppCtr	La classe qui contient la méthode main, on instance une ListeQuestions et une ListeProfils, ensuite on les remplit le contenu des fichiers qui correspondent. On instance aussi le Locale en lui attribuant les paramètres régionaux par défaut du système. Enfin on lance la fenêtre FenPrincipale avec les 3 paramètres crées ci-dessus.




2-	Package modele
Nom	Description
class Question	Encapsule l’objet Question
class QCM	Encapsule l’objet QCM (question à choix multiple) qui hérite de l’objet Question et implémente l’interface ReponseQCM.
class ImageErreur	Encapsule l’objet ImageErreur (question de type image avec une erreur à trouver) qui hérite de l’objet Question et implémente l’interface ReponseImg.
class ResultatExecution	Encapsule l’objet ResultatExecution (question à trouver le résultat d’exécution d’un code Java) qui hérite de l’objet Question et implémente l’interface ReponseExecution.
class ListeQuestions	La classe contient l’attribut mapQuestion de type Map<Integer, Question>
interface ReponseQCM	Interface avec deux méthodes, creerReponses et faireChoix
interface ReponseImg	Interface avec deux méthodes, creerReponses et ajouterCorrigeErreur
interface ReponseExecution	Interface avec deux méthodes, creerReponses et ajouterReponseExe
class Scenario	Classe qui hérite de la classe ListeQuestions, avec un nombre définit de question.
class Profil	Encapsule l’objet Profil (utilisateur, laDate,lHeure,  ombreQuestion, note, duree)
class ListeProfils	La classe contient l’attribut listing de type ArrayList<Profil>


3-	Package io
Nom	Description
class ManipFichier	Classe abstraite, qui contient les différentes méthodes static pour lire et écrire dans les fichiers.









4-	Package utils
Nom	Description
class QuestionDejaPresenteException	Classe abstraite, qui hérite de la classe Exception, encapsule une exception de vérification des doublons.
class GestionScenario	Classe abstraite, qui contient deux méthodes static, lancerScenario pour instancier un Profil, un Scenario et les passer comme paramètres à une ListePanneaux. Deuxième méthode LancerPanneau, qui retourne un PanneauParcours de type JPanel
class  GestionImage	Classe abstraite, elle contient une méthode static, ajusterImage ajuster une image selon des dimension (2D) spécifiées.


5-	Package ui
Nom	Description
class FenPrincipale	Classe qui hérite de JFrame, c’est la fenêtre principale de l’application.
class FenAvantLancement	Classe qui hérite de JFrame, c’est une fenêtre qui lance un compte à rebours avant le début du quiz.
class FenDiagramme	Classe qui hérite de JFrame, c’est une fenêtre qui permet d’afficher les diagrammes UML de ce projet.
class PanneauDebutQuiz	Classe qui hérite de JPanel, c’est un panneau pour choisir les paramètres de quiz à lancer
class PanneauQuiz	Classe qui hérite de JPanel, c’est un panneau qui s’adapte selon le type de question pour l’afficher
class ListePanneaux	Classe qui contient l’attribut listing de type ArrayList<PanneauQuiz>
Class PanneauResultat	Classe qui hérite de JPanel, c’est un panneau qui affiche le résultat d’un quiz terminé
class PanneauAffichage	Classe qui hérite de JPanel, c’est un panneau qui affiche toutes les questions dans un JTable
class PanneauParcoursPrincipal	Classe qui hérite de JPanel, c’est un panneau qui permet de parcourir les différentes questions en utilisant (PanneauParcours)
class PanneauParcours	Classe qui hérite de JPanel, c’est un panneau qui s’adapte selon le type de question pour l’afficher (differemment que le PanneauQuiz)
6-	Package ui.ajout_modification
Nom	Description
class PanneauModification	Classe qui hérite de JPanel, c’est un panneau qui permet de manipuler les question, ajout, modification et suppression
class PanneauAjoutQCM	Classe qui hérite de JPanel, c’est un panneau qui permet de manipuler une question à choix multiple
class PanneauAjoutQuesImg	Classe qui hérite de JPanel, c’est un panneau qui permet de manipuler une question image avec une erreur
class PanneauAjoutQuesRes	Classe qui hérite de JPanel, c’est un panneau qui permet de manipuler une question de trouver le résultat d’exécution
<h3>III-	Captures d’écran</h3>
III-	Captures d’écran
  
![image](https://user-images.githubusercontent.com/72523491/131723492-21d9e89a-c9d9-40f6-bc8a-58308d6a2dfe.png)
  
  ![image](https://user-images.githubusercontent.com/72523491/131723505-79e7d48e-fda3-4d5d-894e-6ff566396678.png)

  ![image](https://user-images.githubusercontent.com/72523491/131723514-76d799c2-3ca0-43b9-a218-6f6992392416.png)

![image](https://user-images.githubusercontent.com/72523491/131723528-3dbf70d8-9ca9-4cc6-a86a-864a2b39fc56.png)
  
  ![image](https://user-images.githubusercontent.com/72523491/131723548-ebeac834-b140-4c56-a95a-eed0a7e82ff3.png)
  
  ![image](https://user-images.githubusercontent.com/72523491/131723555-7ce48e86-a25d-414c-840b-d626827c4d4c.png)
  
  ![image](https://user-images.githubusercontent.com/72523491/131723593-a575c523-4ca6-42ea-9a58-22e3cbdab82d.png)


  ![image](https://user-images.githubusercontent.com/72523491/131723570-17bc1957-4107-4581-bcdd-cb8d3bfd6318.png)

![image](https://user-images.githubusercontent.com/72523491/131723577-a12e9adc-f48e-469e-91e3-caff551ae610.png)
  
  <h1>IV-	Conclusion</h1>
À travers ce projet j’ai eu quelques difficultés qui sont liées principalement aux étapes qui précèdent la programmation. D’abord les besoins du client ont étés mal exprimés :/, à un moment donné je ne savais pas quelles sont les options ou les fonctionnalités de mon application, donc il me fallait de modifier la conception du projet à plusieurs reprises. 
Pour conclure, un projet quelconque ne peut avoir une version finale, mais plutôt une version stable. Je peux dire que mon modeste projet représente une version initiale qui peut être améliorée, avec quelques d’autres fonctionnalités que je voulais les inclure mais malheureusement je n’ai pas eu le temps nécessaire (ex. l’i18n non complétée qui nécessite une modification de conception). Mais quand même j’ai essayé d’appliquer les différents concepts qu’on a vu durant les deux sessions (héritage, implémentation, collection, gestion des exceptions, manipulation des fichiers … etc.).

  <h2>Annexe I : Diagramme de cas d’utilisation</h2>
  
![image](https://user-images.githubusercontent.com/72523491/131723671-8138b24c-1c79-4d24-a384-1bb019c7c2d5.png)

  <h2>Annexe II : Diagramme de classes de conception</h2>
  
![image](https://user-images.githubusercontent.com/72523491/131723701-ae0e4ba1-ccd2-4f0f-9992-04dfa895fa60.png)
