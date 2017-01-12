#Criar uma aplicação de seguros de automóveis.
	
##Entidades (carro e segurado)	

	cadastro de veiculos
		->id
		->marca
		->modelo
		->placa
		->anoFabricacao
		->combustivel
		->categoria
		->preco
		
	cadastro de segurados
		->id
		->nome
		->idade
		->sexo
		
um segurado pode possuir varios carros

Iremos construir uma aplicação web utilizando:
	- spring-mvc 
	- spring-jdbc (para acessar o banco de dados)
	- spring-orm  (para integrar com hibernate)
	- spring-data-jpa (para abstrair o acesso ao banco de dados)
	- spring-aop  (caso precise implementar orientado a aspecto)
	- MySql DB
	- hibernate
	- c3p0 (biblioteca para multiconexão) // para não precisar ficar "abrindo conexão toda hora"

- Para construir o Front-End iremos utilizar:
	- javascript
	- jquery
	- bootstrap