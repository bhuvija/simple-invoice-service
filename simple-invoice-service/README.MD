Simple Invoice Service Web Application
======================================
Description
===========
Exposed API can be explored via `http://localhost:8080/invoice-service/api/v1/application.wadl`.
Here is the list of services 

invoice/taxitems Request example:
```
{
    "id" : 1,
    "timeStamp" : "2016-09-18T20:01:03.182+0000",
    "items" : [{
        "id" : 11,
        "description" : "Item 11",
        "preTaxAmount" : 100.00,
        "taxCategory" : "c21.1"
    },
    {
        "id" : 12,
        "description" : "Item 12",
        "preTaxAmount" : 10.00,
        "taxCategory" : "c101"
    }]
}
```
Response 
```
{
  "invoice": {
    "id": 1,
    "timeStamp": "2016-09-18T20:01:03.182+0000",
    "items": [
      {
        "id": 11,
        "description": "Item 11",
        "preTaxAmount": 100,
        "totalAmount": 121.1,
        "taxCategory": "c21.1"
      },
      {
        "id": 12,
        "description": "Item 12",
        "preTaxAmount": 10,
        "totalAmount": null,
        "taxCategory": "c101"
      }
    ]
  },
  "errors": [
    "item.id = 12: unknown tax value for taxCategory='c101'"
  ],
  "error": true
}