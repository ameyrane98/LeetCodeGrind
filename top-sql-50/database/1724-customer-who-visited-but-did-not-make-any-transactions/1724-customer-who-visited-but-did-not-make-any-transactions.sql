# Write your MySQL query statement below
Select v.customer_id as customer_id, COUNT(v.visit_id) count_no_trans
From Visits as v
LEFT JOIN Transactions as t
ON v.visit_id = t.visit_id
Where t.transaction_id is NULL
Group BY v.customer_id;