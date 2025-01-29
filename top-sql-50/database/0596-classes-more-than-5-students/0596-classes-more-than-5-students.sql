# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT class
FROM Courses
GROUP BY class
Having Count(student) >= 5;