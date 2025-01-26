# Write your MySQL query statement below

Select P.project_id
    , Round(Avg(E.experience_years),2) as average_years
    from Project as P left join Employee as E on P.employee_id=E.employee_id
Group by P.project_id;
