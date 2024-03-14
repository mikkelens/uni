import mysql.connector
from mysql.connector import Error, errorcode

user = "root"
password = input("Password: ")
db = "handin5db"
host = "localhost"

try:
    cnx = mysql.connector.connect(user=user, password=password, host=host, database=db)
    cursor = cnx.cursor()
    # Find the email of all the supporters who only support one NGO. 'Support' here is only in scope of the "Supports" table.
    query = "SELECT email FROM supporter WHERE (SELECT Count(*) FROM supports WHERE supporter.email = supports.email) = 1;"
    cursor.execute(query)
    for email in cursor:
        print(email)
    cursor.close()
    cnx.close()

except Error as e:
    match e.errno:
        case errorcode.ER_ACCESS_DENIED_ERROR:
            print(f"Incorrect username ({user}) or password ({password}).")
        case errorcode.ER_BAD_DB_ERROR:
            print(f"Could not find database '{db}'.")
        case _:
            print(f"Error while connecting to MySQL:\n{e}")