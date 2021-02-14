Il faut crééer les satellites avant de lancer les balises pour ne pas qu'elles arrivent dans l'état synchronisation
avant qu'il y ait un satellite de créér, car sinon cela ne fonctionnera pas.

Au niveau du input, si l'on met toutes les lignes d'un seul coup, la dernière ne sera pas effectuée
Si l'on met les lignes une part une, il faudra parfois appuyer plusieurs fois sur entré, voir même re cliquer
au niveau de la ligne pour refaire un entrer qui permettra de lancer la commande


Un exemple des commandes possibles

bal1 = new Beacon (PointX = 100, PointY = 200, Deplacement = #horizontal, Memory = 1000); 
bal2 = new Beacon (PointX = 200, PointY = 200, Deplacement = #vertical, Memory = 1000);
bal3 = new Beacon (PointX = 300, PointY = 200, Deplacement = #sinusoidale, Memory = 1000); 
sat1 = new Satellite (PointX = 100, PointY = 50, Deplacement = #satelliteMouvement, Memory = 10000); 
sat2 = new Satellite (PointX = 80, PointY = 40, Deplacement = #satelliteMouvement, Memory = 10000); 

bal1.start(Speed = 2); 
bal2.start(Speed = 4); 
bal1.stop();
bal3.start(Speed = 1);
sat2.start(Speed = 3);
sat1.start(Speed = 1);
bal1.start(Speed = 2);