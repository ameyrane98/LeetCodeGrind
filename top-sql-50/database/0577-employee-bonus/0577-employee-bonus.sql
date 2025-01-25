# Write your MySQL query statement below
Select emp.name,b.bonus as bonus from Employee as emp left join Bonus as b On emp.empId=b.empId where b.bonus<1000 or b.bonus is null;