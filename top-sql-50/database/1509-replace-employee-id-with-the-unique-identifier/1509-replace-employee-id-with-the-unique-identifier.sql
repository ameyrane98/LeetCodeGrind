# Write your MySQL query statement below
SELECT 
    
    CASE 
        WHEN euni.unique_id IS NULL THEN NULL
        ELSE euni.unique_id
    END AS unique_id,emp.name
FROM 
    Employees AS emp
LEFT JOIN 
    EmployeeUNI AS euni 
ON 
    emp.id = euni.id;