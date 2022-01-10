DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
                      Employee_id  UUID PRIMARY KEY,
                      Name VARCHAR(20) NOT NULL,
                      Email varchar (40) NOT NULL ,
                      Address_Line varchar (30) NOT NULL ,
                      City varchar (20) NOT NULL ,
                      State varchar (20) NOT NULL ,
                      Create_Date TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
);