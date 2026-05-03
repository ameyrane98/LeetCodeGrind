# Write your MySQL query statement below
Select W1.id
From Weather as W1
Left JOIN Weather as W2 
ON DATEDIFF(W1.recordDate, W2.recordDate) = 1
where W1.temperature> W2.temperature;