### invoice
Invoice data for O'Reilly Auto Parts  

| **customer_id** | **invoice_id** |                                       **invoice_data**                                       |
|-----------------|:--------------:|:--------------------------------------------------------------------------------------------:|
| 1               | 54             |  {"time": 19.53, "tenderDetails": {"amount": 23.43, "type": "cash"}, "storeNumber": "999"}   |
| 2               | 55             |   {"time": 12.00, "tenderDetails": {"amount": 4.95, "type": "cash"}, "storeNumber": "999"}   |
| 2               | 56             | {"time": 08.49, "tenderDetails": {"amount": 100.12, "type": "credit"}, "storeNumber": "999"} |

Executable jar can be run with JDK 17
```
    java -jar invoice-0.0.1-SNAPSHOT.jar  
```

When application is running, REST API calls can be made in Postman.  
In Postman, import Invoice.postman_collection.json
Then select a request and run.




