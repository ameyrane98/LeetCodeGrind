# Write your MySQL query statement below

select a1.machine_id, round(avg(a2.timestamp-a1.timestamp),3) as processing_time From Activity a1  
Join Activity a2 on a1.machine_id=a2.machine_id  and a1.process_id= a2.process_id Where a2.activity_type="end" and a1.activity_type="start" group by a1.machine_id

