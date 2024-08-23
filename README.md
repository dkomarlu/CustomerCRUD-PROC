# CustomerCRUD-POC
This POC used H2 in memory DB.  When it is built, it pulls H2 dependency

It creates Customer records in H2 DB with 
    Long id - auto generated
    String first_name   - Not null or empty
    String last_name    - Not null or empty
    email_address       - Not Null or empty - Unique

The application uses @ContollerAdvice to handle exceptions.
The package exception has following classes to handle exceptions

    ErrorResponse:  int statusCode,  String message
    GlobalExcetionHandler class with @ControllerAdvice and handles follwing Exceptions
        CustomerNotFoud
        DuplicateCustomer
        MethodArgumentNotValidException to handle input errors

To Test use the following curl commands:

    Get All Customers
        curl --location 'localhost:8080/api/customer'

    Find Customer by Id
        curl --location 'localhost:8080/api/customer/1'

    Find Customer By emailId
        curl --location 'localhost:8080/api/customer/find?emailId=js2%40gmail.com'

    Add a Customer
        curl --location 'localhost:8080/api/customer' \
            --header 'Content-Type: application/json' \
            --data-raw '{
            "firstName" : "John-2",
            "lastName" : "Smith-2",
            "emailId" : "js1@gmail.com"

    Delete A Customer:
        curl --location --request DELETE 'localhost:8080/api/customer/1'
}'
    
