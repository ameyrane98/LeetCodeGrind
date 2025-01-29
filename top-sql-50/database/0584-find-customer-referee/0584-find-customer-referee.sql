# Write your MySQL query statement below
Select name from Customer as c WHERE CASE 
        WHEN referee_id != 2 THEN 1
        WHEN referee_id IS NULL THEN 1
        ELSE 0
      END = 1;