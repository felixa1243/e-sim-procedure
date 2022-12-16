SET ENVIRONMENT VARIABLES
USERNAME=database username </br>
PASSWORD= database password </br>
PORT= server port</br>
URL=url to database </br>
SECRET=enigma
Available endpoint </br>
/api/auth/register </br>
before that you should insert roles to the database using this command on sql: </br>
`INSERT INTO roles(roles_id,roles_name) values ('user_id','USER')`
`INSERT INTO roles(roles_id,roles_name) values ('admin_id','USER')`
</br> *NOTE: you can choose any id you want, i will use 'user_id' and 'admin_id' to make it simple; 
sample request: </br>
`
{
    "username":"username",
    "email":"email@domain.com",
    "password":"password",
    "passwordVerification":"password",
    "user":{
        "fullname":"anjay",
    }
}`
