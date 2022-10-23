{
	"info": {
		"_postman_id": "fa3d8990-d2b6-4264-8ebb-2eeb4b194864",
		"name": "API PW - Terça",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "2661061"
	},
	"item": [
		{
			"name": "client",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "asd.sdadssadasdas ",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost/api/index.php/client/23",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"path": [
						"api",
						"index.php",
						"client",
						"23"
					]
				}
			},
			"response": []
		},
		{
			"name": "client",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost/api/index.php/client/19",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"path": [
						"api",
						"index.php",
						"client",
						"19"
					]
				}
			},
			"response": []
		},
		{
			"name": "client",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"name\": \"Vinícius Silveira Magnussssss\",\n    \"phone\": \"51981499240\",\n    \"email\": \"vinimagnus@gmail.com\",\n    \"address\": \"Rua Itália, 49\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost/api/index.php/client",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"path": [
						"api",
						"index.php",
						"client"
					]
				}
			},
			"response": []
		},
		{
			"name": "client",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"name\": \"Vinícius Silveira Magnus23\",\n    \"phone\": \"5198149924023\",\n    \"email\": \"vinimagnus@gmail.com23\",\n    \"address\": \"Rua Itália, 4923\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost/api/index.php/client/23",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"path": [
						"api",
						"index.php",
						"client",
						"23"
					]
				}
			},
			"response": []
		}
	]
}