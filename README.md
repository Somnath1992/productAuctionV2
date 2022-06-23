# Auction
Product Auction

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

.\bin\windows\kafka-server-start.bat .\config\server.properties

http://localhost:5000/api/v1/openBankAccount

  {"productName":"PRD008","shortDescription":"PRD 001","description":"PRODUCT 001","category":"PAINTING","startingPrice":300,"bidEndDate":"2022-11-11"}
  
 GET - http://localhost:3001/api/v1/productLookup/byId/1
 
 POST - http://localhost:3000/api/v1/openBankAccount
 
 {  "productId":333,
    "productName": "abc",
    "shortDescription": "def",
    "description": "ghi",
    "category": "ORNAMENT",
    "startingPrice": 333.00,
    "bidEndDate": "2022-11-25T14:05:15.953Z"
}

