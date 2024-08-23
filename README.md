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


