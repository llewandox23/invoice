## invoice
Given the Invoice data for O'Reilly Auto Parts  

| **customer_id** | **invoice_id** |                                       **invoice_data**                                       |
|-----------------|:--------------:|:--------------------------------------------------------------------------------------------:|
| 1               | 54             |  {"time": 19.53, "tenderDetails": {"amount": 23.43, "type": "cash"}, "storeNumber": "999"}   |
| 2               | 55             |   {"time": 12.00, "tenderDetails": {"amount": 4.95, "type": "cash"}, "storeNumber": "999"}   |
| 2               | 56             | {"time": 08.49, "tenderDetails": {"amount": 100.12, "type": "credit"}, "storeNumber": "999"} |

Required:  
Provide a REST application interface to return a Map<Long, String> with key Long InvoiceID and value String TenderType requested with a CustomerID.

This invoice application provides the entry point to the REST service:  
GET   http://localhost:8080/api/invoice/tenderType/customer/2  
as an example running local and result requested for the customerID = 2  
The response in JSON format for this example(customerID=2) is {"56":"credit","57":"credit"}  



An executable jar is provided and can be run with JDK 17
```
    java -jar invoice-0.0.1-SNAPSHOT.jar  
```

When application is running, REST API calls can be made in Postman (GET calls can be entered in a web browser).  
A Postman collection is provided with requests to run tests for expected responses.  
In Postman, import Invoice.postman_collection.json
Then select a request and run.

There is also an API to return a Map<Long, Invoice> with key Long InvoiceId and value full Invoice object requested with a CustomerID.  
GET http://localhost:8080/api/invoice/invoice/customer/2  
The response in JSON format for this example(customerId=2) is  
{  
"55": "{\"time\": 12:00, \"tenderDetails\": {\"amount\": 4.95, \"type\": \"cash\"}, \"storeNumber\": \"999\"}",  
"56": "{\"time\": 08:49, \"tenderDetails\": {\"amount\": 100.02, \"type\": \"credit\"}, \"storeNumber\": \"999\"}"  
}  





