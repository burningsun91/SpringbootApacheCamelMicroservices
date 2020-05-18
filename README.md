# SpringbootApacheCamelMicroservices
Springboot Microservices with Apache Camel and H2 Database

Simple Microservices using Springboot and Apache Camel.
To Run Locally Start the components as below:
1. Start customer-service --> Verify using url http://localhost:8085/customers
2. Start real-base-info-service --> Verify using url http://localhost:8086/realbaseinfos
3. Start legal-base-info-services --> Verify using url http://localhost:8087/legalbaseinfos
4. Start rest-integration

Test the services with below request (in browser / postman)

http://localhost:8089/customerBaseInfos?type=LEGAL&cid=1&lbiid=1

You will get response as below:

{
    "legalBaseInfo": {
        "id": 1
    },
    "id": 1,
    "baseInfoId": 1,
    "cifNumber": 1453223564,
    "customerType": "LEGAL"
}
