# campus-connect-api
Backend Repo for campus connect network

## Start DynamoDB Local Instance
### 1. Extract dynamodb_local_latest.rar (except the .db file) to the root directory of this project
### 2. Go to /campus-connect-api(or your project name)/dynamodb_local_latest
### 3. If Windows 10: Run the dbLocalInstance.bat file (double click) and both the localDB instance and GUI will start.
### The port for Local DB Instance is 8000 and for the GUI is 5000

## campus-social-media java project
### In applications.properties
#### Port, accesskeys, for dynamoDB etc are specified
#### Java project will start on port 8080

## Database Details
### The Database has a User Table
### Attributes are:
  #### userName (String) -> Partition key
### Other attributes are added in the Java Code
