# SQL - Security

## Login

`CREATE LOGIN Harry WITH PASSWORD abcde12345`
`CREATE LOGIN Henk WITH PASSWORD edcba54321`
`CREATE LOGIN Meme WITH PASSWORD 15243aebdc`

## Roles
`CREATE ROLE Administratie AUTHORIZATION admin`
`CREATE ROLE Marketing AUTHORIZATION admin`
`CREATE ROLE Sales AUTHORIZATION admin`

### Administratie Privileges
`GRANT SELECT ON Cursus TO Administratie`
`GRANT UPDATE ON Cursus TO Administratie`
`GRANT DELETE ON Cursus TO Administratie`

`GRANT SELECT ON Training TO Administratie`
`GRANT UPDATE ON Training TO Administratie`
`GRANT DELETE ON Training TO Administratie`

`GRANT SELECT ON Medewerker TO Administratie`
`GRANT UPDATE ON Medewerker TO Administratie`
`GRANT DELETE ON Medewerker TO Administratie`
`DENY UPDATE ON Medewerker (email) TO Administratie`

`GRANT SELECT ON Functie TO Administratie`
`GRANT UPDATE ON Functie TO Administratie`
`GRANT DELETE ON Functie TO Administratie`

`GRANT SELECT ON Gesprek TO Administratie`
`GRANT UPDATE ON Gesprek TO Administratie`
`GRANT DELETE ON Gesprek TO Administratie`

### Sales Privileges
`GRANT SELECT ON Order TO Sales`
`GRANT UPDATE ON Order TO Sales`
`GRANT DELETE ON Order TO Sales`

`GRANT SELECT ON Aankoop TO Sales`
`GRANT UPDATE ON Aankoop TO Sales`
`GRANT DELETE ON Aankoop TO Sales`

`GRANT SELECT ON Abon TO Sales`
`GRANT UPDATE ON Abon TO Sales`
`GRANT DELETE ON Abon TO Sales`

`GRANT SELECT ON Klant TO Sales`
`GRANT UPDATE ON Klant TO Sales`
`GRANT DELETE ON Klant TO Sales`

### Marketing Privileges
`GRANT SELECT ON Webhistorie TO Marketing`

`GRANT SELECT ON Klant TO Marketing`

### Grant Roles to Members
`ALTER ROLE Administratie ADD MEMBER Harry`
`ALTER ROLE Marketing ADD MEMBER Henk`
`ALTER ROLE Sales ADD MEMBER Meme`

