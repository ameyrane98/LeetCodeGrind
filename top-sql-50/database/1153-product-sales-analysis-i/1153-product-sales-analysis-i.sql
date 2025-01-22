# Write your MySQL query statement below
Select p.product_name, s.year, s.price From Sales as s Join Product as p on s.product_id =p.product_id ;