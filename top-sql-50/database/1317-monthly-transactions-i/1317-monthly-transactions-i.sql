# Write your MySQL query statement below
Select DATE_FORMAT(trans_date ,'%Y-%m') as month
        ,country
        ,Count(*) as trans_count  
        , Sum(Case When state="approved" then 1 else 0 End) as approved_count
        , Sum(amount)  as trans_total_amount 
        , Sum(Case When state="approved" then amount else 0 End)  as approved_total_amount 
From Transactions  Group by  DATE_FORMAT(trans_date, '%Y-%m'), country;