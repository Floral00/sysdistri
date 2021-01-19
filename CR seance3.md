# Systèmes Distribués 
## Généralités du developpement
### Architectures Web Avancés
### Généralités sur les languages
  * **Langage Compilé** : est un langage dont le code est transformé par une compilateur avant d'être deploybale ou utilisable 
  * **Langage Interprété** : est un langage dont le code est directemenet expolitable après develolppement et donc utilisable et deplyable via un serveur (PHP)
  * **Langage intermédiaire** : est un langage dont le code est compilé et a besoin d'être interprété par un outils tierce par exemple java est compilé et ensuite interprété par la JVM
## Application de base JEE
### Généralités de base
Dans le cadre de l'initialisation de base d'une appli JEE on va avoir une arborésence avec plusieurs répertoires et fichiers les plus importants sont dans le dossier ***src***, pour avoir une architecture fonctionnel on fait :
 * ***web.xml*** permet de définir le mapping des composants web disponibles sur votre applicaiton et de, par exemple, assigner une ***URL*** à une ***servlet*** qui est un controleur de l'application, le code ci dessous présente un fichier décrivant une servelt nommée ***test*** qui à pour chemin dans les packages java ***test.test*** et qui est accessible à l'URL ***/introduction*** :
   ```xml
    <servlet>
        <servlet-name>test</servlet-name>
        <servlet-class>test.test</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>test</servlet-name>
        <url-pattern>/introduction</url-pattern>
    </servlet-mapping>
  
    <servlet>
        <servlet-name>page1</servlet-name>
        <servlet-class>test.page1</servlet-class>
     </servlet>
    
    <servlet-mapping>
        <servlet-name>page1</servlet-name>
        <url-pattern>/page1</url-pattern>
    </servlet-mapping>
    ```

 * ***HelloServlet.java*** qui décrit le fonctionnement d'un ***controlleur***, c'est a dire que la servlet à pour but de gérer les interaction du client par exemple dans le code ci-après on peut voir la récation la servlet après l'appel de la méthode get :
```java
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        }
```
Ici, en appelant get on peut voir que mon application renvoie vers un fichier ***.jsp*** qui n'est qu'autre qu'un fichier ***html*** dans lequel on peut ajouter des balises customisables.
Tout ceci est important pour la suite car ici on va utiliser une architecture spécifique ***MVC***
### Le modèle MVC

Dans le modèle vue controlleur, il y a 3 caractéristiques : 
* **la vue de l'utilisateur** : elle correspond à ce que voit l'utilisateur.
* **le controlleur** : le controlleur permet de rediriger les demandes d'accès aux ressources des utilisateurs en leur redirigeant les vues correspondantes.
* **le modèle** : le modèle correspond à la façon dont on va accéder à la vue (différents trypes de méthodes).

# Compte rendu séance 3:

## Presentation service Web

Un service web est composé d'un fornt end et d'un back-end afin de communiquer entre les deux ont utilise généralement le protocole HTTP.
La communication est généralement appelée API. *Application Programming Interface*

**Front-end :** 
Il s'agit de l'interface client, auquel les utilisateurs ont accès

**Back-end :**
Il s'agit des protocoles et des méthodes disponible uniquement sur le serveur d'application

Les services webs sont interopérables. En effet le langage de back-end n'a pas d'incidence sur le choix du langage dans le front-end. Le front-end aura juste comme contraintes d'interpréter correctement les données reçues via l'API. 
Le back-end va mettre à disponibilité différentes méthodes pour le front-end permettant ainsi aux utilisateurs (utilisant le front-end) d'accéder à différentes ressources

JAX-WS : Java Architecture XML -WebService
JAX-B : Java Architecture XML - Binding 


### SOAP
appli web en 2 parties : le backend (serveur) par exemple en java et frontend (client) par exemple en PHP
La comm' se fait par le protocole HTTP.

interopérabilité des données : 

Simple Object Access Protocol = SOAP 

Sérialisation : passage d'un objet en XML (back to front)

Désérialisation : passage d'un XML en objet (front to back)

On génère un Skeleton au niveau du serveur et un Proxy (ou stub) au niveau du client qui seront chargés de réaliser les actions de sérialisation et désérialisation.

Le bean est une classe qui implémente l'interface Serializable dont les attributs sont de type private, qui dispose d'un constructeur sans paramètres, et éventuellement avec ainsi que des getters et setters.

Il existe deux types d'exception : 

* **execption surveillée** 
* **exception ?**

### Maven

intêret : gérer les dépendances 

cycle de vie projet maven :

**default**
* validate
* compile
* test
* packag
* install
* deploy

**clean**

**site**