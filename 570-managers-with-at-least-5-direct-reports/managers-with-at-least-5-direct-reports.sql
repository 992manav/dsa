SELECT name 
FROM Employee e1
WHERE (
    SELECT count(*) 
    FROM Employee e2
    WHERE e1.id=e2.managerId
) >=5