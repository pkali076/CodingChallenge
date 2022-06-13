## Notes For The Code That I Wrote

These are notes for those looking over the code. I wanted to say that this is the first time I have coded with SpringBoot.

As a note: I have left all of the controllers for the Reporting Structure and Compensation in the original, Employee Controller.

I know this is not a standard -- however, given the way that I have chosen to code this; this seemed like a simpler way to route the data.
Although I am familiar with MongoDB, I found that the imports through Springboot were unfamiliar at first -- although not at all difficult to understand.


# For Task 1:
in /service/ReportingStructureService.java

I saw how to code ReportingStructure through the EmployeeService starting codes. Instead of just reading the data from the String id,
I decided to create a new function calling ReportingStructure to get the reporting structure. I understand that it is also possible
to just type out a one-liner as follows: ReportingStructgure read(String id);

in /service/impl/ReportingStructureImpl.java

Perhaps creating a list will increase the efficiency of implementing new identifications by created a List of direct reports as so:
List<Employees> directReports = numEmployee.getDirectReports();

After this, the size can be implemented and appended in the order they are created. Since there is no specification on the numbers for ordering;
such as numerical (only one I can truly think of otherwise), the order is dependent on date added as well as the number of reports that are within
the database.

Since there were similar appearing creation and read structures for task 1 as to EmployeeService, etc... I decided to just rename accordingly.
Normally, I would ask a bit more specifically about what the clarification is for the implementation -- although this seemed fine for the time being.

Additionally, in /data/ReportingStructure.java, the methods are created to get and set the data.


# For Task 2:

A new type called Compensation is created and the following expected fields of employee, salary and effectiveDate.

/data/Compensation.java includes the setting and getting of compensation methods as well as setting the effectiveData for the employees.
The variables are, of course, private so as they do not conflict with other variables of the same name in the public setting.
However, they can be easily accessed through the methods.

/service/impl/CompensationServiceImpl.java includes the functions for creation and locating the compensation for employees. There is no
update function, as this was not requested, although the implementation would not be much different from the EmployeeServiceImpl file.

The implementation accesses the repository and returns the new instertion (or addition) of the compensation.

/dao/CompensationRepository.java is the new interface for the repository which extends the MongoRepository with a new String for compensation.
Here, the person can find the compensation by employee through the employeeId String.


-------------------------------------------------------------------

Just to conclude, there was a bit of trouble on my end for starting this on localhost:8080/employee
There seemed to be a 405 error which I could not resolve. In other words, the path was recognized although the GET method
was not routing the request. I am not sure why this was rejected.. it is most likely a simple mistake or error in my own code,
although I did my best to run tests and be certain things were coded to the standard as expected. That being said, some of what I have written
may be wrong although to the best of my knowledge, the additional code I implemented *should* work.

Please let me know if there is a mistake I have made -- as I have coded in Java before with multiple modules (as well as nodeJS and JavaScript & C#),
although like I forementioned, this is the first time I have used Spring Boot