# Employee App

The following endpoints can be run:

GET http://localhost:8080/api/employee

GET http://localhost:8080/api/employee?sortBySalary=true

GET http://localhost:8080/api/employee?sortBySalary=false

GET http://localhost:8080/api/employee/highest_salary

DELETE http://localhost:8080/api/employee/1

PUT http://localhost:8080/api/employee/1?name="Saule"&position="QA"&salary=10000.3

PUT http://localhost:8080/api/employee/1?name="Saule"&position="QA"&salary=-10000.3
