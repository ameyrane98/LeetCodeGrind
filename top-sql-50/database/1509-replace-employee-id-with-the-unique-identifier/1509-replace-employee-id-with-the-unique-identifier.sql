# Write your MySQL query statement below
Select eI.unique_id,ep.name from Employees as ep  LEFT Join EmployeeUNI as eI On ep.id=eI.id;