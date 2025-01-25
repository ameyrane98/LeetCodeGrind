# Write your MySQL query statement below
Select S.user_id
        ,Round(IfNull(Sum(Case when C.action="confirmed" then 1 Else 0 END)/Count(C.user_id),0),2) as confirmation_rate

 From Signups as S LEft Join Confirmations as C on S.user_id=C.user_id Group by S.user_id;