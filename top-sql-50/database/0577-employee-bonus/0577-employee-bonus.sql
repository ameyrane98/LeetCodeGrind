# Write your MySQL query statement below
Select emp.name, bo.bonus
From  Employee as emp
Left Join Bonus as bo
ON bo.empID = emp.empID
Where bo.bonus<1000 or bonus is NUll;