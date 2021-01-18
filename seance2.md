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



