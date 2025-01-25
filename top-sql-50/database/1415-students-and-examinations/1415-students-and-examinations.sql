# Write your MySQL query statement below
Select st.student_id, st.student_name,sub.subject_name, Count(Ex.student_id) as attended_exams from Students st 
Cross Join Subjects as sub
LEFT JOIN Examinations as Ex 
On st.student_id=Ex.student_id  and Ex.subject_name=sub.subject_name 
Group by st.student_id, st.student_name,sub.subject_name
ORDER BY st.student_id, sub.subject_name;
