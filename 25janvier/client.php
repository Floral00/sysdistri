<?php

if($_GET) {
	if(isset($_GET['mt'])) {
		
		$atservices_wsdl = "http://localhost:8989/?wsdl";
		$atservices_client = new SoapClient($atservices_wsdl);
		$resultat = $atservices_client->AfficherLesProduits();

	 // review the returned object converted from SOAP response.
	/*
		$montant = $_GET['mt'];
		$clientSoap = new SoapClient("http://localhost:8989/?wsdl");
		$param= new stdClass();
		$param->mt=$montant;
		$resultat = $clientSoap->__soapCall("somme", array($param));
		*/
	}
	if(isset($_GET['mt2'])) {
			
		$atservices_wsdl = "http://localhost:8989/?wsdl";
		$atservices_client = new SoapClient($atservices_wsdl);
		$resultat = $atservices_client->__soapCall('mamethode', array('montant'=>$_GET['mt2']));
	}
	if(isset($_GET['mt3'])) {
			
		$atservices_wsdl = "http://localhost:8989/?wsdl";
		$atservices_client = new SoapClient($atservices_wsdl);
		$resultat = $atservices_client->somme(intval($_GET['mt3']),intval($_GET['mt31']));
	}
	if(isset($_GET['mt4'])) {
		var_dump(intval($_GET['mt4']));
		$atservices_wsdl = "http://localhost:8989/?wsdl";
		$atservices_client = new SoapClient($atservices_wsdl);
		$resultat = $atservices_client->afficherProduit(intval($_GET['mt4']));
	}
	if(isset($_GET['mt5'])) {
			
		$atservices_wsdl = "http://localhost:8989/?wsdl";
		$atservices_client = new SoapClient($atservices_wsdl);
		$resultat = $atservices_client->prixSupProduit(intval($_GET['mt5']));
	}
	if(isset($_GET['mt6'])){
			
		$atservices_wsdl = "http://localhost:8989/?wsdl";
		$atservices_client = new SoapClient($atservices_wsdl);
		$resultat = $atservices_client->addProduct(intval($_GET['mt6']), $_GET['mt61'], intval($_GET['mt62']));
	}
	if(isset($_GET['mt7'])){
			
		$atservices_wsdl = "http://localhost:8989/?wsdl";
		$atservices_client = new SoapClient($atservices_wsdl);
		$resultat = $atservices_client->delProduct(intval($_GET['mt7']));
	}
}
?>

<html>
<title> php Client </title>

<body>
<form action="client.php" method="get">
<input type="text" name="mt">
<button>Afficher les Produits</button>
</form>
<form action="client.php" method="get">
<input type="text" name="mt2" placeholder="nombre">
<button>produit</button>
</form>
<form action="client.php" method="get">
<input type="text" name="mt3" placeholder="nombre">
<input type="text" name="mt31" placeholder="nombre">
<button>somme</button>
</form>
<form action="client.php" method="get">
<input type="text" name="mt4" placeholder="id">
<button>Afficher un produit</button>
</form>
<form action="client.php" method="get">
<input type="text" name="mt5" placeholder="prix">
<button>Afficher les Produits ayant un prix supérieur</button>
</form>
<form action="client.php" method="get">
<input type="text" name="mt6" placeholder="id">
<input type="text" name="mt61" placeholder="nom objet">
<input type="text" name="mt62" placeholder="prix">
<button>Ajouter un Produit</button>
</form>
<form action="client.php" method="get">
<input type="text" name="mt7" placeholder="numéro produit">
<button>Supprimer un produit</button>
</form>
<?php

echo "Le résultat renvoyé par le service est ".json_encode($resultat->return, JSON_PRETTY_PRINT);
?>

</body>

</html>