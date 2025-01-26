# Write your MySQL query statement below
Select query_name,Round(Avg(rating/position),2) as quality,
Round((SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 100.0) / COUNT(*),2) as  poor_query_percentage 


From Queries Group by query_name