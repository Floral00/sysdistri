pour créer un projet : new : dynamic web project

sdkman : ds curl puis : curl -s "https://get.sdkman.io" | bash

important !!! en jave, la grande facilité est faite par les annotations  (@annotation) 

pour dynamic web modul version : 2.4 need un fichier config nous on utilsera que 3.0 ou +


on crée un servlet, penser que le java package = ID$

on obtient 2 méthode : doGet et doPost :
   doGet = affichage
   doPost = envoie de formulaire
   
on va dans le web.xml pour definir le nom (<servlet-name>Test</servlet-name>) et l'emplacement du servlet (<servlet-class>fr.polytech.nancy.Test</servlet-class>)puis on lui attribue une url:
<servlet-mapping>
<servlet-name>Test</servlet-name> 
<url-pattern>introduction</url-pattern>
</servlet-mapping>
  
  
dans un doGet : 

response.setContentType("text/html"); => def le type de réponse
        
response.setCharacterEncoding("UTF-8"); => def l'encodage
        
PrintWriter out = response.getWriter(); => def la sortie
       
out.println("<!DOCTYPE html>"); => def ce qu'on ecrit




MVC = bonne pratique dans tous les langages mais JEE pas forcément

Model V____ Controler (servlet ici)