# Write your MySQL query statement below
Select p.product_name, s.year, s.price 
from Sales as s 
Left Join Product as p on p.product_id= s.product_id;