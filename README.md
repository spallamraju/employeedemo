# Employee Demo
Employee table has following Attributes:
1. Employee Number
2. First Name
3. Last Name
4. Hire Date

Salary table has following Attributes:
1. Employee Number
2. Hire Date
3. Salary

Salary Table has Composite Key (Employee Number and Hire Date), Employee Table has Primary Key (Employee Number).

This Project will do following Operations:
1. Fetch All Employees (http://localhost:8080/demo/v1/employee)
2. Fetch an Employee by Employee Number (http://localhost:8080/demo/v1/employee/{emp_no})
3. Fetch All Employees with Salary (http://localhost:8080/demo/v1/employee/salary/{emp_no})
